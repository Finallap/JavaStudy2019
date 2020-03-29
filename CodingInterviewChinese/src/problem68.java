/**
 * @description: 剑指 problem68、LeetCode problem 235:二叉搜索树的最近公共祖先
 * @date: 2020/3/29 11:02
 * @author: Finallap
 * @version: 1.0
 */
public class problem68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
