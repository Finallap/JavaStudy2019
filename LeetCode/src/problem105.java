import java.util.HashMap;

/**
 * @description: LeetCode problem105: 从前序与中序遍历序列构造二叉树
 * @date: 2020/3/19 11:41
 * @author: Finallap
 * @version: 1.0
 */
public class problem105 {
    private HashMap<Integer, Integer> indexForInOrder = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0)
            return null;

        for (int i = 0; i < inorder.length; i++)
            indexForInOrder.put(inorder[i], i);

        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode node = new TreeNode(preorder[preStart]);
        int rootIndexInorder = indexForInOrder.get(node.val);

        int leftLen = rootIndexInorder - inStart;

        node.left = buildTree(preorder, inorder, preStart + 1, preStart + leftLen, inStart, rootIndexInorder - 1);
        node.right = buildTree(preorder, inorder, preStart + rootIndexInorder - inStart + 1, preEnd, rootIndexInorder + 1, inEnd);

        return node;
    }
}
