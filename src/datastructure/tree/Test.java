package datastructure.tree;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created on 2017/12/1.
 *
 * @author DuanJiaNing
 */
public class Test {


    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(3);
        tree.add(23);
        tree.add(1000);
        tree.add(10);
        tree.add(0);
        tree.add(-10);
        pl.accept(tree.size());

        int[] is = {BinaryTree.TRAVERSE_DLR, BinaryTree.TRAVERSE_LDR, BinaryTree.TRAVERSE_LRD};
        // dlr: 1 0 -10 3 23 10 1000
        // ldr: -10 0 1 3 10 23 1000
        // lrd: -10 0 10 1000 23 3 1
        for (int i = 0; i < 3; i++) {
            Iterator<Integer> iterator = tree.iterator(is[i]);
            while (iterator.hasNext()) {
                p.accept(iterator.next());
                p.accept(" ");
            }
            pl.accept("");
        }

    }

    public static Consumer<Object> pl = System.out::println;
    public static Consumer<Object> p = System.out::print;
}
