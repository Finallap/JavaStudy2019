/**
 * @description: LeetCode problem114: 二叉树展开为链表
 * 方法一：将左子树依次搬到右边
 * 方法二：后序遍历依次设置右孩子
 * @date: 2020/3/31 18:43
 * @author: Finallap
 * @version: 1.0
 */
public class problem114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            //如果左边不空，需要考虑将其搬到右侧
            if (root.left != null) {
                TreeNode tempRight = root.right;
                //将左侧搬到右侧，并将左侧置空
                root.right = root.left;
                root.left = null;

                //查找最右侧的节点位置
                TreeNode mostRight = root.right;
                while (mostRight.right != null)
                    mostRight = mostRight.right;

                //将原来的右子树接到最右侧的地方
                mostRight.right = tempRight;
            }
            //考虑下一个节点
            root = root.right;
        }
    }

    //使用后序遍历的方法，每遍历一次，就将该节点的右节点设置为上一个节点
    //如果使用前序遍历，则会导致本来的右孩子丢失
    private TreeNode pre = null;

    public void flatten1(TreeNode root) {
        if (root == null)
            return;
        flatten1(root.right);
        flatten1(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
