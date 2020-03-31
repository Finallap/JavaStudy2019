package Jianzhi;

/**
 * @description: 剑指 problem28: 对称的二叉树
 * @date: 2020/3/31 18:23
 * @author: Finallap
 * @version: 1.0
 */
public class problem28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        //注意对称二叉树的定义，不是左边和右边一模一样
        return isSymmetric(left.left, right.right) && isSymmetric(right.left, left.right);
    }
}
