import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by DuanJiaNing on 2017/9/3.
 */
public class Combination {
//    /**
//     * 获得数组的全部组合集合
//     *
//     * @param res 要进行组合的数组
//     * @return 数组集合，返回从元素个数为 n 的数组中选择 [1...n] 个元素组合的所有可能组合：<br>
//     * 示例：从 {1,2,3,4} 中选择二个则返回的数组集合中有如下数组：<br>{1,2,0,0} <br>{1,0,3,0} <br>{1,0,0,4} <br>{0.2,3,0} <br>{0,2,0,4} <br>{0,0,3,4}
//     */
//    private static List<int[]> getArrays(int[] res) {
//        ArrayList<int[]> result = new ArrayList<>();
//        int count = res.length;
//
//        for (int i = 1; i < count; i++) {
//            int[] temp = new int[count];
//            for (int j = 0; j < temp.length; j++) {
//                temp[j] = 0;
//            }
//            for (int j = 0; j < i; j++) {
//                temp[j] = 1;
//            }
//            combination(temp);
//        }
//
//        result.add(0, res);
//
//        for (int[] ins : addList) {
//            int[] temp = new int[count];
//            for (int i = 0; i < temp.length; i++) {
//                temp[i] = ins[i] == 1 ? res[i] : 0;
//            }
//            result.add(temp);
//        }
//
//        addList.clear();
//
//        return result;
//    }
//
//
//    //组合的递归算法
//    private static void combination(int[] arr) {
//        //TODO arr即为每次递归的结果值，将其保存在全局变量中
//        addList.add(arr.clone());
//
//        int count = 0, index = 0;
//        boolean ch = false;
//        for (; index < arr.length - 1; index++) {
//            count = arr[index] == 1 ? count + 1 : count;
//            if (arr[index] == 1 && arr[index + 1] == 0) {
//                ch = true;
//                break;
//            }
//        }
//
//        if (ch) {
//            arr[index] = 0;
//            arr[index + 1] = 1;
//            for (int j = 0; j < index; j++) {
//                arr[j] = j < count - 1 ? 1 : 0;
//            }
//            combination(arr);
//        } else return;
//    }
//
//
//    //排列的递归算法
//    private static void listAll(List<Integer> candidate, int[] array) {
//        //TODO arr即为每次递归的结果值，将其保存在全局变量中
//        //第一次传入的array = null && array.length == 0
//        addList.add(array);
//
//        for (int i = 0; i < candidate.size(); i++) {
//            List<Integer> temp = new LinkedList<Integer>(candidate);
//            int[] arrT = Arrays.copyOf(array, array.length + 1);
//            arrT[array.length] = temp.remove(i);
//            listAll(temp, arrT);
//        }
//    }

}
