/**
 * @description: LeetCode Problem124:二叉树中的最大路径和，其实就是后序遍历
 * @date: 2020/4/21 18:50
 * @author: Finallap
 * @version: 1.0
 */
public class Problem124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ans;
    }

    public int getMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
