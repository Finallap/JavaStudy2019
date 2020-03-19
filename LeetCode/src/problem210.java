import java.util.*;

/**
 * @description: LeetCode problem210: 课程表 II，同样使用拓扑排序或dfs
 * @date: 2020/3/19 20:10
 * @author: Finallap
 * @version: 1.0
 */
public class problem210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //极端情况
        if (numCourses == 0)
            return new int[0];

        //入度表
        int[] inDegrees = new int[numCourses];
        //构建邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        //邻接表幅值
        for (int[] cp : prerequisites) {
            inDegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        //构建入度为0的队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0)
                queue.offer(i);
        }

        //结果列表
        List<Integer> list = new ArrayList<>();
        int coursesCount = numCourses;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            list.add(pre);
            coursesCount--;
            for (int curr : adjacency.get(pre)) {
                if (--inDegrees[curr] == 0) {
                    queue.offer(curr);
                }
            }
        }

        //判断是否全部课程已经修完
        if (coursesCount == 0) {
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++)
                ret[i] = list.get(i);
            return ret;
        } else
            return new int[0];
    }

    //使用dfs的方法
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        //极端情况
        if (numCourses == 0)
            return new int[0];

        //入度表
        int[] inDegrees = new int[numCourses];
        //构建邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        //邻接表幅值
        for (int[] cp : prerequisites) {
            inDegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        int[] flags = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, stack, i))
                return new int[0];
        }

        if (stack.size() == numCourses) {
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = stack.pop();
            }
            return ret;
        } else
            return new int[0];
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, Stack<Integer> stack, int i) {
        // 从正在访问中，到正在访问中，表示遇到了环
        if (flags[i] == 1) return false;
        // 如果访问过了，就不用再访问了
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (int curr : adjacency.get(i)) {
            if (!dfs(adjacency, flags, stack, curr))
                return false;
        }
        // i 的所有后继结点都访问完了，都没有存在环，则这个结点就可以被标记为已经访问结束
        flags[i] = -1;
        // i可以放入结果栈中
        stack.add(i);
        return true;
    }
}
