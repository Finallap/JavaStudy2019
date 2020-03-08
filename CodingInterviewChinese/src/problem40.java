import java.util.ArrayList;

/**
 * @description: problem40:寻找前n小的数，使用快速排序方法
 * @date: 2020/3/8 14:12
 * @author: Finallap
 * @version: 1.0
 */
public class problem40 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0)
            return result;

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(input, start, end);
        }

        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private static int partition(int[] input, int start, int end) {
        int key = input[start];
        int i = start, j = end;
        while (i < j) {
            while (input[j] >= key && i < j)
                j--;
            while (input[i] <= key && i < j)
                i++;
            if (i < j) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        input[start] = input[i];
        input[i] = key;

        return j;
    }

    public static void main(String[] args) {
        int[] list = {51, 23, 55, 63, 85, 45, 36, 54, 25, 63, 22, 52, 36, 45, 78, 23, 56, 45, 85, 75, 96, 35, 12};
        ArrayList<Integer> result = GetLeastNumbers_Solution(list, 6);
        System.out.println(result);
    }
}
