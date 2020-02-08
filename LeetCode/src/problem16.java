import java.util.Arrays;

public class problem16 {
    public static int threeSumClosest(int[] nums, int target) {
        int gap = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {//length - 2，否则数组可能越界
            int L = i + 1, R = nums.length - 1;
            int add_target = target - nums[i];

            while (L < R) {
                int sum_result = nums[i] + nums[L] + nums[R];
                if (Math.abs(target - sum_result) < gap) {
                    result = sum_result;
                    gap = Math.abs(target - sum_result);
                }

                if (nums[L] + nums[R] > add_target) {
                    R--;
                    while (nums[R] == nums[R + 1] && L < R) R--;//优化：去重
                } else if (nums[L] + nums[R] < add_target) {
                    L++;
                    while (nums[L] == nums[L - 1] && L < R) L++;//优化：去重
                } else
                    return target;
            }

            while (nums[i + 1] == nums[i] && i < nums.length - 2) i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
