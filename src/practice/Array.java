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

    /**
     * 2. 不修改数组找出重复数字
     * 长度为n+1的数组里所有数字都在1~n的范围，找出重复数字
     * 方法一：创建辅助数组，将源数组按下标-1存放到辅助数组中，如果辅助数组已经存在值，则说明该值重复
     * 方法二：数字 1~n ，中间数字为 m=n/2，统计数组中 1~m 出现的次数，如果次数大于m表示有重复，继续细分中间数字为 m1= m/2...
     * 递归直到 mn~mn 出现次数大于1。
     */
    @Test
    public void test2() {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        int[] arr1 = {1, 2, 3, 5, 4, 6, 7, 8, 9};
        findDup1(arr1);
    }

    private void findDup1(int[] arr) {

        //方法一
        int[] temp = new int[arr.length];
        for (int i : arr) {
            int va = temp[i - 1];
            if (va != 0) {
                System.out.println("1 重复：" + i);
            } else {
                temp[i - 1] = i;
            }
        }

        //方法二
        int start = 1;
        int end = arr.length - 1;
        while (end >= start) {
            //中间值
            int middle = ((end - start) >> 1) + start;
            //区间内的数值个数
            int count = 0;
            for (int va : arr) {
                if (va >= start && va <= middle) {
                    count++;
                }
            }

            //最后一个步骤，有则输出没有则结束循环
            if (end == start) {
                if (count > 1) {
                    System.out.println("2 重复：" + start);
                }
                break;
            }

            //区间内数值个数大于最大数（合理的数量，超过则当前区间有重复，不超过则重复再另一个区间）
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

    }

}
