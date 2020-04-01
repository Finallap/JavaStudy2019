package Alibaba_20200323;

import java.util.Scanner;

/**
 * @description: problem2
 * @date: 2020/3/23 18:53
 * @author: Finallap
 * @version: 1.0
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String line = in.nextLine();
        char[][] map = new char[n][m];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < n; i++) {
            line = in.nextLine();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                if (ch == 'S') {
                    startX = i;
                    startY = j;
                }
                if (ch == 'E') {
                    endX = i;
                    endY = j;
                }
                map[i][j] = ch;
            }
        }

        int[][] dp = new int[n][m];

        int result = Math.abs(startX - endX) + Math.abs(startY - endY);
        System.out.print(result);
    }

    public static int minor(int o, int n) {
        return n + 1 - o;
    }
}
