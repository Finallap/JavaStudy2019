import java.util.Arrays;

public class problem21 {
    //双指针方法，没有保证奇数偶数之间的相对位置不变，时间复杂度O(n)，空间复杂度O(1)
    public static void reOrderArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int index1 = 0, index2 = nums.length - 1;
        while (index1 < index2) {
            if (nums[index1] % 2 == 0) {
                while (nums[index2] % 2 == 0)
                    index2--;
                int temp = nums[index1];
                nums[index1] = nums[index2];
                nums[index2] = temp;
            }
            index1++;
        }
    }

    //使用辅助数组，时间复杂度O(n)，空间复杂度O(n)
    public static void reOrderArray1(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int oddCount = 0;
        for (int num : nums)
            if (num % 2 != 0)
                oddCount++;
        int index1 = 0, index2 = oddCount;

        int[] nums_copy = nums.clone();
        for (int num : nums_copy)
            if (num % 2 == 0)
                nums[index2++] = num;
            else
                nums[index1++] = num;
    }

    //冒泡排序思想，时间复杂度O(n^2)，空间复杂度O(n)
    public static void reOrderArray2(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] % 2 == 0 && nums[j + 1] % 2 != 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
