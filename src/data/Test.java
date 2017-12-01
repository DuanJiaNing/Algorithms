package data;

import data.linklist.LinkedList;
import data.linklist.OrderedLinkedList;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created on 2017/12/1.
 *
 * @author DuanJiaNing
 */
public class Test {


    public static void main(String[] args) {
        LinkedList<Integer> sl = new OrderedLinkedList<>();
        sl.add(1);
        sl.add(3);
        sl.add(23);
        sl.add(1000);
        sl.add(10);
        sl.add(0);
        sl.add(-10);
        p.accept(Arrays.toString(sl.getAll(Integer.class)));
    }

    public static Consumer<Object> p = System.out::println;
}
