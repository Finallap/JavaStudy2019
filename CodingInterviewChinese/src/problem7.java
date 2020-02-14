public class problem7 {
    //使用前序和中序遍历结果重建二叉树
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0)
            return null;

        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);

        for (int i = inStart; i < inEnd; i++) {
            //判断是否是根，从而区分左子树、右子树
            if (pre[preStart] == in[i]) {

                /*
                 * 接着进行递归，因为得到中序的根节点后，中序数组根节点左边的元素为左子树，右边的元素为右子树
                 * 计算左右子树的起始和结束下标，然后继续进行递归
                 * */
                /*计算左树子节点其实结束下标
                 * 前序起始位置startPre = 原来的前序的startPre后移一位，也就是 startPre = startPre + 1
                 * 前序结束下标endPre = 前序起始位置 + 左子树元素的长度，左子树长度=查出的中序根节点下标值减去中序的初始下标，
                 * 也就是左子树长度 = i - startIn,综合起来就是前序结束下标 enPre = startPre + i - startIn。
                 *
                 * 中序起始位置startIn = startIn ，保持不变
                 * 前序结束下标endIn = 查出来的中序根节点下标值 - 1，即endIn = i-1。
                 */
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + (i - inStart),
                        in, inStart, i - 1);

                /*
                 * 前序起始位置其实就是左子树前序结束下标+1，因为总的前序被分为两部分，一部分为左子树的前序，
                 * 一部分为右子树的前序，既然左子树的前序结束下标为endPre = startPre+i-startIn,
                 * 那么右子树的起始下标startIn=startPre+i-startIn+1
                 * 右子树的前序结束下标endPre = endPre
                 *
                 * 右子树的中序起始下标startIn同理，左右子树的中序也将总的中序分为两部分，而且处于查出来的中序根节点下标值的两边，
                 * 即左子树结束下标为i-1，右子树起始下标为i+1，而右子树的结束下标也自然而然是endIn。
                 * */
                root.right = reConstructBinaryTree(pre, (i - inStart) + preStart + 1, preEnd,
                        in, i + 1, inEnd);
                break;
            }
        }

        return root;
    }
}
