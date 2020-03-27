/**
 * description: 剑指 problem33: 判断是否是二叉树的后序遍历
 * date: 2020/2/28 15:41
 * author: Finallap
 * version: 1.0
 */
public class problem33 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public static boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (end - start <= 1)
            return true;

        int rootVal = sequence[end];

        int cutIndex = start;
        while (cutIndex < end && sequence[cutIndex] <= rootVal)
            cutIndex++;

        for (int i = cutIndex; i < end; i++) {
            if (sequence[i] < rootVal)
                return false;
        }

        return VerifySquenceOfBST(sequence, start, cutIndex - 1) &&
                VerifySquenceOfBST(sequence, cutIndex, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }
}
