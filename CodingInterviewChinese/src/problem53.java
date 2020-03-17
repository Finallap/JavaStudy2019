/**
 * @description: 剑指 problem53：数字在排序数组中出现的次数
 * @date: 2020/3/17 12:53
 * @author: Finallap
 * @version: 1.0
 */
public class problem53 {
    //使用二分搜索的方法搜索第一个数和最后一个数的index
    public static int GetNumberOfK(int[] array, int k) {
        if (array.length == 0)
            return 0;

        int low = 0, high = array.length;
        int first = findFirstNumberOfK(array, k, low, high);
        int last = findLastNumberOfK(array, k, low, high);
        if (first != -1 && last != -1)
            return last - first + 1;
        else
            return 0;
    }

    public static int findFirstNumberOfK(int[] array, int k, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) >> 1;
        if (array[mid] < k)
            return findFirstNumberOfK(array, k, mid + 1, high);
        else if (array[mid] > k)
            return findFirstNumberOfK(array, k, low, mid - 1);
        else if (mid - 1 >= 0 && array[mid - 1] == k)
            return findFirstNumberOfK(array, k, low, mid - 1);
        else
            return mid;

    }

    public static int findLastNumberOfK(int[] array, int k, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) >> 1;
        if (array[mid] < k)
            return findLastNumberOfK(array, k, mid + 1, high);
        else if (array[mid] > k)
            return findLastNumberOfK(array, k, low, mid - 1);
        else if (mid + 1 < array.length && array[mid + 1] == k)
            return findLastNumberOfK(array, k, mid + 1, high);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 3, 4, 6};
        System.out.println(GetNumberOfK1(array, 3));
    }

    //    因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，
//    而是搜索(k-0.5)和(k+0.5)这两个数应该插入的位置，然后相减即可。
//    需要对二分法的代码进行简单的变形修改。
    public static int GetNumberOfK1(int[] array, int k) {
        if (array.length == 0)
            return 0;
        int first = findNumberOfK(array, k - 0.5);
        int last = findNumberOfK(array, k + 0.5);
        return last - first;
    }

    private static int findNumberOfK(int[] array, double k) {
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (array[mid] > k)
                high = mid - 1;
            if (array[mid] < k)
                low = mid + 1;
        }
        return low;
    }
}
