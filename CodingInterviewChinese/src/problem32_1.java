import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从左到右打印二叉树，宽度优先搜索，使用队列解决
public class problem32_1 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                continue;
            result.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
        return result;
    }
}
