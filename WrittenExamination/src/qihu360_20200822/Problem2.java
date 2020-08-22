package qihu360_20200822;

import java.util.Scanner;

/**
 * @description: Problem2
 * @date: 2020/8/22 21:10
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int oddOffset = 1, evenOffset = 2;
        boolean moveOdd = true;
        for (int i = 0; i < m; i++) {
            int operate = scanner.nextInt();
            if (operate == 1) {
                if (moveOdd) {
                    oddOffset += 2;
                } else {
                    evenOffset += 2;
                }
            }
            moveOdd = !moveOdd;
        }

        for (int i = 1; i <= n; i++) {
            if (i != 1) {
                System.out.print(" ");
            }
            boolean outputOdd = (i + (moveOdd ? 1 : 0)) % 2 == 0;
            if (outputOdd) {
                oddOffset = oddOffset % n != 0 ? oddOffset % n : n;
                System.out.print(oddOffset);
                oddOffset += 2;
            } else {
                evenOffset = evenOffset % n != 0 ? evenOffset % n : n;
                System.out.print(evenOffset);
                evenOffset += 2;
            }
        }
    }
}
