package data.heap;

/**
 * Created on 2017/12/13.
 * 用数组实现的堆结构（完全二叉树）
 *
 * @author DuanJiaNing
 */
public interface ArrayHeap<T> {

    /**
     * 指定下标的元素上浮到其最终位置
     *
     * @param index 元素在数组中的下标
     */
    void shiftUp(int index);

    /**
     * 指定下标的元素下沉到其最终位置
     *
     * @param index 元素在数组中的下标
     */
    void shiftDown(int index);

    /**
     * 插入元素到其应该在的位置
     *
     * @param t 元素
     */
    void push(T t);

    /**
     * 弹出根元素，并从树中删除
     *
     * @return 元素
     */
    T pop();

    /**
     * 取得根元素
     *
     * @return 元素
     */
    T getTop();

    /**
     * 元素个数
     *
     * @return 个数
     */
    int size();
}
