import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: LeetCode problem94:二叉树中序遍历非递归，用栈实现
 * @date: 2020/3/16 16:24
 * @author: Finallap
 * @version: 1.0
 */
public class problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
