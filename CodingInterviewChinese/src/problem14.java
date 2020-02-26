//剪绳子
public class problem14 {
    //动态规划法，时间复杂度O(n^2)
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (2 == target) return 1;
        if (3 == target) return 2;

        int[] products = new int[target + 1];

        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= target; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int result = products[j] * products[i - j];
                if (result > max)
                    max = result;
                products[i] = max;
            }
        }
        return products[target];
    }

    //贪婪法求解
    public int cutRope2(int target) {
        if (target == 1) return 1;
        if (target == 2) return 1;
        if (target == 3) return 2;

        int timeOf3 = target / 3;

        if (target - timeOf3 * 3 == 1)
            timeOf3--;

        int timeOf2 = (target - timeOf3 * 3) / 2;

        return (int) Math.pow(3, timeOf3) * (int) Math.pow(2, timeOf2);
    }
}
