package sort;

import sort.select.SelectionSort;
import util.P;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created on 2017/12/1.
 *
 * @author DuanJiaNing
 */
public class Test {

    public static void main(String[] args) {
        Integer[] s = {1, 8, 9, 4, 3, 4, 3, 2, 1};
        Integer[] s1 = {1, 2, 4, 3, 5, 7};
        Integer[] s2 = {1, -2, 22223, 489, 335, 23437, 3, 4, 56, 76, 98, 12, 3421, 654};
        Integer[] s3 = P.getRandomArrays(1000, 10000);
        test(new SelectionSort<>(), s1); // 升序 交换 1 次
        test(new SelectionSort<>(), s); // 升序 交换 5 次
    }

    private static <T extends Comparable> void test(Sortable<T> sortable, T... ts) {
        p.accept(sortable.sort(ts, T::compareTo));
        p.accept(Arrays.toString(ts));
    }

    private static Consumer<Object> p = System.out::println;

}
