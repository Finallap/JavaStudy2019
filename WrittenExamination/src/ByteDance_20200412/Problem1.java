package ByteDance_20200412;

import java.util.Scanner;

/**
 * @description: Problem1: 能否通过区间加减变换数列问题，AC 100%
 * @date: 2020/4/12 19:03
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sampleNum = in.nextInt();
        for (int i = 0; i < sampleNum; i++) {
            int len = in.nextInt();
            int[] A = new int[len];
            int[] B = new int[len];
            for (int j = 0; j < len; j++) {
                A[j] = in.nextInt();
            }
            for (int j = 0; j < len; j++) {
                B[j] = in.nextInt();
            }

            if (process(A, B)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }

    public static boolean process(int[] A, int[] B) {
        int len = A.length;
        int gap = 0;
        boolean startFlag = false;
        boolean endFlag = false;
        for (int i = 0; i < len; i++) {
            if (!startFlag && !endFlag) {
                if (A[i] != B[i]) {
                    startFlag = true;
                    gap = A[i] - B[i];
                }
            } else if (startFlag && !endFlag) {
                if (A[i] == B[i]) {
                    endFlag = true;
                    continue;
                }
                if (A[i] != B[i] + gap)
                    return false;
            } else {
                if (A[i] != B[i])
                    return false;
            }
        }
        return true;
    }
}
