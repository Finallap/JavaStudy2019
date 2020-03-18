/**
 * @description: 剑指 problem53_3:寻找数值和下标相等的元素
 * @date: 2020/3/17 14:17
 * @author: Finallap
 * @version: 1.0
 */
public class problem53_3 {
    public static int findNumberSameAsIndex(int[] array) {
        int len = array.length;
        if (len == 0)
            return -1;

        int low = 0, high = len;
        while (low < high) {
            int mid = low + high >> 1;
            if (array[mid] > mid)
                high = mid - 1;
            else if (array[mid] < mid)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {-5, -2, -1, 0, 2, 3, 6, 9};
        System.out.println(findNumberSameAsIndex(array));
    }
}
