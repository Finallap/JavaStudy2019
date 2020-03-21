import java.util.Arrays;

/**
 * @description: 剑指 problem61: 扑克牌的顺子，先排序，统计大小王个数，然后统计缺失牌数量，如果缺失的数能补足，则是顺子
 * @date: 2020/3/21 11:28
 * @author: Finallap
 * @version: 1.0
 */
public class problem61 {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5)
            return false;

        Arrays.sort(numbers);
        int count0 = 0;
        int lastNum = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count0++;
            } else {
                if (lastNum != -1) {
                    int gap = numbers[i] - lastNum;
                    if (gap == 0)
                        return false;
                    else if (gap > 1) {
                        count0 -= (gap - 1);
                        if (count0 < 0)
                            return false;
                    }
                }
                lastNum = numbers[i];
            }
        }
        return true;
    }
}
