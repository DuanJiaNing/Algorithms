package sort.quick;

import sort.Sortable;

import java.util.Comparator;

/**
 * Created on 2017/11/29.
 * 冒泡排序
 *
 * @author DuanJiaNing
 */
public class QuickSort<T> implements Sortable<T> {

    private int count;
    private Comparator<T> comparator;

    @Override
    public int sort(T[] sour, Comparator<T> comparator) {
        this.comparator = comparator;
        this.count = 0;
        quickSort(sour, 0, sour.length - 1);
        return count;
    }

    /**
     * 递归快速排序
     * h0t8 入
     * 1 8 9 4 .3. 4 3 2 1
     * i1j8 前
     * 1 .1 9 4 .3. 4 3 2 .8
     * i2j7 后
     *
     * i2j7
     * 1 1 .2 4 .3. 4 3 .9 8
     * i3j6
     *
     * i3j6
     * 1 1 2 .3 .3. 4 .4 9 8
     * i4j5
     *
     * i5j5 -> end
     */
    private void quickSort(T[] sour, int head, int tail) {
        // head >= tail 注意为 >=，如果只为 > ，将无法跳出递归
        if (head >= tail || sour == null || sour.length < 1) {
            return;
        }

        int i = head, j = tail;
        T pivot = sour[(head + tail) / 2];
        while (i <= j) {
            // 从前往后找到第一个不小于“基准”的元素
            while (comparator.compare(sour[i], pivot) < 0) { // sour < pivot
                i++;
            }

            // 从后往前找到第一个不大于“基准”的元素
            while (comparator.compare(sour[j], pivot) > 0) { // sour > pivot
                j--;
            }

            // 如果找到，交换这两个元素
            if (i < j) {
                T temp = sour[i];
                sour[i] = sour[j];
                sour[j] = temp;
                i++;
                j--;

                count++;
            } else if (i == j) {
                i++;
            }
        }
        quickSort(sour, head, j);
        quickSort(sour, i, tail);
    }
}
