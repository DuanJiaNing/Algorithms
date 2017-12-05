package data.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 2017/12/4.
 *
 * @author DuanJiaNing
 */
public class LinkedBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private Node<T> root;
    private int size = 0;
    private boolean recursion = true;

    @Override
    public boolean add(T value) {
        if (root == null) {
            initialRoot(value);
        } else {
            Node<T> current = root;
            Node<T> parent = null;
            for (; ; ) {
                if (value.compareTo(current.value) < 0) { //  value < current
                    parent = current;
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = new Node<>(value, null, null);
                        size++;
                        break;
                    }
                } else if (value.compareTo(current.value) > 0) {
                    parent = current;
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = new Node<>(value, null, null);
                        size++;
                        break;
                    }
                } else {
                    // 重复元素
                    return false;
                }
            }
        }

        return true;
    }

    private void initialRoot(T value) {
        root = new Node<>(value, null, null);
    }

    @Override
    public Iterator<T> iterator(int traverse) {
        return new TreeIterator(traverse);
    }

    @Override
    public boolean delete(T value) {
        return false;
    }


    public int size() {
        return size;
    }

    public void recursion(boolean enable) {
        recursion = enable;
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
                    dlr();
                    break;
                case TRAVERSE_LDR:
                    ldr();
                    break;
                case TRAVERSE_LRD:
                    lrd();
                    break;
            }
            iterator = values.iterator();
        }

        private void lrd() {
            if (recursion) {
                lrd(root);
            } else {
                //TODO 完善非递归的遍历
            }
        }

        private void ldr() {
            if (recursion) {
                ldr(root);
            } else {
                //TODO 完善非递归的遍历
            }
        }

        private void dlr() {
            if (recursion) {
                dlr(root);
            } else {
                //TODO 完善非递归的遍历
            }
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
