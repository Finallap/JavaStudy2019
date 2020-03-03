package Search;

/**
 * @description: Search.biSearch：二分查找
 * @date: 2020/2/29 15:53
 * @author: Finallap
 * @version: 1.0
 */
public class biSearch {
    public static int biSearch(int[] array, int target) {
        if (array == null || array.length == 0)
            return -1;

        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start < end) {
            mid = (end - start) / 2;
            if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 6, 9, 10, 13, 15, 16, 18, 20, 23, 25, 26, 29, 30, 31, 35, 40, 50};
        System.out.println(biSearch(array, 20));
    }
}
