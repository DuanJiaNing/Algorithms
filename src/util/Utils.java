package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

/**
 * Created by DuanJiaNing on 2017/9/3.
 */
public class Utils {

    public static final Consumer<CharSequence> P = c -> System.out.print(c.toString());

    public static <T> void swap(int i, int j, T[] arr) {
        T a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    public static void swap(int i, int j, int[] arr) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    public static String currentTime() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return f.format(new Date(System.currentTimeMillis()));
    }

    public static void log(CharSequence msg) {
        P.accept(currentTime() + ": " + msg + "\n");
    }

}
