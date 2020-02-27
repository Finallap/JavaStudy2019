package simulation_Feb;

import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(0);
            return;
        }
        int xMax = 0, yMax = 0;
        for (int i = 0; i < n; i++) {
            int xCurr = 0, yCurr = 0;
            for (int j = 0; j < 2; j++) {
                if (j == 0)
                    xCurr = sc.nextInt();
                else
                    yCurr = sc.nextInt();
            }
            if (xMax > xCurr) {
                xMax = yCurr + xMax - xCurr;
            } else if (xMax < xCurr) {
                xMax = yMax + xCurr - xMax;
                yMax = yCurr;
            } else {
                xMax = 0;
                yMax = 0;
            }
        }
        System.out.println(xMax + yMax);
    }
}
