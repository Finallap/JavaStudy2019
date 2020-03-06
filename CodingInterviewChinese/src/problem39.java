/**
 * @description: problem39:找出数组中出现次数多于一般的数字，多数投票问题，
 * 利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，时间复杂度 O(N)
 * @date: 2020/3/6 14:20
 * @author: Finallap
 * @version: 1.0
 */
public class problem39 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int result = array[0];
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            count = array[i] == result ? count + 1 : count - 1;
            if (count == 0) {
                result = array[i];
                count = 1;
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result)
                count++;
        }

        return count > (array.length / 2) ? result : 0;
    }
}
