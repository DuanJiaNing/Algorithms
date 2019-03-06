package interview_57;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2019/3/6.
 *
 * @author DuanJiaNing
 */
public class Main {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        RawMaterial RAW_EUCALYPTUS_001 = new RawMaterial("RAW_EUCALYPTUS_001", Arrays.asList(
                new SupplyTimeIntervalAndQTY("RAW_EUCALYPTUS_001",
                        getTI("2014–02–04 00:00:00", "2014–11–31 00:00:00"), 6000),
                new SupplyTimeIntervalAndQTY("RAW_EUCALYPTUS_001",
                        getTI("2015–02–01 00:00:00", "2038–01–19 00:00:00"), 6000)));

        RawMaterial RAW_ROSE_005 = new RawMaterial("RAW_ROSE_005", Arrays.asList(
                new SupplyTimeIntervalAndQTY("RAW_ROSE_005",
                        getTI("2014–10–01 00:00:00", "2014–10–31 00:00:00"), 18),
                new SupplyTimeIntervalAndQTY("RAW_ROSE_005",
                        getTI("2015–01–01 00:00:00", "2015–01–31 00:00:00"), 666)));

        RawMaterial CAPACITY = new RawMaterial("CAPACITY", Arrays.asList(
                new SupplyTimeIntervalAndQTY("CAPACITY",
                        getTI("2014–02–04 00:00:00", "2015–01–15 00:00:00"), 999)));

        ProductA p98100201 = new ProductA("98100201", Arrays.asList(
                new ProductRawMaterials(RAW_ROSE_005.getId(), 14),
                new ProductRawMaterials(CAPACITY.getId(), 1)));

        ProductA p98102601 = new ProductA("98102601", Arrays.asList(
                new ProductRawMaterials(RAW_ROSE_005.getId(), 12),
                new ProductRawMaterials(CAPACITY.getId(), 1),
                new ProductRawMaterials(RAW_EUCALYPTUS_001.getId(), 4)));

        ProductSupplyResolver resolver = new ProductSupplyResolver(Arrays.asList(
                RAW_EUCALYPTUS_001, RAW_ROSE_005, CAPACITY));

        List<SupplyTimeIntervalAndQTY> resolver1 = resolver.resolver(p98100201);
        List<SupplyTimeIntervalAndQTY> resolver2 = resolver.resolver(p98102601);

    }

    private static TimeInterval getTI(String start, String end) {
        try {
            return new TimeInterval(simpleDateFormat.parse(start), simpleDateFormat.parse(end));
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }

}
