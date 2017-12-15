package datastructure.heap;

import util.P;
import util.Utils;

import java.util.Arrays;

/**
 * Created on 2017/12/13.
 *
 * @author DuanJiaNing
 */
public class Test {

    public static void main(String[] args) {
        new Test().test1();
    }


    public void test2() {
        MiniArrayHeap<Integer> heap = new MiniArrayHeap<>();
        for (Integer in : Utils.getRandomIntegers(10, 12)) {
            heap.push(in);
        }
        P.out(Arrays.toString(heap.getValues(Integer.class)));
    }

    public void test1() {
        MiniArrayHeap<Integer> heap = new MiniArrayHeap<>();
        heap.push(8);
        heap.push(5);
        heap.push(2);
        heap.push(10);
        heap.push(3);
        heap.push(7);
        heap.push(1);
        heap.push(4);
        heap.push(6);

        P.out(heap.size()); // 9
        P.out(heap.getValues(Integer.class));

        P.out(heap.pop());
        P.out(heap.size()); // 8
        P.out(heap.getValues(Integer.class));

    }

}
