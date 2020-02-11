import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class problem39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, new LinkedList<Integer>(), 0, results);
        return results;
    }

    public void backtrack(int[] candidates, int target, LinkedList<Integer> track, int start, List<List<Integer>> results) {
        if (target < 0) return;
        if (target == 0) {
            results.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) break;//不能满足，剪枝
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], track, i, results);
            track.removeLast();
        }
    }

//    public static void main(String[] args) {
//        combinationSum(new int[]{2, 3, 6, 7}, 7);
//        System.out.println(result);
//    }
}
