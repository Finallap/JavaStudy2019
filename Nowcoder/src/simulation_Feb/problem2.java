package simulation_Feb;

import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println(0);
            return;
        }

        int[] nums = new int[3 * n];
        for (int i = 0; i < 3 * n; i++)
            nums[i] = sc.nextInt();
        int result = 0;

        Arrays.sort(nums);

        for (int i = n; i < 2 * n; i++)
            result += nums[i];

        System.out.println(result);
    }
}
