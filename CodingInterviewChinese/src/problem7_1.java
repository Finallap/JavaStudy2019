public class problem7_1 {
    public class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        //构造带有参数的构造方法
        public TreeNode(int data) {
            this.data = data;
        }

        //重写toString方法
        public String toString() {
            return "TreeNode [data=" + data + ", left=" + left + ", right=" + right
                    + "]";
        }
    }

    //使用中序和后序遍历结果重建二叉树
    public TreeNode reConstructBinaryTree(int[] in, int[] post) {
        if (in == null || post == null || in.length < 1 || in.length != post.length)
            return null;

        TreeNode root = reConstructBinaryTree(in, 0, in.length - 1, post, 0, post.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(post[postEnd]);
        for (int i = postEnd; i >= 0; i--) {
            if (in[i] == post[postEnd]) {
                root.left = reConstructBinaryTree(in, inStart, i - 1, post, postStart, postStart + (i - inStart) - 1);
                root.right = reConstructBinaryTree(in, i + 1, inEnd, post, postStart + (i - inStart), postEnd - 1);
                break;
            }
        }

        return root;
    }
}
