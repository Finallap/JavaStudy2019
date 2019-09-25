public class problem53 {
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {//相加个数
            for (int j = 0; j < nums.length; j++) {//起点位置
                int des = j + i;
                if (des > nums.length) break;
                int temp = 0;
                for (int k = j; k < des; k++)//正在遍历的数字位置
                    temp += nums[k];
                if (temp > result)
                    result = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray1(nums));
    }

    public static int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int f_n = -1;
        for (int num : nums) {
            f_n = Math.max(f_n + num, num);
            result = Math.max(f_n, result);
        }
        return result;
    }
}
