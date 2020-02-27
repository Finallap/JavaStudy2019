import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//把二叉树打印成多行
public class problem32_2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int currentLayerNodeNum = queue.size();
            while (currentLayerNodeNum-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0)
                result.add(list);
        }

        return result;
    }
}
