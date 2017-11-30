package sort.bubble;

import sort.Sortable;

import java.util.Comparator;

/**
 * Created on 2017/11/29.
 * 冒泡排序
 *
 * @author DuanJiaNing
 */
public class BubbleSort<T> implements Sortable<T> {

    @Override
    public int sort(T[] sour, Comparator<T> comparator) {
        int count = 0;
        T current, after;

        // 当一次遍历没有任何元素交换发生，表明数组已经有序，无需继续遍历
        boolean needIterator;

        for (int i = 0; i < sour.length - 1; i++) {
            needIterator = false;
            for (int j = i + 1; j < sour.length; j++) {
                current = sour[i];
                after = sour[j];
                if (comparator.compare(current, after) > 0) { // current > after
                    sour[i] = after;
                    sour[j] = current;

                    count++;
                    needIterator = true;
                }
            }
            if (!needIterator) {
                break;
            }
        }
        return count;
    }
}
