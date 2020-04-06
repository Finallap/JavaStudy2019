import java.util.Arrays;

/**
 * @description: 剑指 problem45:把数组排成最小的数
 * @date: 2020/3/13 14:53
 * @author: Finallap
 * @version: 1.0
 */
public class problem45 {
    public String PrintMinNumber(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i] + "";
        }

        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuffer sb = new StringBuffer();
        for (String num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
