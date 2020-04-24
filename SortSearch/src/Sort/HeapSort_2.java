package Sort;

/**
 * @description: HeapSort_2
 * @date: 2020/4/24 16:08
 * @author: Finallap
 * @version: 1.0
 */
public class HeapSort_2 {
    public static void main(String[] args) {
        int[] nums = {16, 7, 3, 20, 17, 8};
        headSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void headSort(int[] nums) {
        //构造初始堆，从第一个非叶子节点开始调整，左右节点中最大的交换到父节点中
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapAdjust(nums, nums.length, i);
        }

        //排序，将最大节点放到末尾，然后根据根节点重新调整
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, i, 0);
        }
    }

    public static void heapAdjust(int[] nums, int len, int i) {
        int k = i;
        //左孩子
        int index = 2 * k + 1;
        while (index < len) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (index + 1 < len && nums[index] < nums[index + 1])
                index = index + 1;
            // 如果父结点的值已经大于孩子结点的值，则直接结束，否则进行操作
            if (nums[k] < nums[index]) {
                swap(nums, k, index);
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
