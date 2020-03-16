import java.util.HashMap;

/**
 * @description: LeetCode problem169:多数元素，HashMap计数法，摩尔投票法
 * @date: 2020/3/13 20:17
 * @author: Finallap
 * @version: 1.0
 */
public class problem169 {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else
                map.put(nums[i], 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2)
                return key;
        }
        return -1;
    }

    public static int majorityElement1(int[] nums) {
        Integer result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result)
                count++;
            else {
                if (--count == 0) {
                    result = nums[i];
                    count = 1;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 9, 9, 10};
        System.out.println(majorityElement1(nums));
    }
}
