public class problem26 {
    //双指针还能再优化一下
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int prev = nums[0];
        int truthIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[++truthIndex] = nums[i];
                prev = nums[i];
            }
        }

        return truthIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
