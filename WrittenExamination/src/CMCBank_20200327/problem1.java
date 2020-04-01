package CMCBank_20200327;

import java.util.Scanner;

/**
 * @description: problem1
 * @date: 2020/3/27 18:59
 * @author: Finallap
 * @version: 1.0
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counts = sc.nextInt();

        for (int i = 0; i < counts; i++) {
            int len = sc.nextInt();
            int[] inputs = new int[len];
            for (int j = 0; j < len; j++) {
                inputs[j] = sc.nextInt();
            }
            calculation(inputs);
        }
    }

    public static void calculation(int[] list) {
        int len = list.length;
        System.out.println(-1);
    }
}
