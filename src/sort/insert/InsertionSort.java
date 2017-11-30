package sort.insert;

import sort.Sortable;

import java.util.Comparator;

/**
 * Created on 2017/11/29.
 * 插入排序
 *
 * @author DuanJiaNing
 */
public class InsertionSort<T> implements Sortable<T> {

    @Override
    public int sort(T[] sour, Comparator<T> comparator) {
        int count = 0;
        T current, before;

        for (int i = 1; i < sour.length; i++) {
            current = sour[i];
            for (int j = i; j > 0; j--) {
                before = sour[j - 1];
                if (comparator.compare(current, before) < 0) { // current < before
                    sour[j - 1] = current;
                    sour[j] = before;

                    count++;
                } else {
                    //如果 current > before ，则表明元素已经在正确的位置，无需继续往前遍历
                    break;
                }
            }
        }
        return count;
    }

}
