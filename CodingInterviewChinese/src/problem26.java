//判断是否存在子树
public class problem26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        return IsSubTreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean IsSubTreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return IsSubTreeWithRoot(root1.left, root2.left) &&
                IsSubTreeWithRoot(root1.right, root2.right);
    }
}
