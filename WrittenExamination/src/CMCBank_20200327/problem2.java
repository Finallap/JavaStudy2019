package CMCBank_20200327;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description: problem2
 * @date: 2020/3/27 19:42
 * @author: Finallap
 * @version: 1.0
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counts = sc.nextInt();

        for (int i = 0; i < counts; i++) {
            int len = sc.nextInt();
            int[] lens = new int[len];
            for (int j = 0; j < len; j++) {
                lens[j] = sc.nextInt();
            }
            int[] weights = new int[len];
            for (int j = 0; j < len; j++) {
                weights[j] = sc.nextInt();
            }
            calculation(lens, weights);
        }
    }

    public static void calculation(int[] lens, int[] weights) {
        int[] sum = new int[lens.length];
        for (int i = 0; i < lens.length; i++) {
            sum[i] = lens[i] + weights[i];
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<SUM> queue = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);
        for (int i = 0; i < lens.length; i++) {
            hashMap.put(sum[i], i);
            queue.offer(new SUM(i, sum[i]));
        }

        int result = 1;
//        int firstIndex = queue.poll().index;
//        int secondIndex;
//        while (!queue.isEmpty()) {
//            secondIndex = queue.poll().index;
//            if (lens[secondIndex] > lens[firstIndex] || weights[secondIndex] > weights[firstIndex]) {
//                result++;
//            }
//            firstIndex = secondIndex;
//        }

        int[][] dp = new int[lens.length][lens.length];
        for (int i = 1; i < lens.length; i++) {
            for (int j = 1; j < lens.length; j++) {
                dp[i][j] = dp[i][j];
            }
        }

        Arrays.sort(sum);
        for (int i = 1; i < lens.length; i++) {
            int firstIndex = hashMap.get(sum[i - 1]);
            int secondIndex = hashMap.get(sum[i]);
            if (lens[secondIndex] < lens[firstIndex] || weights[secondIndex] < weights[firstIndex]) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static class SUM {
        public int index;
        public int sum;

        public SUM(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}
