package Jianzhi;

/**
 * @description: 剑指 Problem26: 树的子结构
 * @date: 2020/4/10 17:39
 * @author: Finallap
 * @version: 1.0
 */
public class Problem26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return subtreeDiscrimination(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean subtreeDiscrimination(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return subtreeDiscrimination(A.left, B.left) && subtreeDiscrimination(A.right, B.right);
    }
}
