package sort;

import java.util.Comparator;

/**
 * Created on 2017/11/29.
 *
 * @author DuanJiaNing
 */
public interface Sortable<T> {

    /**
     * 将数组进行排序
     *
     * @param sour       待排序的数组
     * @param comparator 排序规则
     * @return 数组中元素交换次数
     */
    int sort(T[] sour, Comparator<T> comparator);

}
