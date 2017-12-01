package search;

import search.binary.BinarySearch;

import java.util.function.Consumer;

/**
 * Created on 2017/12/1.
 *
 * @author DuanJiaNing
 */
public class Test {

    public static void main(String[] args) {
        Integer[] s1 = {1, 2, 4, 3, 5, 7};

        BinarySearch<Integer> search = new BinarySearch<>(true);
        int index = search.search(s1, 7);
        p.accept(index);

    }


    public static Consumer<Object> p = System.out::println;

}
