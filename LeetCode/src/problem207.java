import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: LeetCode problem207: 课程表问题，使用到dfs和图相关的知识
 * @date: 2020/3/19 16:10
 * @author: Finallap
 * @version: 1.0
 */
public class problem207 {
    //思路1：拓扑排序。构建的邻接表就是我们通常认识的邻接表，每一个结点存放的是后继结点的集合。
    //该方法的每一步总是输出当前无前趋（即入度为零）的顶点。为避免每次选入度为 $0$ 的顶点时扫描整个存储空间，可设置一个队列暂存所有入度为 $0$ 的顶点。
    //具体做法如下：
    //1、在开始排序前，扫描对应的存储空间，将入度为 0 的顶点均入队列。
    //2、只要队列非空，就从队首取出入度为 0 的顶点，将这个顶点输出到结果集中，并且将这个顶点的所有邻接点的入度减 1，在减 1 以后，发现这个邻接点的入度为 0 ，就继续入队。
    //最后检查结果集中的顶点个数是否和课程数相同即可。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites) {
            inDegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                inDegrees[cur]--;
                if (inDegrees[cur] == 0) queue.offer(cur);
            }
        }

        return numCourses == 0;
    }

    //思路2：构建逆邻接表，实现深度优先遍历。思路其实也很简单，其实就是检测这个有向图中有没有环，只要存在环，课程就不能完成。
    //注意：这个深度优先遍历得通过逆邻接表实现，当访问一个结点的时候，应该递归访问它的前驱结点，直至前驱结点没有前驱结点为止。
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (int j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }
}
