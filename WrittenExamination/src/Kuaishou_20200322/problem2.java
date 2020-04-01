package Kuaishou_20200322;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description: problem2
 * @date: 2020/3/22 19:21
 * @author: Finallap
 * @version: 1.0
 * <p>
 * 输入：[1 22 22 33 22 12 45 44 5]
 * 输出：[4 7]
 * <p>
 * 结果：AC100%
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputStrings = input.split(" ");
        if (inputStrings == null || inputStrings.length == 0)
            return;

        int[] nums = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            nums[i] = Integer.parseInt(inputStrings[i]);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() != 0 && queue.peek() > nums[i]) {
                int firstMax = queue.poll();
                if (queue.size() != 0) {
                    int secondMax = queue.peek();
                    if (secondMax <= nums[i]) {
                        list.add(i);
                    }
                } else {
                    list.add(i);
                }
                queue.offer(firstMax);
            }
            queue.offer(nums[i]);
        }

        if (list.size() == 0) {
            System.out.print(-1);
            return;
        }

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    //    public static int findLongestIncreaseSeq1(int[] A) {
//        int n = A.length;
//        int[] B = new int[n + 1];
//        B[1] = A[0];
//        int len = 1, start = 0, end = len, mid;
//        for (int i = 1; i < n; i++) {
//            if (A[i] > B[len]) {
//                len++;
//                B[len] = A[i];
//            } else {
//                start = 1;
//                end = len;
//                while (start <= end) {
//                    mid = (start + end) / 2;
//                    if (B[mid] < A[i])
//                        start = mid + 1;
//                    else
//                        end = mid - 1;
//                }
//                B[start] = A[i];
//            }
//        }
//        return len;
//    }
}
