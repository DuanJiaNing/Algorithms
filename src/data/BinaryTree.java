package data;

import util.Utils;

import java.util.Iterator;

/**
 * Created by DuanJiaNing on 2017/4/25.
 * //FIXME 不可变数据结构
 */
public class BinaryTree<T> implements Iterable<T> {

    private final int count;
    private final T[] values;
    private Node root;

    // 用于构造
    private int nextValueIndex = 0;

    public BinaryTree(T[] values) {
        this.count = values.length;
        this.values = values;

        // 先序构建二叉树
        if (values.length > 0) {
//            root = create(getData());
            create();
        }
    }

    private void create() {

        // 初始化所有结点
        Node[] nodes = new Node[count];
        for (int i = 0; i < count; i++) {
            nodes[i] = new Node(values[i]);
        }

    }


    private Node create(T data) {
        if (data == null) {
            return null;
        }

        Node node = new Node<T>();
        node.data = data;
        if (nextValueIndex % 2 == 0) {
            node.leftChild = create(getData());
        } else {
            node.rightChild = create(getData());
        }

        return node;
    }

    private T getData() {
        if (nextValueIndex == count) {
            return null;
        } else {
            T value = values[nextValueIndex];
            nextValueIndex++;
            return value;
        }
    }

    public Iterator dlrIterator() {
        return new DLRIterator();
    }

    public Iterator ldrIterator() {
        return new LDRIterator();
    }

    public Iterator lrdIterator() {
        return new LRDIterator();
    }

    @Override
    public Iterator<T> iterator() {
        return new DLRIterator();
    }

    public static class Node<T> {
        private Node<T> leftChild;
        private Node<T> rightChild;
        private T data;

        public Node(T value) {
            data = value;
            leftChild = null;
            rightChild = null;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public T getData() {
            return data;
        }

        public Node(Node<T> leftChild, Node<T> rightChild, T data) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.data = data;
        }

        public Node() {
        }
    }

    // 导出类只需为 values 赋值即可
    private abstract class AbstractIterator implements Iterator<T> {

        final T[] values;
        int index = 0;

        AbstractIterator() {
            values = assignment();
        }

        protected abstract T[] assignment();

        @Override
        public final boolean hasNext() {
            return index != 0;
        }

        @Override
        public final T next() {
            T data = values[index];
            index--;
            return data;
        }
    }

    private class DLRIterator extends AbstractIterator {

        //递归先序遍历
        private void dlr(Node<T> node) {
            if (node == null) {
                return;
            }

            values[index++] = node.data;
            Utils.log(node.data + " d");
            dlr(node.getLeftChild());
            dlr(node.getRightChild());
        }

        @Override
        protected T[] assignment() {
            dlr(root);
            return values;
        }
    }

    private class LDRIterator extends AbstractIterator {

        //递归中序遍历
        private void ldr(Node<T> node) {
            if (node == null)
                return;
            ldr(node.getLeftChild());
            values[index++] = node.data;
            ldr(node.getRightChild());
        }

        @Override
        protected T[] assignment() {
            ldr(root);
            return values;
        }
    }

    private class LRDIterator extends AbstractIterator {

        //递归后序遍历
        private void lrd(Node<T> node) {
            if (node == null)
                return;
            lrd(node.getLeftChild());
            lrd(node.getRightChild());
            values[index++] = node.data;
        }

        @Override
        protected T[] assignment() {
            lrd(root);
            return values;
        }
    }
}
