package Sort;

/**
 * @description: HeapSort_1:最大堆排序
 * @date: 2020/3/16 12:53
 * @author: Finallap
 * @version: 1.0
 */
public class HeapSort_1 {
    public static void heapsort(int[] array) {
        if (array == null || array.length == 0)
            return;

        buildArrayToHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            adjustHeap(array, i, 0);
        }
    }

    public static void buildArrayToHeap(int[] array) {
        if (array == null || array.length == 0)
            return;

        int cursor = array.length / 2;
        for (int i = cursor; i > 0; i--)
            adjustHeap(array, array.length, i);
    }

    public static void adjustHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxValue = index;
        if (right < heapSize && array[left] > array[maxValue])
            maxValue = left;
        if (right < heapSize && array[right] > array[maxValue])
            maxValue = right;
        if (index != maxValue) {
            swap(array, index, maxValue);
            adjustHeap(array, heapSize, maxValue);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56};
        System.out.println("排序前:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
        System.out.println("分割线---------------");
        heapsort(array);
        System.out.println("排序后:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
