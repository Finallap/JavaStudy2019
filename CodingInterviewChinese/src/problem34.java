import java.util.ArrayList;

/**
 * @description: problem34
 * 二叉树中，和为某一值的路径
 * @date: 2020/2/29 11:17
 * @author: Finallap
 * @version: 1.0
 */
public class problem34 {
    private ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        FindPath(root, target, new ArrayList<>());
        return results;
    }

    public void FindPath(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target = target - node.val;
        if (target == 0 && node.left == null && node.right == null) {
            results.add(new ArrayList<>(path));
            //这个地方一定要注意，要新生产一个ArrrayList，直接加以前的会导致最后删除所有元素为空
        } else {
            FindPath(node.left, target, path);
            FindPath(node.right, target, path);
        }

        path.remove(path.size() - 1);
    }
}