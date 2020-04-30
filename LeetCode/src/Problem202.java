import java.util.HashSet;

/**
 * @description: LeetCode Problem202: 快乐数
 * @date: 2020/5/1 18:49
 * @author: Finallap
 * @version: 1.0
 */
public class Problem202 {
    //使用HashSet检测是否存在循环
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(n);
        while (n != 1) {
            int squareSum = squareSum(n);
            if (hashSet.contains(squareSum)) {
                return false;
            }
            hashSet.add(squareSum);
            n = squareSum;
        }
        return true;
    }

    public int squareSum(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }

    //使用快慢指针进行检测
    public boolean isHappy1(int n) {
        int slow = n;
        int fast = squareSum(n);
        while (fast != 1 && slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return fast == 1;
    }
}
