/**
 * @description: 剑指 problem63: 股票买卖问题
 * @date: 2020/3/28 19:11
 * @author: Finallap
 * @version: 1.0
 */
public class problem63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int minPrice = Math.min(prices[0], prices[1]);
        int maxResult = prices[1] - minPrice;

        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];

            int result = prices[i] - minPrice;
            if (result > maxResult)
                maxResult = result;
        }

        return maxResult;
    }
}
