package practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created on 2017/12/18.
 *
 * @author DuanJiaNing
 */
public class Array {


    /**
     * 1. 找出数组中重复的数字
     * 数组长度为n，数组中的数字都是从 0~n-1的范围，数组中有重复数字，找出任一重复数字
     * <p>
     * 解决：
     * 方法1：先排序，后找重复
     * 方法2：利用哈希表，扫描数组并存到哈希表，如果哈希表中对应位置已经有值则表明该数字重复
     * 方法3：由于数组中数字从 0~n-1，按由小到大排序后，下标为i的位置应该存放的值为i，如果下标为i处存值不是i，则表明有重复
     */
    @Test
    public void test() {

        int[] arr = {1, 2, 3, 7, 9, 0, 2, 8, 3, 10, 10};
        int[] arr1 = {1, 2, 3, 7, 9, 4, 5, 6, 10, 0, 8};
        findDup(arr);
    }

    private void findDup(int[] arr) {

        //方法二
        int[] hashArr = new int[arr.length];
        Arrays.fill(hashArr, -1);
        for (int i = 0; i < arr.length; i++) {

            int hashIndex = arr[i];
            if (hashArr[hashIndex] == arr[i]) {
                System.out.println("2 重复值：" + arr[i]);
                break;
            } else {
                hashArr[hashIndex] = arr[i];
            }
        }


        //方法三
        int index = 0;
        while (index != arr[index]) {
            if (arr[index] == arr[arr[index]]) {
                System.out.println("3 重复值：" + arr[index]);
                break;
            }

            int t = arr[index];
            arr[index] = arr[t];
            arr[t] = t;
            if (arr[index] == index) {
                index++;
            }
        }

    }

}
