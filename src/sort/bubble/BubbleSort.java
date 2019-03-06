package sort.bubble;

import sort.Sortable;
import util.P;

import java.util.Arrays;
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
            for (int j = 0; j < sour.length - 1 - i; j++) {
                current = sour[j];
                after = sour[j + 1];
                if (comparator.compare(current, after) < 0) {
                    sour[j] = after;
                    sour[j + 1] = current;

                    count++;
                    needIterator = true;
                }
            }
            if (!needIterator)
                break;

        }
        return count;

//        for (int i = 0; i < sour.length - 1; i++) {
//            needIterator = false;
//            for (int j = i + 1; j < sour.length; j++) {
//                current = sour[i];
//                after = sour[j];
//                if (comparator.compare(current, after) > 0) { // current > after
//                    sour[i] = after;
//                    sour[j] = current;
//
//                    count++;
//                    needIterator = true;
//                }
//            }
//            if (!needIterator) {
//                break;
//            }
//        }
    }

    public static void main(String[] args) {
        BubbleSort<Integer> sort = new BubbleSort<>();
        Integer[] array = new Integer[]{5,4,3,1};
        P.out(sort.sort(array, Integer::compareTo));
        P.out(array);
    }
}
