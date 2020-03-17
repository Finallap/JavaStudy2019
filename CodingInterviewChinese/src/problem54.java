/**
 * @description: 剑指 problem54:二叉搜索树中第k大的节点，中序遍历，并计数
 * @date: 2020/3/16 22:28
 * @author: Finallap
 * @version: 1.0
 */
public class problem54 {
    private int count = 0;
    private TreeNode result;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inoder(pRoot, k);
        return result;
    }

    private void inoder(TreeNode node, int k) {
        if (node == null || count >= k)
            return;

        inoder(node.left, k);
        count++;
        if (count == k)
            result = node;
        inoder(node.right, k);
    }
}
