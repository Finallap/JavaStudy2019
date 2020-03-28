/**
 * @description: 剑指 problem66: 构建乘积数组
 * @date: 2020/3/28 22:05
 * @author: Finallap
 * @version: 1.0
 */
public class problem66 {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        int[] C = new int[len];
        int[] D = new int[len];

        C[0] = 1;
        for (int i = 1; i < len; i++) {
            C[i] = C[i - 1] * A[i - 1];
        }

        D[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            D[i] = D[i + 1] * A[i + 1];
        }

        for (int i = 0; i < len; i++) {
            B[i] = C[i] * D[i];
        }

        return B;
    }

    public int[] multiply1(int[] A) {
        int len = A.length;
        int[] B = new int[len];

        /* 从左往右累乘 */
        for (int i = 0, produce = 1; i < len; produce *= A[i], i++) {
            B[i] = produce;
        }

        /* 从右往左累乘 */
        for (int i = len - 1, produce = 1; i >= 0; produce *= A[i], i--) {
            B[i] *= produce;
        }

        return B;
    }
}
