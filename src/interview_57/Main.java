package interview_57;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created on 2019/3/6.
 *
 * @author DuanJiaNing
 */
public class Main {

    public static void main(String[] args) {

        RawMaterial RAW_EUCALYPTUS_001 = new RawMaterial("RAW_EUCALYPTUS_001", Arrays.asList(
                new SupplyTimeIntervalAndQTY("RAW_EUCALYPTUS_001", // 2014–11 月只有 30 天，题目有错
                        new TimeInterval(
                                getDate(2014, 02, 04, 0, 0, 0),
                                getDate(2014, 11, 31, 0, 0, 0)),
                        6000),
                new SupplyTimeIntervalAndQTY("RAW_EUCALYPTUS_001",
                        new TimeInterval(
                                getDate(2015, 02, 01, 0, 0, 0),
                                getDate(2038, 01, 19, 0, 0, 0)),
                        6000)));

        RawMaterial RAW_ROSE_005 = new RawMaterial("RAW_ROSE_005", Arrays.asList(
                new SupplyTimeIntervalAndQTY("RAW_ROSE_005",
                        new TimeInterval(
                                getDate(2014, 10, 01, 0, 0, 0),
                                getDate(2014, 10, 31, 0, 0, 0)),
                        18),
                new SupplyTimeIntervalAndQTY("RAW_ROSE_005",
                        new TimeInterval(
                                getDate(2015, 01, 01, 0, 0, 0),
                                getDate(2015, 01, 31, 0, 0, 0)),
                        666)));

        RawMaterial CAPACITY = new RawMaterial("CAPACITY", Arrays.asList(
                new SupplyTimeIntervalAndQTY("CAPACITY",
                        new TimeInterval(
                                getDate(2014, 02, 04, 0, 0, 0),
                                getDate(2015, 01, 15, 0, 0, 0)),
                        999)));

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

        System.out.println("Arrays.toString(resolver1) = " + Arrays.toString(resolver1.toArray()));
        System.out.println("Arrays.toString(resolver2) = " + Arrays.toString(resolver2.toArray()));

    }

    private static Date getDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);

        return calendar.getTime();
    }

}
