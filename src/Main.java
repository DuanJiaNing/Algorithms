import sort.Sortable;
import sort.insert.InsertionSort;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4, 5};
        String str = "";
        //求3个数的组合个数
//        count(0,str,num,3);
//        求1-n个数的组合个数
        count1(0, str, num);
    }

    private static void count1(int i, String str, int[] num) {
        if (i == num.length) {
            System.out.println(str);
            return;
        }
        count1(i + 1, str, num);
        count1(i + 1, str + num[i] + ",", num);
    }

    private static void count(int i, String str, int[] num, int n) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        if (i == num.length) {
            return;
        }
        count(i + 1, str + num[i] + ",", num, n - 1);
        count(i + 1, str, num, n);
    }

    public static void main1(String[] args) {
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