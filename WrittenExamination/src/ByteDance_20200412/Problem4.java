package ByteDance_20200412;

import java.util.Scanner;

/**
 * @description: Problem4: 能看见的房子顶部问题，AC 71.43%
 * @date: 2020/4/12 20:02
 * @author: Finallap
 * @version: 1.0
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sampleNum = in.nextInt();
        for (int i = 0; i < sampleNum; i++) {
            int len = in.nextInt();
            int[] nums = new int[len];
            for (int j = 0; j < len; j++) {
                nums[j] = in.nextInt();
            }
            process(nums);
        }
        in.close();
    }

    public static void process(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && nums[left] <= nums[i])
                left--;
            while (right < len && nums[right] <= nums[i])
                right++;
            int count = (i - left) + (right - i) - 2;
            result[i] = count;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
