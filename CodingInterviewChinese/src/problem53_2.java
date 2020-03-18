/**
 * @description: 剑指 problem53_2: 寻找0~n-1中缺失的数字
 * @date: 2020/3/17 13:48
 * @author: Finallap
 * @version: 1.0
 */
public class problem53_2 {
    public static int findMissingValue(int[] array) {
        int len = array.length;
        if (len == 0)
            return 0;

        int low = 0, high = len;
        while (low < high) {
            int mid = low + high >> 1;
            if (mid != array[mid]) {
                if (mid == 0 || array[mid - 1] == mid - 1)
                    return mid;
                high = mid - 1;
            }
            if (mid == array[mid]) {
                low = mid + 1;
            }
        }
        if (low == len)
            return len;

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 6};
        System.out.println(findMissingValue(array));
    }
}
