/**
 * 位运算
 *
 * @author Finallap
 */
public class problem15 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int NumberOf1_2(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 统计二进制有几个位数不同
     *
     * @author Finallap
     */
    public static int countDiff(int n, int m) {
        int temp = n ^ m;
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp & temp - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDiff(5, 14));
    }
}
