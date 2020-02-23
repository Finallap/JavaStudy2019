//二叉树的镜像
public class problem27 {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            return;
        } else {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            Mirror(root.right);
            Mirror(root.left);
        }
    }
}
