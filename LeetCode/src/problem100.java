/**
 * @description: LeetCode problem100: 判断是不是两棵相同的树
 * @date: 2020/3/19 12:03
 * @author: Finallap
 * @version: 1.0
 */
public class problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;
        if (q.val != p.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
