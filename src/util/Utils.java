package util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created on 2017/12/13.
 *
 * @author DuanJiaNing
 */
public class Utils {

    public static <T> T[] ensureCapacity(T[] values, int count) {
        if (count >= values.length - 1) {
            int newLength = count + (count >> 1);
            if (newLength > Integer.MAX_VALUE - 8) {
                throw new IndexOutOfBoundsException();
            }
            values = Arrays.copyOf(values, newLength);
        }

        return values;
    }


    public static Integer[] getRandomIntegers(int count, int bound) {
        Random r = new Random();
        Integer[] is = new Integer[count];
        for (int i = 0; i < count; i++) {
            is[i] = r.nextInt(bound);
        }
        return is;
    }
}
