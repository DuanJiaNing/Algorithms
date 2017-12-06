package sort.select;

import sort.Sortable;

import java.util.Comparator;

/**
 * Created on 2017/11/29.
 * 直接（简单）选择排序
 *
 * @author DuanJiaNing
 */
public class SelectionSort<T> implements Sortable<T> {

    @Override
    public int sort(T[] sour, Comparator<T> comparator) {
        int count = 0;
        int minIndex;
        for (int i = 0; i < sour.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < sour.length; j++) {
                if (comparator.compare(sour[j], sour[minIndex]) < 0) { // current < min
                    minIndex = j;
                }
            }

            if (minIndex > i) {
                T temp = sour[i];
                sour[i] = sour[minIndex];
                sour[minIndex] = temp;

                count++;
            }
        }

        return count;
    }

}
