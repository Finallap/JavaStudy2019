import java.util.ArrayList;
import java.util.List;

/**
 * @description: LeetCode Problem78: 子集，回溯法，用start标记数字开始的地方，然后做选择、回溯、删除选择
 * @date: 2020/4/10 19:44
 * @author: Finallap
 * @version: 1.0
 */
public class Problem78 {
    List<List<Integer>> list = new ArrayList<>();
    int len;

    public List<List<Integer>> subsets(int[] nums) {
        len = nums.length;
        for (int i = 0; i <= len; i++) {
            dfs(0, new ArrayList<>(), nums, i);
        }

        return list;
    }

    public void dfs(int first, ArrayList<Integer> curr, int[] nums, int currLen) {
        if (curr.size() == currLen) {
            list.add(new ArrayList<>(curr));
        }

        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(i + 1, curr, nums, currLen);
            curr.remove(curr.size() - 1);
        }
    }
}
