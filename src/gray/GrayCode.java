package gray;

import util.Utils;

import java.util.Arrays;

/**
 * Created on 2017/11/23.
 * http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651479484&idx=2&sn=32c2594913af5dab807b01a6d297a9fb&chksm=bd2531c38a52b8d56529b3b5ef189d5d5a7c26c078dc66bb6702226ece0be26a67b8bcfdfa25&mpshare=1&scene=23&srcid=1123ZwvrMUu6Nk33sc30yhkt#rd
 * 格雷码：数列集合，每个数使用二进位表示，使用n位元表示每个数，任两个数之间只有一个位元值不同
 * n=2: 00 01   10 11 - 2^2=4
 * n=3: 000 001   010 011   110 111   100 101 - 2^3=8
 * n=4: 0000 0001   0010 0011   0100 0101   1000 1001 - 2^4=16   - 前三位：1-1 2-0
 * 0110 0111   1010 1010   1100 1101                        - 前三位：2-1 1-0
 * 1110 1111                                                - 前三位：3-1 0-0
 * n=n: ... - 2^n
 *
 * @author DuanJiaNing
 */
public class GrayCode {

    /**
     * n=2
     * 1.00
     * 2.01
     * <p>
     * 3.10
     * 4.11
     * <p>
     * n=3
     * 1.000
     * 2.001
     * 3.010
     * 4.011
     * <p>
     * 5.100
     * 6.101
     * 7.110
     * 8.111
     * <p>
     * 由上可见000的第一位1~4和5~8是相反的，而第2,3位是一样的，因此只需要排列出所有2,3位的情况，
     * 在前面分别加上1和0即可。
     * 由n=2和n=3的情况可知，n的格雷码只需在n-1的所有格雷码前分别加1和0即可。
     *
     * @param n
     * @return
     */
    public static String[] grayCode(int n) {
        String[] arr = new String[(int) Math.pow(2, n)];

        if (n == 1) {
            arr[0] = "0";
            arr[1] = "1";
            return arr;
        }

        String[] before = grayCode(n - 1);

        for (int i = 0; i < before.length; i++) {
            arr[i] = "0" + before[i];
            arr[arr.length - 1 - i] = "1" + before[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        Utils.P.accept(Arrays.toString(grayCode(8)));
    }

}
