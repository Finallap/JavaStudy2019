import java.util.HashMap;

public class problem7_2 {
    //使用HashMap快速查找root所在位置
    private HashMap<Integer, Integer> indexForInOrder = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0)
            return null;

        for (int i = 0; i < in.length; i++)
            indexForInOrder.put(in[i], i);

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);

        int rootInIndex = indexForInOrder.get(root.val);
        root.left = reConstructBinaryTree(pre, preStart + 1, preStart + (rootInIndex - inStart), in, inStart, rootInIndex - 1);
        root.right = reConstructBinaryTree(pre, preStart + (rootInIndex - inStart) + 1, preEnd, in, rootInIndex + 1, inEnd);

        return root;
    }
}
