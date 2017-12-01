package search.binary;

import search.ArraySearchable;

/**
 * Created by DuanJiaNing on 2017/9/3.
 * 数组需要已排序且为升序（compareTo > 1）
 */
public class BinarySearch<T extends Comparable<T>> implements ArraySearchable<T> {

    private final boolean recursive;

    public BinarySearch(boolean recursive) {
        this.recursive = recursive;
    }

    @Override
    public int search(T[] sour, T e) {
        return recursive ? searchBasedOnRecursive(sour, 0, sour.length - 1, e)
                : searchBasedOnIterator(sour, e);
    }

    // while 循环实现
    private int searchBasedOnIterator(T[] sour, T e) {
        int first = 0;
        int last = sour.length - 1;

        while (first <= last) {
            int middle = first + (last - first) / 2;
            T me = sour[middle];
            if (me.equals(e)) {
                return middle;
            }

            if (me.compareTo(e) > 0) { // me > e 升序
                last = middle - 1;
            } else {
                first = middle + 1;
            }

        }

        return -1;
    }

    // 递归实现
    private int searchBasedOnRecursive(T[] sour, int first, int last, T e) {
        if (first > last) {
            return -1;
        }

        int middle = first + (last - first) / 2;
        T me = sour[middle];

        if (me.compareTo(e) > 0) { // me > e
            return searchBasedOnRecursive(sour, first, middle - 1, e);
        }

        if (me.compareTo(e) < 0) {
            return searchBasedOnRecursive(sour, middle + 1, last, e);
        }

        if (me.equals(e)) {
            return middle;  //最後檢測相等是因為多數搜尋狀況不是大於要不就小於
        }

        return -1;
    }

}
