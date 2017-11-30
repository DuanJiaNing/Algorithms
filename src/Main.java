import sort.Sortable;
import sort.insert.InsertionSort;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        Integer[] s = {9, 8, 7, 6, 3,};
        Integer[] s1 = {1, 2, 4, 3, 5, 7};
        Integer[] s2 = {1, -2, 22223, 489, 335, 23437, 3, 4, 56, 76, 98, 12, 3421, 654};

        test(new InsertionSort<>(), s1);
    }

    public static <T extends Comparable> void test(Sortable<T> sortable, T... ts) {
        p.accept(sortable.sort(ts, T::compareTo));
        p.accept(Arrays.toString(ts));
    }

    public static Consumer<Object> p = System.out::println;

}