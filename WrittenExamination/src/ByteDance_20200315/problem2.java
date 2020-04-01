package ByteDance_20200315;

import java.util.Scanner;

/**
 * @description: problem2:寻找水源，ac42%
 * @date: 2020/3/15 19:40
 * @author: Finallap
 * @version: 1.0
 */
public class problem2 {
    static int D = 0;
    static int W = 0;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D = sc.nextInt();
        W = sc.nextInt();
        int needSupply = D - W;

        String firstStr = sc.nextLine();

        String positionStr = sc.nextLine();
        String[] positionChars = positionStr.split(" ");
        int[] positions = new int[positionChars.length];
        for (int i = 0; i < positionChars.length; i++) {
            positions[i] = Integer.parseInt(positionChars[i]);
        }

        String suppliesStr = sc.nextLine();
        String[] suppliesChars = suppliesStr.split(" ");
        int[] supplies = new int[suppliesChars.length];
        for (int i = 0; i < suppliesChars.length; i++) {
            supplies[i] = Integer.parseInt(suppliesChars[i]);
        }

        for (int i = 0; i < supplies.length; i++) {
            if (W >= positions[i] && W + supplies[i] >= D) {
                System.out.println("1");
                return;
            }
        }

        int supplySum = 0;
        for (int i = 0; i < supplies.length; i++) {
            supplySum += supplies[i];
        }
        if (supplySum < needSupply) {
            System.out.println("0");
            return;
        }
        backtrack(0, -1, 0, supplies, positions, W);
        System.out.println("result");
    }

    private static void backtrack(int currLen, int lastIndex, int nowIndex, int[] supplies, int[] positions, int lastSupply) {
        if (lastSupply + supplies[nowIndex] >= D - supplies[nowIndex]) {
            result = Math.min(result, currLen + 1);
            return;
        }

        int lastPosition = 0;
        if (lastIndex > 0)
            lastPosition = positions[lastIndex];

        int nowSupply = lastSupply - (positions[nowIndex] - lastPosition);
        if (nowSupply < 0)
            return;

        for (int i = nowIndex + 1; i <= positions.length; i++) {
            backtrack(currLen++, nowIndex, i, supplies, positions, nowSupply);
        }
    }
}
