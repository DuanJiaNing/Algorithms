package datastructure.linklist;

/**
 * Created on 2017/12/1.
 * 有序单链表
 *
 * @author DuanJiaNing
 */
public class OrderedLinkedList<E extends Comparable<E>> extends LinkedList<E> {
    @Override
    public void add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        if (head == null) {
            super.add(e);
            return;
        }

        Node<E> current = head;
        Node<E> before = null;
        boolean isInLast = true; // 该元素位置是否为最后一个
        do {
            E item = current.item;
            if (item.compareTo(e) > 0) { // item > e，插入当前结点之前
                isInLast = false;
                if (before == null) { // 头结点
                    super.add(e);
                } else {
                    before.next = new Node<>(e, before.next);
                    count++;
                }
                return;
            }

            before = current;
            current = current.next;
        } while (current != null);

        if (isInLast) {
            before.next = new Node<>(e, null);
            count++;
        }
    }
}
