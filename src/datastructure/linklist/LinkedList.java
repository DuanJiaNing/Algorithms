package datastructure.linklist;

import java.lang.reflect.Array;

/**
 * Created on 2017/12/1.
 * 单链表的头部插入和删除，查找和移除
 *
 * @author DuanJiaNing
 */
public class LinkedList<E> {

    protected Node<E> head = null;
    protected int count = 0;

    /**
     * 表头插入元素
     *
     * @param e
     */
    public void add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        head = new Node<>(e, head);
        count++;
    }

    /**
     * 删除表头元素
     *
     * @return
     */
    public E delete() {
        if (head == null) {
            return null;
        }

        E e = head.item;
        head.item = head.next.item;
        head.next = head.next.next;
        count--;
        return e;
    }

    /**
     * 找到元素
     *
     * @param e
     * @return
     */
    public E find(E e) {
        Node<E> node = findNode(e);
        return node == null ? null : node.item;
    }

    private Node<E> findNode(E e) {
        if (head == null) {
            return null;
        }

        Node<E> current = head;
        do {
            E item = current.item;
            if (item.equals(e)) {
                return current;
            }
            current = current.next;
        } while (current != null);

        return null;
    }

    public int size() {
        return count;
    }

    /**
     * 移除元素
     *
     * @param e
     * @return
     */
    public E remove(E e) {
        if (head == null) {
            return null;
        }

        Node<E> current = head;
        Node<E> before = null;
        do {
            E item = current.item;
            if (item.equals(e)) {
                if (before == null) { // 头结点
                    head = null;
                } else {
                    before.next = current.next;
                    current = null;
                }

                count--;
                return item;
            }
            before = current;
            current = current.next;
        } while (current != null);

        return null;
    }

    @SuppressWarnings("unchecked")
    public E[] getAll(Class<E> type) {
        if (head == null) {
            return null;
        }

        E[] arr = (E[]) Array.newInstance(type, count);

        Node<E> current = head;
        int index = 0;
        do {
            arr[index++] = current.item;
            current = current.next;
        } while (current != null);

        return arr;
    }

    protected static class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
