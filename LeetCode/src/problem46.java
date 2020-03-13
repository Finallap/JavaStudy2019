import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem46 {
    //回溯法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        //将数组转化为list
        ArrayList<Integer> nums_list = new ArrayList<>();
        for (int num : nums)
            nums_list.add(num);

        int len = nums.length;
        backtrack(len, nums_list, results, 0);

        return results;
    }

    private void backtrack(int len, ArrayList<Integer> nums, List<List<Integer>> results, int first) {
        if (first == len)
            results.add(new ArrayList<Integer>(nums));

        for (int i = first; i < len; i++) {
            Collections.swap(nums, first, i);
            backtrack(len, nums, results, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}
