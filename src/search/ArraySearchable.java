package search;

/**
 * Created on 2017/12/1.
 * 数组结构的搜索
 *
 * @author DuanJiaNing
 */
public interface ArraySearchable<T> {

    /**
     * 找出目标元素在数组中的下标
     *
     * @return 下标，未找到返回 -1
     */
    int search(T[] sour, T e);

}
