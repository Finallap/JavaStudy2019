package Jianzhi;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    //构造带有参数的构造方法
    public TreeNode(int data) {
        this.val = data;
    }

    //重写toString方法
    public String toString() {
        return "TreeNode [data=" + val + ", left=" + left + ", right=" + right
                + "]";
    }
}
