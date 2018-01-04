package datastructure.tree;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 2017/12/4.
 *
 * @author DuanJiaNing
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

    private Node<T> root;
    private int size = 0;

    @Override
    public boolean add(T value) {
        if (root == null) {
            initialRoot(value);
        } else {
            Node<T> current = root;
            Node<T> parent;
            for (; ; ) {
                if (value.compareTo(current.value) < 0) { //  value < current
                    parent = current;
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = new Node<>(value, null, null);
                        size++;
                        return true;
                    }
                } else if (value.compareTo(current.value) > 0) {
                    parent = current;
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = new Node<>(value, null, null);
                        size++;
                        return true;
                    }
                } else {
                    // 重复元素
                    return false;
                }
            }
        }

        return true;
    }

    private List<Node<T>> searchTrack;

    private Node<T> search(Node<T> node, T key) {
        if (node == null) return null;

        if (searchTrack != null) searchTrack.add(node);

        T value = node.value;
        if (value.equals(key)) return node;
        else if (value.compareTo(key) < 0) return search(node.rightChild, key);
        else return search(node.leftChild, key);
    }

    private void initialRoot(T value) {
        root = new Node<>(value, null, null);
    }

    @Override
    public Iterator<T> iterator(int traverse) {
        return new TreeIterator(traverse);
    }

    @Override
    public T delete(T value) {
        if (searchTrack != null) searchTrack.clear();
        else searchTrack = new ArrayList<>();

        Node<T> node = search(root, value);
        if (node == null) return null;

        if (node.leftChild == null && node.rightChild == null) {
            //删除叶子节点
            Node<T> parent = searchTrack.get(searchTrack.size() - 2);
            if (parent.leftChild == node) parent.leftChild = null;
            else parent.rightChild = null;

            return node.value;

        } else if (node.leftChild == null || node.rightChild == null) {
            //删除结点只有一个子节点
            Node<T> parent = searchTrack.get(searchTrack.size() - 2);
            if (parent.leftChild == node) parent.leftChild = node.leftChild == null ? node.rightChild : node.leftChild;
            else parent.rightChild = node.leftChild == null ? node.rightChild : node.leftChild;

            return node.value;
        } else {
            //删除结点有两个节点，较复杂，不实现
            throw new IllegalAccessError();
        }
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        T value;
        Node<T> leftChild;
        Node<T> rightChild;

        Node(T value, Node<T> leftChild, Node<T> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private class TreeIterator implements Iterator<T> {

        private final List<T> values = new ArrayList<>();
        private final Iterator<T> iterator;

        TreeIterator(int traverse) {

            switch (traverse) {
                case TRAVERSE_DLR:
                    dlr(root);
                    break;
                case TRAVERSE_LDR:
                    ldr(root);
                    break;
                case TRAVERSE_LRD:
                    lrd(root);
                    break;
            }
            iterator = values.iterator();
        }

        /**
         * 递归中序遍历
         *
         * @param node
         */
        private void ldr(Node<T> node) {
            if (node == null) {
                return;
            }

            ldr(node.leftChild);
            values.add(node.value);
            ldr(node.rightChild);
        }

        /**
         * 递归先序遍历
         *
         * @param node
         */
        private void dlr(Node<T> node) {
            if (node == null) {
                return;
            }

            values.add(node.value);
            dlr(node.leftChild);
            dlr(node.rightChild);
        }

        /**
         * 递归后序遍历
         *
         * @param node
         */
        private void lrd(Node<T> node) {
            if (node == null) {
                return;
            }

            lrd(node.leftChild);
            lrd(node.rightChild);
            values.add(node.value);
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            return iterator.next();
        }
    }

}
