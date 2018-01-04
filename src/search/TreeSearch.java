package search;

import datastructure.stack.ArrayStack;
import datastructure.stack.LinkedStack;
import datastructure.stack.Stack;

import java.lang.reflect.Array;

/**
 * Created on 2017/12/19.
 *
 * @author DuanJiaNing
 */
public class TreeSearch<T extends Comparable<T>> {

    private Node<T> root;
    private final int size;

    public TreeSearch(T[] values) {
        this.size = values.length;
        root = new Node<>(values[0], null, null);
        for (int i = 1; i < values.length; i++) {
            T value = values[i];
            Node<T> current = root;
            Node<T> parent;
            for (; ; ) {
                if (value.compareTo(current.value) < 0) {
                    parent = current;
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node<>(value, null, null);
                        break;
                    }
                } else {
                    parent = current;
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node<>(value, null, null);
                        break;
                    }
                }
            }
        }
    }


    @SuppressWarnings("unchecked")
    public T[] path(T value) {

        Stack<Node<T>> stack = new LinkedStack<>();
        T[] res = (T[]) Array.newInstance(value.getClass(), size);
        stack.push(root);
        Node<T> current = null;
        while (!(current != null && current.value.equals(value))) {
            //先左后右
            current = stack.pop();
//            stack.push();
        }

        return res;
    }


    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return value + " [" + (left == null ? "null" : left) + "] " + "[" + (right == null ? "null" : right) + "]";
        }
    }

    @Override
    public String toString() {
        return root == null ? "null" : root.toString();
    }
}
