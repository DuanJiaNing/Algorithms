package sort.heap;

import data.heap.ArrayHeap;
import sort.Sortable;
import util.P;

import java.util.Comparator;

/**
 * Created on 2017/11/29.
 * 堆排序
 *
 * @author DuanJiaNing
 */
public class HeapSort {

    public <E extends Comparable> void sort(ArrayHeap<E> heap, E[] sour) {
        for (E e : sour) {
            heap.push(e);
        }
        for (int i = 0; i < sour.length; i++) {
            sour[i] = heap.pop();
        }
    }
}
