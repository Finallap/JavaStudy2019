/**
 * @description: LeetCode Problem35: 搜索插入位置，二分搜索
 * @date: 2020/5/9 20:01
 * @author: Finallap
 * @version: 1.0
 */
public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
