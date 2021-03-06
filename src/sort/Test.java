package sort;

import datastructure.heap.MiniArrayHeap;
import sort.heap.HeapSort;
import sort.select.SelectionSort;
import util.P;

import java.util.Arrays;

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
        test2(s2);
    }

    // 测试堆排序
    private static void test2(Integer[] sour) {
        HeapSort heapSort = new HeapSort();
        P.out(sour);
        heapSort.sort(new MiniArrayHeap<>(), sour);
        P.out(sour);
    }

    private static void test1(Integer[] sour) {
        test(new SelectionSort<>(), sour); // 升序 交换 1 次
        test(new SelectionSort<>(), sour); // 升序 交换 5 次
    }

    private static <T extends Comparable> void test(Sortable<T> sortable, T... ts) {
        P.out(sortable.sort(ts, T::compareTo));
        P.out(Arrays.toString(ts));
    }

}
