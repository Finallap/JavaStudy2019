import java.util.*;

/**
 * @description: 剑指 problem68、LeetCode problem 236:普通二叉树的最近公共祖先,LCA问题
 * @date: 2020/3/29 11:55
 * @author: Finallap
 * @version: 1.0
 */
public class problem68_1 {
    private TreeNode ans = null;

    //解法1：递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return this.ans;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        //递归的查找子树
        int left = recurseTree(root.left, p, q) ? 1 : 0;
        int right = recurseTree(root.right, p, q) ? 1 : 0;

        //如果当前节点已是p或者q，则标记为1
        int mid = (root == p || root == q) ? 1 : 0;

        //如果左右节点标记为true的数量或本身就是节点的标记总数超过2，则说明当前节点已经是最低公共祖先
        if (left + right + mid >= 2)
            this.ans = root;

        return left + right + mid > 0;
    }

    //解法2：使用父指针迭代
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

    //解法3：递归
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else return right;

    }
}
