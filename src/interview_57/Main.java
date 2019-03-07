package interview_57;

import interview_57.model.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2019/3/6.
 *
 * @author DuanJiaNing
 */
public class Main {

    public static void main(String[] args) {

        // 原材料及其生产信息
        RawMaterial RAW_EUCALYPTUS_001 = new RawMaterial("RAW_EUCALYPTUS_001", Arrays.asList(
                new SupplyTimeIntervalAndQTY("RAW_EUCALYPTUS_001",
                        new TimeInterval(
                                Utils.getDate(2014, 02, 04, 0, 0, 0),
                                Utils.getDate(2014, 11, 31, 0, 0, 0)),
                        6000),
                new SupplyTimeIntervalAndQTY("RAW_EUCALYPTUS_001",
                        new TimeInterval(
                                Utils.getDate(2015, 02, 01, 0, 0, 0),
                                Utils.getDate(2038, 01, 19, 0, 0, 0)),
                        6000)));

        RawMaterial RAW_ROSE_005 = new RawMaterial("RAW_ROSE_005", Arrays.asList(
                new SupplyTimeIntervalAndQTY("RAW_ROSE_005",
                        new TimeInterval(
                                Utils.getDate(2014, 10, 01, 0, 0, 0),
                                Utils.getDate(2014, 10, 31, 0, 0, 0)),
                        18),
                new SupplyTimeIntervalAndQTY("RAW_ROSE_005",
                        new TimeInterval(
                                Utils.getDate(2015, 01, 01, 0, 0, 0),
                                Utils.getDate(2015, 01, 31, 0, 0, 0)),
                        666)));

        RawMaterial CAPACITY = new RawMaterial("CAPACITY", Arrays.asList(
                new SupplyTimeIntervalAndQTY("CAPACITY",
                        new TimeInterval(
                                Utils.getDate(2014, 02, 04, 0, 0, 0),
                                Utils.getDate(2015, 01, 15, 0, 0, 0)),
                        999)));

        // 产品及其所需的原材料信息
        ProductA p98100201 = new ProductA("98100201", Arrays.asList(
                new ProductRawMaterials(RAW_ROSE_005.getId(), 14),
                new ProductRawMaterials(CAPACITY.getId(), 1)));

        ProductA p98102601 = new ProductA("98102601", Arrays.asList(
                new ProductRawMaterials(RAW_ROSE_005.getId(), 12),
                new ProductRawMaterials(CAPACITY.getId(), 1),
                new ProductRawMaterials(RAW_EUCALYPTUS_001.getId(), 4)));

        // 计算产品可供货时间段，供货量
        ProductSupplyResolver resolver = new ProductSupplyResolver(Arrays.asList(
                RAW_EUCALYPTUS_001, RAW_ROSE_005, CAPACITY));

        List<SupplyTimeIntervalAndQTY> resolver1 = resolver.resolve(p98100201);
        List<SupplyTimeIntervalAndQTY> resolver2 = resolver.resolve(p98102601);

        System.out.printf("%4s%17s%18s%16s\n", "产品", "起始供货时间", "结束供货时间", "可供货量");
        print(resolver1);
        print(resolver2);

    }

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static void print(List<SupplyTimeIntervalAndQTY> qtyList) {
        qtyList.forEach(aty -> System.out.printf("%10s%25s%25s%8s\n",
                aty.getProductId(),
                dateFormat.format(aty.getTimeInterval().getStartTime()),
                dateFormat.format(aty.getTimeInterval().getEndTime()),
                aty.getCount()));
    }

}
