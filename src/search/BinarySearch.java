package search;

/**
 * Created by DuanJiaNing on 2017/9/3.
 */
public class BinarySearch {

    //二分查找
    private static int binarySearch(int[] array, int des) {
        int low = 0;
        int height = array.length - 1;
        int middle;

        while (true) {
            if (low == height && array[low] != des)
                return -1;
            middle = (height + low) >> 1;
            int va = array[middle];
            System.out.println("middle=" + middle);
            if (va == des)
                break;
            else if (des > va)
                low = middle + 1;
            else height = middle - 1;
        }

        return middle;
    }

}
