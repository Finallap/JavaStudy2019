package Alibaba_Taobao_20200301;

import java.util.ArrayList;

public class ali1 {
    private final ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Path(TreeNode root, int target) {
        Path(root, target, new ArrayList<>());
        return results;
    }

    public void Path(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target = target - node.val;
        if (target == 0 && node.left == null && node.right == null) {
            results.add(new ArrayList<>(path));
        } else {
            Path(node.left, target, path);
            Path(node.right, target, path);
        }

        path.remove(path.size() - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
