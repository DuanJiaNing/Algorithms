package search;

import java.util.function.Consumer;

/**
 * Created on 2017/12/1.
 *
 * @author DuanJiaNing
 */
public class Test {

    public static void main(String[] args) {
        Integer[] s1 = {1, 2, 4, 3, 5, 7};
        TreeSearch<Integer> tree = new TreeSearch<>(s1);
        p.accept(tree.toString());
    }

    public static Consumer<Object> p = System.out::println;

}
