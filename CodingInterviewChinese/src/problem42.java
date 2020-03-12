/**
 * @description: problem42:连续子数组的最大和
 * @date: 2020/3/12 22:35
 * @author: Finallap
 * @version: 1.0
 */
public class problem42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;

        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else
                sum += array[i];
            result = Math.max(sum, result);
        }

        return result;
    }
}
