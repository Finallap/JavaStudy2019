import java.util.ArrayList;

/**
 * @description: 剑指 problem57_2: 和为s的连续正数数列
 * @date: 2020/3/18 16:07
 * @author: Finallap
 * @version: 1.0
 */
public class problem57_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int small = 1, big = 2;
        int curSum = 3;
        //至少有两个数字，当small都大于sum+1的一半时，两个数相加已经会大于sum，不可能实现结果
        while (small < (sum + 1) / 2) {
            if (curSum > sum) {
                curSum -= small;
                small++;
            } else if (curSum < sum) {
                big++;
                curSum += big;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum -= small;
                small++;
                big++;
                curSum += big;
            }
        }

        return ret;
    }
}
