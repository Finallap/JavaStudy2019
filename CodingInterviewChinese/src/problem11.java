public class problem11 {
    public static int Min(int[] nums) throws Exception {
        if (nums == null || nums.length == 0)
            throw new Exception("Invalid parameters.");

        int index1 = 0;
        int index2 = nums.length - 1;
        int mid = index1;
        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 <= 1) {
                mid = index2;
                break;
            }

            mid = (index1 + index2) >> 1;

//            需要考虑index1、index2和mid都相等的情况
//            都相等时使用顺序查找
            if (nums[index1] == nums[mid] && nums[mid] == nums[index2])
                return MinInOrder(nums, index1, index2);

            if (nums[mid] >= nums[index1])
                index1 = mid;
            else if (nums[mid] <= nums[index2])
                index2 = mid;
        }

        return nums[mid];
    }

    //    顺序查找
    public static int MinInOrder(int[] nums, int index1, int index2) {
        int result = nums[index1];
        for (int i = index1; i <= index2; i++) {
            if (nums[i] < result)
                result = nums[i];
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Min(new int[]{1, 1, 1, 0, 1}));
    }
}
