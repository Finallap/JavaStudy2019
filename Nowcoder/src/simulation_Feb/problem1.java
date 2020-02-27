package simulation_Feb;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int result = 1;

        if (n <= 2) {
            System.out.println(result);
            return;
        }

        boolean raiseFlag = true;
        if (nums[0] > nums[1])
            raiseFlag = false;

        for (int i = 2; i < n; i++) {
            if (raiseFlag) {
                if (nums[i - 1] > nums[i]) {
                    raiseFlag = false;
                    result++;
                }
            } else {
                if (nums[i - 1] < nums[i]) {
                    raiseFlag = true;
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
