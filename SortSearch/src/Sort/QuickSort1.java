package Sort;

/**
 * @description: Sort.QuickSort1:快速排序
 * @date: 2020/3/1 19:31
 * @author: Finallap
 * @version: 1.0
 */
public class QuickSort1 {
    public static void quicksort(int[] list, int start, int end) {
        if (end < start) {
            return;
        }

        int i = start, j = end;
        int key = list[start];
        while (i < j) {
            while (key <= list[j] && i < j)
                j--;

            while (key >= list[i] && i < j)
                i++;

            if (i < j) {
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        list[start] = list[i];
        list[i] = key;

        quicksort(list, start, i - 1);
        quicksort(list, i + 1, end);
    }


    public static void main(String[] args) {
        int[] list = {51, 23, 55, 63, 85, 45, 36, 54, 25, 63, 22, 52, 36, 45, 78, 23, 56, 45, 85, 75, 96, 35, 12};
        quicksort(list, 0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
    }
}
