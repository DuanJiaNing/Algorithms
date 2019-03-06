package interview_57;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2019/3/6.
 *
 * @author DuanJiaNing
 */
public class ProductSupplyResolver {

    private List<RawMaterial> rawMaterials;

    private List<TimeInterval> combineList = new ArrayList<>();

    public ProductSupplyResolver(List<RawMaterial> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public List<SupplyTimeIntervalAndQTY> resolver(ProductA productA) {

        Map<String, RawMaterial> rawMMap = rawMaterials.stream().collect(Collectors.toMap(RawMaterial::getId, v -> v));
        Map<String, Integer> productRawMaterialsCount = productA.getProductRawMaterials().stream()
                .collect(Collectors.toMap(ProductRawMaterials::getRawMaterialId, ProductRawMaterials::getCount));
        List<ProductRawMaterials> productRawMaterials = productA.getProductRawMaterials();

        List<RawMaterial> neededMaterials = new ArrayList<>();
        productRawMaterials.forEach(prm -> neededMaterials.add(rawMMap.get(prm.getRawMaterialId())));

        Map<TimeInterval, List<SupplyTimeIntervalAndQTY>> intersection = findIntersection(neededMaterials);

        List<SupplyTimeIntervalAndQTY> res = new ArrayList<>(intersection.size());
        for (Map.Entry<TimeInterval, List<SupplyTimeIntervalAndQTY>> entry : intersection.entrySet()) {
            int count = Integer.MAX_VALUE;
            long days = calcTimeDurationInDays(entry.getKey());
            for (SupplyTimeIntervalAndQTY qty : entry.getValue()) {
                int c = qty.getCount() * (int) days;

                // 这段时间内生产的原材料能够支撑的产品量
                int productCount = c / productRawMaterialsCount.get(qty.getProductId());
                if (productCount < count)
                    count = productCount;
            }

            SupplyTimeIntervalAndQTY resQty = new SupplyTimeIntervalAndQTY(productA.getId(), entry.getKey(), count);
            res.add(resQty);
        }

        return res;
    }

    /**
     * 找出时间交集
     *
     * @param rawMaterials 原材料的生产时间信息
     * @return map 中的 key（TimeInterval） 是时间交集，value 是具体哪些时间段的交集
     */
    public Map<TimeInterval, List<SupplyTimeIntervalAndQTY>> findIntersection(List<RawMaterial> rawMaterials) {

        Map<TimeInterval, SupplyTimeIntervalAndQTY> map = new HashMap<>();
        rawMaterials.forEach(rm -> rm.getSupplyTimeIntervalAndQTIES().forEach(st -> {
            map.put(st.getTimeInterval(), st);
        }));

        TimeInterval[] items = new TimeInterval[map.size()];
        int i = 0;
        for (TimeInterval timeInterval : map.keySet()) {
            items[i++] = timeInterval;
        }

        int rawMCateCount = rawMaterials.size();
        List<TimeInterval> combineTempList = new ArrayList<>(rawMCateCount);
        for (int j = 0; j < rawMCateCount; j++) {
            combineTempList.add(new TimeInterval());
        }
        // 所有的排列组合
        combineTimeInterval(combineTempList, items, rawMCateCount);

        Map<TimeInterval, List<SupplyTimeIntervalAndQTY>> res = new HashMap<>();
        Iterator<TimeInterval> tempIterator = combineList.iterator();
        while (tempIterator.hasNext()) {
            TimeInterval[] ts = new TimeInterval[rawMCateCount];
            Set<SupplyTimeIntervalAndQTY> st = new TreeSet<>((o1, o2) -> o1.getProductId().equals(o2.getProductId()) ? 0 : 1);
            for (int j = 0; j < rawMCateCount; j++) {
                TimeInterval timeInterval = tempIterator.next();
                ts[j] = timeInterval;
                st.add(map.get(timeInterval));
            }

            if (st.size() == rawMCateCount) {
                TimeInterval ti = findIntersection(ts);
                if (ti != null) {
                    res.put(ti, new ArrayList<>(st));
                }
            }
        }

        return res;
    }

    // 找出时间交集
    private TimeInterval findIntersection(TimeInterval[] ts) {
        Set<TimeInterval> descSortedSet = new TreeSet<>((o1, o2) -> {
            long d1 = calcTimeDurationInDays(o1);
            long d2 = calcTimeDurationInDays(o2);
            return Long.compare(d1, d2);
        });
        descSortedSet.addAll(Arrays.asList(ts));

        Iterator<TimeInterval> iterator = descSortedSet.iterator();
        TimeInterval first = iterator.next();
        Date from = first.getStartTime(), to = first.getEndTime();

        while (iterator.hasNext()) {
            TimeInterval item = iterator.next();
            Date startTime = item.getStartTime();
            Date endTime = item.getEndTime();
            if (startTime.after(to) || endTime.before(from)) {
                return null;
            }

            if (startTime.after(from)) {
                from = startTime;
            }

            if (endTime.before(to)) {
                to = endTime;
            }
        }

        return new TimeInterval(from, to);
    }

    private void combineTimeInterval(List<TimeInterval> list, TimeInterval[] chars, int n) {
        if (n == 0) {
            combineList.addAll(list);
            return;
        }

        for (TimeInterval aChar : chars) {
            if (!list.contains(aChar)) {
                list.set(list.size() - n, aChar);
            } else {
                continue;
            }

            combineTimeInterval(list, chars, n - 1);
            list.set(list.size() - n, new TimeInterval());
        }
    }

    public long calcTimeDurationInDays(TimeInterval interval) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(interval.getStartTime());
        LocalDateTime from = LocalDateTime.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));

        calendar.setTime(interval.getEndTime());
        LocalDateTime to = LocalDateTime.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));

        Duration duration = Duration.between(from, to);
        return duration.toDays();
    }

}
