/**
 * @description: FindKth:查找第k大的数，使用快排思想实现
 * @date: 2020/3/2 14:08
 * @author: Finallap
 * @version: 1.0
 */
public class FindKth1 {
    //使用快排思想实现
    public static int findKth(int[] nums, int k) throws Exception {
        if (k <= 0 || k > nums.length) {
            throw new Exception("K值错误");
        }
        return findKth(nums, k, 0, nums.length - 1);
    }

    public static int findKth(int[] nums, int k, int left, int right) {
        int m = partation(nums, left, right);
        if ((m - left) > (k - 1) && left < right)
            return findKth(nums, k, left, m - 1);
        else if ((m - left) < (k - 1) && left < right)
            return findKth(nums, k - m + left - 1, m + 1, right);
        else
            return nums[m];
    }

    public static int partation(int[] nums, int left, int right) {
        int key = nums[left];
        while (left < right) {
            while (left < right && nums[right] < key)
                right--;

            nums[left] = nums[right];

            while (left < right && nums[left] > key)
                left++;

            nums[right] = nums[left];
        }
        nums[left] = key;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 7, 9, 8};
        int k = 3;
        try {
            System.out.println(findKth(array, k));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
