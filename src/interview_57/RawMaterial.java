package interview_57;

import java.util.List;

/**
 * Created on 2019/3/6.
 * 原材料、其供应时间和数量
 *
 * @author DuanJiaNing
 */
public class RawMaterial extends Product {

    private List<SupplyTimeIntervalAndQTY> supplyTimeIntervalAndQTIES;

    public RawMaterial() {
    }

    public RawMaterial(String id, List<SupplyTimeIntervalAndQTY> supplyTimeIntervalAndQTIES) {
        super(id);
        this.supplyTimeIntervalAndQTIES = supplyTimeIntervalAndQTIES;
    }

    public List<SupplyTimeIntervalAndQTY> getSupplyTimeIntervalAndQTIES() {
        return supplyTimeIntervalAndQTIES;
    }

    public void setSupplyTimeIntervalAndQTIES(List<SupplyTimeIntervalAndQTY> supplyTimeIntervalAndQTIES) {
        this.supplyTimeIntervalAndQTIES = supplyTimeIntervalAndQTIES;
    }
}
