import java.util.*;

public class problem32_3 {
    //使用两个栈来实现
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null)
            return result;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        int currentLayer = 1;

        while (stack1.size() != 0 || stack2.size() != 0) {
            ArrayList<Integer> list = new ArrayList<>();
            if (currentLayer % 2 == 1) {
                int currentLayerNodeNum = stack1.size();
                while (currentLayerNodeNum-- > 0) {
                    TreeNode node = stack1.pop();
                    if (node == null)
                        continue;
                    list.add(node.val);
                    stack2.push(node.left);
                    stack2.push(node.right);
                }
            } else {
                int currentLayerNodeNum = stack2.size();
                while (currentLayerNodeNum-- > 0) {
                    TreeNode node = stack2.pop();
                    if (node == null)
                        continue;
                    list.add(node.val);
                    stack1.push(node.right);
                    stack1.push(node.left);
                }
            }
            if (list.size() != 0)
                result.add(list);
            currentLayer++;
        }

        return result;
    }

    //使用队列来实现
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int currentLayer = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int currentLayerSize = queue.size();
            while (currentLayerSize-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0) {
                if (currentLayer % 2 == 0)
                    Collections.reverse(list);

                result.add(list);
            }
            currentLayer++;
        }
        return result;
    }
}
