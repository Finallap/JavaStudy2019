package Jianzhi;

/**
 * @description: 剑指 Problem33: 二叉搜索树的后序遍历序列
 * @date: 2020/4/10 16:28
 * @author: Finallap
 * @version: 1.0
 */
public class Problem33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return false;
        return recur(postorder, 0, postorder.length);
    }

    public boolean recur(int[] postorder, int start, int end) {
        if (end - start <= 1)
            return true;

        int rootVal = postorder[end - 1];
        int cutIndex = start;
        while (cutIndex != end && postorder[cutIndex] <= rootVal)
            cutIndex++;

        for (int i = cutIndex; i < end; i++) {
            if (postorder[i] < rootVal)
                return false;
        }

        return recur(postorder, start, cutIndex - 1) && recur(postorder, cutIndex, end - 1);
    }
}
