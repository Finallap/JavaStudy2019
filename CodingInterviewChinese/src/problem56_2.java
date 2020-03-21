/**
 * @description: 剑指 problem56_2: 数组中唯一只出现一次的数字
 * 建立一个长度为32的数组，对每位进行计数，如果该位数能整除3则说明该位为0，否则该位为1，最后打印输出
 * @date: 2020/3/18 15:12
 * @author: Finallap
 * @version: 1.0
 */
public class problem56_2 {
    public static int findAppearOnce(int[] nums) {
        if (nums == null)
            throw new RuntimeException();

        int[] bitSum = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if ((num & 1) != 0)
                    bitSum[i]++;
                num >>= 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += (bitSum[i] % 3);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1, 2, 6};
        System.out.println(findAppearOnce(nums));
    }
}
