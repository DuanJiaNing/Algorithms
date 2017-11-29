import sort.BubbleSort;
import sort.Sortable;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Sortable<Integer> sort = new BubbleSort<>();
//        Integer[] sour = {9, 8, 7, 6, 3,};
        Integer[] sour = {1, 2, 3, 4, 5,7};
        int times = sort.sort(sour, Integer::compareTo);
        p.accept(times);
        p.accept(Arrays.toString(sour));

    }

    public static Consumer<Object> p = System.out::println;

}