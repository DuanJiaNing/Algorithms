package datastructure.heap;

import util.Utils;

import java.lang.reflect.Array;

/**
 * Created on 2017/12/13.
 * 最小堆
 *
 * @author DuanJiaNing
 */
public class MiniArrayHeap<T extends Comparable> implements ArrayHeap<T> {

    private int count = 0;
    private Object[] values;

    public MiniArrayHeap() {
        values = new Object[16];
    }

    @Override
    @SuppressWarnings("unchecked")
    public void shiftUp(int index) {
        // 参照堆的结构可知，用数组结果存储节点数据时根节点对应的下标为1，对应到数组的下标则应该为0
        // 因而这里需要 index + 1
        int i = index + 1;
        while (i / 2 >= 1) {
            int rootIndex = i / 2 - 1;
            int currentIndex = i - 1;

            T root = (T) values[rootIndex];
            T current = (T) values[currentIndex];

            if (current.compareTo(root) < 0) {
                swap(rootIndex, currentIndex);
                i = i / 2;
            } else {
                break;
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void shiftDown(int index) {
        int i = index + 1;
        while (i * 2 <= count) {
            int leftChildIndex = i * 2 - 1;
            int rightChildIndex = i * 2;
            int minIndex = leftChildIndex;
            if (rightChildIndex <= count - 1 && ((T) values[leftChildIndex]).compareTo(values[rightChildIndex]) > 0) {
                minIndex = rightChildIndex;
            }

            if (((T) values[i - 1]).compareTo(values[minIndex]) > 0) {
                swap(i - 1, minIndex);
                i = minIndex + 1;
            } else {
                break;
            }

        }
    }

    @Override
    public void push(T t) {
        values = Utils.ensureCapacity(values, count);
        values[count++] = t;
        shiftUp(count - 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (count > 0) {
            T t = (T) values[0];
            values[0] = values[count - 1];
            values[count - 1] = null;
            count--;

            shiftDown(0);
            return t;
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getTop() {
        return count > 0 ? (T) values[0] : null;
    }

    @Override
    public int size() {
        return count;
    }

    @SuppressWarnings("unchecked")
    private void swap(int a, int b) {
        T temp = (T) values[a];
        values[a] = values[b];
        values[b] = temp;
    }

    @SuppressWarnings("unchecked")
    public T[] getValues(Class<T> type) {
        T[] result = (T[]) Array.newInstance(type, values.length);
        for (int i = 0; i < values.length; i++) {
            result[i] = (T) values[i];
        }
        return result;
    }

}
