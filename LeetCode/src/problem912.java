/**
 * @description: LeetCode problem912: 数组排序
 * @date: 2020/4/2 9:56
 * @author: Finallap
 * @version: 1.0
 */
public class problem912 {
    //快排
    public static void quickSort(int[] nums, int low, int high) {
        if (high < low)
            return;

        int key = nums[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && nums[j] >= key)
                j--;
            while (i < j && nums[i] <= key)
                i++;
            if (i < j)
                swap(nums, i, j);
        }
        swap(nums, i, low);
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //归并排序
    public static void mergeSort(int[] nums) {
        if (nums.length > 1) {
            int[] left = new int[nums.length / 2];
            System.arraycopy(nums, 0, left, 0, nums.length / 2);
            mergeSort(left);

            int[] right = new int[nums.length - nums.length / 2];
            System.arraycopy(nums, nums.length / 2, right, 0, nums.length - nums.length / 2);
            mergeSort(right);

            int[] result = merge(left, right);
            System.arraycopy(result, 0, nums, 0, nums.length);
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] temp = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int tempIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                temp[tempIndex++] = left[leftIndex++];
            } else {
                temp[tempIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            temp[tempIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            temp[tempIndex++] = right[rightIndex++];
        }

        return temp;
    }

    //插入排序
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertVal = nums[i];
            int index = i - 1;
            while (index >= 0 && nums[index] > insertVal) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = insertVal;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1])
                    swap(nums, j, j + 1);
            }
        }
    }

    //选择排序：每一轮选择最小元素交换到未排定部分的开头
    public static void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            swap(nums, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] list = {51, 23, 55, 63, 85, 45, 36, 54, 25, 63, 22, 52, 36, 57, 78, 23, 56, 123, 85, 75, 96, 35, 12};
//        quickSort(list, 0, list.length - 1);
//        mergeSort(list);
//        insertSort(list);
//        bubbleSort(list);
        selectSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
    }
}
