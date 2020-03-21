import java.util.LinkedList;

/**
 * @description: 剑指 problem62: 圆圈中最后剩下的数字，即约瑟夫环问题
 * @date: 2020/3/21 11:59
 * @author: Finallap
 * @version: 1.0
 */
public class problem62 {
    //使用LinkedList解决
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
            list.add(i);

        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }

        return list.peek();
    }

    //使用递推公式解决
    //f(n,m) = (f(n-1,m) + m) %m
    public int LastRemaining_Solution1(int n, int m) {
        if (n < 1 || m < 1)
            return -1;

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
