package data.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created on 2017/12/7.
 *
 * @author DuanJiaNing
 */
public class ArrayStack<T> implements Stack<T> {

    private int size = 0;
    private int count = 0;
    private T[] values;

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<T> type) {
        size = 16;
        values = (T[]) Array.newInstance(type, size);
    }

    @Override
    public void push(T value) {
        ensureCapacity();
        values[count++] = value;
    }

    @Override
    public T pop() {
        if (size == 0) {
            return null;
        } else {
            return values[--count];
        }
    }

    @Override
    public int size() {
        return count;
    }


    private void ensureCapacity() {
        if (count >= values.length - 1) {
            int newLength = size + (size >> 1);
            if (newLength > Integer.MAX_VALUE - 8) {
                throw new IndexOutOfBoundsException();
            }
            values = Arrays.copyOf(values, newLength);
            size = values.length;
        }
    }


}
