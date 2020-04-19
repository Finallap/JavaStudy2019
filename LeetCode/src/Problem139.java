import java.util.*;

/**
 * @description: LeetCode Problem139: 单词拆分
 * @date: 2020/4/19 17:58
 * @author: Finallap
 * @version: 1.0
 */
public class Problem139 {
    //BFS方法，搜索单词结束的位置，看从start到end中间的子字符串存在不存在，如果存在则将end加入队列；如果搜索到结尾，则结束搜索
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int[] visited = new int[s.length()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean wordBreak(String s, Set<String> wordDictSet, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null)
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDictSet.contains(s.substring(start, end)) && wordBreak(s, wordDictSet, end, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}
