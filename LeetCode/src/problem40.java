import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        backtrack(candidates, target, results, 0, new LinkedList<Integer>());
        return results;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> results, int start, LinkedList<Integer> track) {
        if (target < 0) return;
        if (target == 0) {
            results.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            if (i > start && candidates[i] == candidates[i - 1])//去重
                continue;
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], results, i + 1, track);//从下一个数字开始，不再重复使用当前的数字
            track.removeLast();
        }
    }
}
