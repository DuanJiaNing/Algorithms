package util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Created by DuanJiaNing on 2017/9/3.
 */
public class P {
    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss-SSS");

    public static void out(Object obj) {
        System.out.println(format.format(new Date()) + " " + obj);
    }

    public static void out(Object[] arr) {
        System.out.println(format.format(new Date()) + " " + Arrays.toString(arr));
    }

    public static void outnl(Object obj) {
        System.out.printf(format.format(new Date()) + " " + obj);
    }

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

    public static Integer[] getRandomArrays(int size, int bound) {
        Random r = new Random();
        Integer[] is = new Integer[size];
        for (int i = 0; i < size; i++) {
            is[i] = r.nextInt(bound);
        }

        return is;
    }

}
