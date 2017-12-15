package datastructure.stack;

/**
 * Created on 2017/12/7.
 * 堆栈结构方法定义
 *
 * @author DuanJiaNing
 */
public interface Stack<T> {

    /**
     * 将数据放入堆叠的顶端（栈顶）
     *
     * @param value
     */
    void push(T value);

    /**
     * 将顶端数据资料输出（回传）
     *
     * @return
     */
    T pop();

    /**
     * 堆栈元素个数
     *
     * @return
     */
    int size();

}
