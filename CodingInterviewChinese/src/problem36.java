/**
 * @description: problem36:二叉树转换成双向链表
 * @date: 2020/2/29 14:55
 * @author: Finallap
 * @version: 1.0
 */
public class problem36 {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }

}
