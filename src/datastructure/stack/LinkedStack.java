package datastructure.stack;

/**
 * Created on 2017/12/7.
 *
 * @author DuanJiaNing
 */
public class LinkedStack<T> implements Stack<T> {

    private Node<T> top;
    private int count;

    @Override
    public void push(T value) {
        top = new Node<>(value, top);
        count++;
    }

    @Override
    public T pop() {
        if (top == null) {
            return null;
        }

        T value = top.value;
        top = top.under;
        count--;

        return value;
    }

    @Override
    public int size() {
        return count;
    }

    private static class Node<T> {
        T value;
        Node<T> under;

        Node(T value, Node<T> under) {
            this.value = value;
            this.under = under;
        }
    }
}
