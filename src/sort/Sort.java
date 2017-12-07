package sort;

import util.P;

public class Sort {


    /**
     * 直接（简单）选择降序
     * 找出最大/小放在首位，再从剩余中找出最大/小放在末尾
     */

    public int[] directSelectionSort(int... sour) {

        int index = 0;
        while (index < sour.length) {
            int max = sour[index];
            int j = index;
            for (int i = index + 1; i < sour.length; i++) {
                if (sour[i] > max) {
                    max = sour[i];
                    j = i;
                }
            }

            if (max > sour[index]) {
                P.swap(index, j, sour);
            }

            index++;
        }

        return sour;
    }


    /**
     * 直接插入升序
     * 先对数组前两个元素进行排序，之后将第三个元素与前两个比较，按排序规则插入正确的位置，之后将第四个元素与前三个
     * 比较插入正确的位置，以此类推直至最后一个元素
     */
    public int[] directInsertionSort(int... sour) {

        for (int i = 1; i < sour.length; i++) {
            for (int j = i; j > 0; j--) {
                if (sour[j - 1] > sour[j]) {
                    // 前面/后面的都是有序序列，只能依次交换，不能找出位置最后直接交换（应插入）
                    P.swap(j - 1, j, sour);
                }
            }
        }

        return sour;
    }


    /**
     * 快速排序
     * <p>
     * 是一种分治的排序方法，将一个数组分成两个子数组，两部分独立排序。
     * 1 选择一个基准元素 a[j]
     * 2 保证 a[low] ~ a[j-1] 中的所有元素都不大于 a[j]
     * 3 保证 a[j+1] ~ a[high] 中的所有元素都不小于 a[j]
     * <p>
     * 步骤
     * index     0 1  2  3  4  5  6  7  8  9
     * arr      72,6,57,88,60,42,83,73,48,85
     * <p>
     * 1. low = 0,high = 9,X = arr[0] = 72 从 high 往前遍历，
     * 找到第一个 arr[8] <= X : {@code arr[0] = arr[8];low++;} //初始
     * index     0 1  2  3  4  5  6  7  8  9
     * arr      .48,6,57,88,60,42,83,73,.48,85
     * <p>
     * 2. low = 1,high = 8,X = 72 从 low 接着往后遍历，
     * 找到第一个 arr[3] >= X : {@code arr[8] = arr[3];high--;}
     * index     0 1  2  3  4  5  6  7  8  9
     * arr      48,6,57,.88,60,42,83,73,88.,85
     * <p>
     * 3. low = 3,high = 7,X = 72 从 high 接着往前遍历，
     * 找到第一个 arr[5] <= X : {@code arr[3] = arr[5];low++;}
     * index     0 1  2  3  4  5  6  7  8  9
     * arr      48,6,57,.42,60,42.,83,73,88,85
     * <p>
     * 2. low = 4,high = 5,X = 72 从 low 接着往后遍历，
     * 找到第一个 arr[6] >= X : {@code 6 > high;} // 结束
     */
    private int partition(int[] sour, int low, int high) {
        final int X = sour[low];

        while (low < high) {

            // 1. high 往前遍历，最多检查到 low 所在位置
            while (high > low && sour[high] > X) {
                high--;
            }

            // 找到满足条件的了：sour[high] <= X
            if (low < high) {
                sour[low] = sour[high];
                low++;
            }

            // 2. low 往后遍历，最多检查到 high 位置
            while (low < high && sour[low] < X) {
                low++;
            }

            // 找到满足条件的了：sour[high] >= X
            if (low < high) {
                sour[high] = sour[low];
                high--;
            }
        }
        sour[low] = X;

        return low;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (high < low) {
            return;
        }

        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

}