package interview_57;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2019/3/6.
 *
 * @author DuanJiaNing
 */
public class ProductSupplyResolver {

    private final List<RawMaterial> rawMaterials;

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
            long days = calcIntersectionInDays(entry.getKey());
            for (SupplyTimeIntervalAndQTY qty : entry.getValue()) {
                double countPreDay = (double) qty.getCount() / calcIntersectionInDays(qty.getTimeInterval());
                double c = Math.floor(countPreDay * days);
                int resCount = (int) (Math.floor(c / productRawMaterialsCount.get(qty.getProductId())));
                if (resCount < count)
                    count = resCount;
            }

            SupplyTimeIntervalAndQTY resQty = new SupplyTimeIntervalAndQTY(productA.getId(), entry.getKey(), count);
            res.add(resQty);
        }

        return res;
    }

    // 找出时间交集
    public Map<TimeInterval, List<SupplyTimeIntervalAndQTY>> findIntersection(List<RawMaterial> rawMaterials) {
        return null;
    }

    public long calcIntersectionInDays(TimeInterval interval) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(interval.getStartTime());
        LocalDateTime from = LocalDateTime.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));

        calendar.setTime(interval.getEndTime());
        LocalDateTime to = LocalDateTime.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));

        Duration duration = Duration.between(from, to);
        return duration.toDays();
    }

}
