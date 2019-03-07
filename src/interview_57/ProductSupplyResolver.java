package interview_57;

import interview_57.model.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2019/3/6.
 *
 * @author DuanJiaNing
 */
public class ProductSupplyResolver {

    private List<RawMaterial> rawMaterials;

    private static final TimeInterval COMBINE_PRESENT = new TimeInterval();
    private List<TimeInterval> combineList = new ArrayList<>();

    public ProductSupplyResolver(List<RawMaterial> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public List<SupplyTimeIntervalAndQTY> resolve(ProductA productA) {

        // 找出当前产品需要的原材料
        List<RawMaterial> neededMaterials = new ArrayList<>();
        Map<String, RawMaterial> rawMMap = rawMaterials.stream().collect(Collectors.toMap(RawMaterial::getId, v -> v));
        productA.getProductRawMaterials().forEach(prm -> neededMaterials.add(rawMMap.get(prm.getRawMaterialId())));

        // 计算产品可供货时间段: 找出所有所需原材料生产时间的交集
        Map<TimeInterval, List<SupplyTimeIntervalAndQTY>> intersection = findIntersection(neededMaterials);
        if (intersection == null || intersection.size() == 0) {
            return null;
        }

        // 计算供货量: 供货量及与产品和交集的对应关系
        Map<String, Integer> productRawMaterialsCount = productA.getProductRawMaterials().stream()
                .collect(Collectors.toMap(ProductRawMaterials::getRawMaterialId, ProductRawMaterials::getCount));
        List<SupplyTimeIntervalAndQTY> res = new ArrayList<>(intersection.size());
        for (Map.Entry<TimeInterval, List<SupplyTimeIntervalAndQTY>> entry : intersection.entrySet()) {
            int count = Integer.MAX_VALUE; // 日产量
            for (SupplyTimeIntervalAndQTY qty : entry.getValue()) {
                int productCount = qty.getCount() / productRawMaterialsCount.get(qty.getProductId());
                if (productCount < count)
                    count = productCount;
            }

            SupplyTimeIntervalAndQTY resQty = new SupplyTimeIntervalAndQTY(productA.getId(), entry.getKey(), count);
            res.add(resQty);
        }

        return res;
    }

    /**
     * 找出所有所需原材料生产时间的交集（多个）
     *
     * @param rawMaterials 所需原材料的生产时间信息
     * @return map 中的 key（TimeInterval） 是时间交集，value（List<SupplyTimeIntervalAndQTY>） 是指该交集具体是哪几个时间
     * 段的
     */
    private Map<TimeInterval, List<SupplyTimeIntervalAndQTY>> findIntersection(List<RawMaterial> rawMaterials) {

        // 保存涉及到的所有 [时间段] 与其所属 [原材料供应信息] 的对应关系
        Map<TimeInterval, SupplyTimeIntervalAndQTY> map = new HashMap<>();
        rawMaterials.forEach(rm -> rm.getSupplyTimeIntervalAndQTIES().forEach(st -> {
            map.put(st.getTimeInterval(), st);
        }));

        // 所有 [时间段] 的排列组合
        TimeInterval[] items = new TimeInterval[map.size()];
        int i = 0;
        for (TimeInterval timeInterval : map.keySet()) {
            items[i++] = timeInterval;
        }

        int rawMCateCount = rawMaterials.size();
        List<TimeInterval> combineTempList = new ArrayList<>(rawMCateCount);
        for (int j = 0; j < rawMCateCount; j++) {
            combineTempList.add(COMBINE_PRESENT);
        }
        combineTimeInterval(combineTempList, items, rawMCateCount);

        // 计算 [时间段] 交集
        Map<TimeInterval, List<SupplyTimeIntervalAndQTY>> res = new HashMap<>();
        Iterator<TimeInterval> tempIterator = combineList.iterator();
        while (tempIterator.hasNext()) {
            TimeInterval[] ts = new TimeInterval[rawMCateCount];
            Set<SupplyTimeIntervalAndQTY> st = new TreeSet<>((o1, o2) ->
                    o1.getProductId().equals(o2.getProductId()) ? 0 : 1); // ProductId 相同即对应到相同的原材料，丢弃这类组合
            for (int j = 0; j < rawMCateCount; j++) { // 按原材料的类型个数进行分组（与排列组合所得数据结构相关）
                TimeInterval timeInterval = tempIterator.next();
                ts[j] = timeInterval;
                st.add(map.get(timeInterval));
            }

            if (st.size() == rawMCateCount) {
                TimeInterval ti = findIntersection(ts);
                if (ti != null) {
                    // 覆写 TimeInterval#equals&hashCode 以去除 123 321 的组合
                    res.put(ti, new ArrayList<>(st));
                }
            }
        }

        return res;
    }

    // 找出时间交集
    private TimeInterval findIntersection(TimeInterval[] ts) {
        Set<TimeInterval> descSortedSet = new TreeSet<>((o1, o2) -> {
            long d1 = Utils.calcTimeDurationInDays(o1);
            long d2 = Utils.calcTimeDurationInDays(o2);
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

    private void combineTimeInterval(List<TimeInterval> tempIntervalList, TimeInterval[] intervals, int n) {
        if (n == 0) {
            combineList.addAll(tempIntervalList);
            return;
        }

        for (TimeInterval interval : intervals) {
            if (!tempIntervalList.contains(interval)) {
                tempIntervalList.set(tempIntervalList.size() - n, interval);
            } else {
                continue;
            }

            combineTimeInterval(tempIntervalList, intervals, n - 1);
            tempIntervalList.set(tempIntervalList.size() - n, COMBINE_PRESENT);
        }
    }

}
