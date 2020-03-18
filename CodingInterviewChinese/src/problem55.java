/**
 * @description: 剑指 problem55: 求二叉树的深度，是否为平衡树
 * @date: 2020/3/18 13:18
 * @author: Finallap
 * @version: 1.0
 */
public class problem55 {
    //二叉树的深度，使用递归遍历方法
    public int TreeDepth(TreeNode node) {
        if (node == null)
            return 0;

        int left = TreeDepth(node.left);
        int right = TreeDepth(node.right);

        return Math.max(left, right) + 1;
    }


    //以下代码为判断是否为平衡树
    boolean isBanlanced = true;

    public int height(TreeNode node) {
        if (node == null || !isBanlanced)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        if (Math.abs(left - right) > 1)
            isBanlanced = false;
        return Math.max(left, right) + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBanlanced;
    }
}
