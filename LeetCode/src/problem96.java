/**
 * @description: LeetCode problem96: 不同的二叉搜索树，G(n) = G(0)*G(n-1)+G(1)G(n-2)+G(2)G(n-3)+...+G(n-1)G(0)
 * @date: 2020/3/20 13:11
 * @author: Finallap
 * @version: 1.0
 */
public class problem96 {
    //令G(n)表示n个节点二叉排序树的个数，f(i)表示以i作为根节点的二叉排序树的个数
    //因此有：G(n) = f(1)+f(2)+f(3)+...+f(n)
    //以i为根节点的左子树有i-1个节点，因此左子树有G(i-1)种二叉排序树
    //右子树有n-i个节点，因此右子树有G(n-i)种二叉排序树
    //从而得到：f(i) = G(i-1)*G(n-i)
    //最后得到G(n) = G(0)*G(n-1)+G(1)G(n-2)+G(2)G(n-3)+...+G(n-1)G(0)
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
