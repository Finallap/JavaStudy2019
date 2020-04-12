package ByteDance_20200412;

import java.util.Scanner;

/**
 * @description: Problem2：折木棍次数问题，AC15%
 * @date: 2020/4/12 19:23
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int result = process(nums);
        System.out.println(result);
        in.close();
    }

    public static int process(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = nums[i - 1];
            int right = nums[i + 1];
            if (nums[i] >= left && nums[i] <= right)
                continue;
            if (left >= right)
                continue;

            int gap = right - left;
            int mid = nums[i];
            int times = 1;
            while (mid / 2 > right) {
                mid /= 2;
                times += 2;
            }
            result += times;
        }
        return result;
    }
}
