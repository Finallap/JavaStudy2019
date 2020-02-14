public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

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
