import java.util.ArrayList;

/**
 * @description: 剑指 problem57_1: 和为 S 的两个数字
 * @date: 2020/3/18 16:03
 * @author: Finallap
 * @version: 1.0
 */
public class problem57_1 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int low = 0, high = array.length - 1;
        while (low < high) {
            int result = array[low] + array[high];
            if (result > sum)
                high--;
            else if (result < sum)
                low++;
            else {
                list.add(array[low]);
                list.add(array[high]);
                break;
            }
        }
        return list;
    }
}
