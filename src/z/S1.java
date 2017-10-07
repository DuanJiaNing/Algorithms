package z;

import sort.Sort;
import util.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by DuanJiaNing on 2017/9/3.
 */
public class S1 {
    {
        Sort sort = new Sort();
        int[] sour = new int[15];
        Random r = new Random();
        for (int i = 0; i < sour.length; i++) {
            sour[i] = r.nextInt(sour.length);
        }

        Utils.log("start");
        sort.quickSort(sour, 0, sour.length - 1);
//        sort.bubbleSort(sour);
//        sort.directInsertionSort(sour);
//        sort.directSelectionSort(sour);
        Utils.log("finish");

        Arrays.stream(sour).forEach(va -> System.out.printf(" " + va));
    }
}
