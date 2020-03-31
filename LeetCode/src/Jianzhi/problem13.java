package Jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 剑指 problem13: 机器人的运动范围
 * 使用DFS和BFS两种方法来解
 * @date: 2020/3/31 17:05
 * @author: Finallap
 * @version: 1.0
 */
public class problem13 {
    //DFS解法
    int m, n, k;
    boolean[][] flags;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        flags = new boolean[m][n];

        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        if (i >= m || i < 0 || j >= n || j < 0 || si + sj > k || flags[i][j])
            return 0;

        flags[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    //BFS解法
    //BFS一般使用队列实现，当queue 为空，代表已遍历完所有可达解
    public int movingCount1(int m, int n, int k) {
        int result = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] currentPoint = queue.poll();
            int i = currentPoint[0], j = currentPoint[1], si = currentPoint[2], sj = currentPoint[3];
            if (i < 0 || j < 0 || i >= m || j >= n || si + sj > k || visited[i][j])
                continue;
            visited[i][j] = true;
            result++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return result;
    }
}
