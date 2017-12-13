package data.stack;

import util.Utils;

import java.lang.reflect.Array;

/**
 * Created on 2017/12/7.
 *
 * @author DuanJiaNing
 */
public class ArrayStack<T> implements Stack<T> {

    private int count = 0;
    private T[] values;

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<T> type) {
        values = (T[]) Array.newInstance(type, 16);
    }

    @Override
    public void push(T value) {
        values = Utils.ensureCapacity(values, count);
        values[count++] = value;
    }

    @Override
    public T pop() {
        return count > 0 ? values[--count] : null;
    }

    @Override
    public int size() {
        return count;
    }

}
