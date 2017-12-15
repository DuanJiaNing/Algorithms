package sort.merge;

import util.P;
import util.Utils;

/**
 * Created on 2017/12/15.
 *
 * @author DuanJiaNing
 */
public class Test {


    public static void main(String[] args) {
        MergeSort<Integer> sort = new MergeSort<>(Integer.class);
        Integer[] sour = new Integer[]{6, 5, 3, 1, 8, 7, 2, 4};
        Integer[] integers = Utils.getRandomIntegers(8192, 1000);
        Integer[] sorted = sort.sort(integers, Integer::compareTo);
        P.out(sorted);
    }
}
