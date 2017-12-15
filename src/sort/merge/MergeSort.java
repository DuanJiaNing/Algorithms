package sort.merge;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Created on 2017/12/14.
 * 归并排序，有错误，未能正确排序，只能对2的指数个元素排序如：2 4 8 16 256 1024 ...
 *
 * @author DuanJiaNing
 */
public class MergeSort<T> {

    private final Class<T> type;

    public MergeSort(Class<T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public T[] sort(T[] sour, Comparator<T> comparator) {
        // 65318724

        int len = sour.length;
        T[][] arr = (T[][]) Array.newInstance(type, len, 1);
        for (int i = 0; i < len; i++) {
            arr[i][0] = sour[i];
        }

        //block：每次合并前二维数组第二维元素的个数，变化规律为：1 2 4 8 ...
        for (int block = 1; block <= len >> 1; block <<= 1) {

            //当前待合并的数组个数
            int c = arr.length;

            //存放合并后的二维数组，c/2：合并后数组的个数，block：合并后二维元素个数
            T[][] temp = (T[][]) Array.newInstance(type, c / 2, block * 2);

            //两两合并
            int index = 0;
            for (int i = 0; i < c; i += 2) {
                T[] arr1 = arr[i];
                T[] arr2 = arr[i + 1];

                temp[index++] = merge(arr1, arr2, comparator);
            }
            arr = temp;
        }

        return arr[0];
    }

    // 合并两个排好序的数组
    @SuppressWarnings("unchecked")
    private T[] merge(T[] arr1, T[] arr2, Comparator<T> comparator) {
        T[] result = (T[]) Array.newInstance(type, arr1.length + arr2.length);
        int index = 0;

        int start1 = 0, end1 = arr1.length;
        int start2 = 0, end2 = arr2.length;
        while (start1 < end1 && start2 < end2) {
            result[index++] = comparator.compare(arr1[start1], arr2[start2]) > 0 ? arr2[start2++] : arr1[start1++];
        }

        while (start1 < end1) {
            result[index++] = arr1[start1++];
        }

        while (start2 < end2) {
            result[index++] = arr2[start2++];
        }

        return result;
    }


}
