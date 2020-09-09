package Huawei_20200908;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: HuaweiRound2
 * @date: 2020/9/9 8:59
 * @author: Finallap
 * @version: 1.0
 */
public class HuaweiRound2 {
    public int count(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int result = 0;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                result++;
            }
            if (set.contains(nums[i] + 1)) {
                result++;
            }
            set.add(nums[i]);
        }
        return result;
    }
}
