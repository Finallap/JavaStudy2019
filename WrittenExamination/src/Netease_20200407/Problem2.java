package Netease_20200407;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description: Problem2:AC 60%
 * @date: 2020/4/7 20:12
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int D = in.nextInt();

        int[] hurts = new int[n];
        int[] defences = new int[n];

        PriorityQueue<Monster> queue = new PriorityQueue<>((o1, o2) -> o1.defence - o2.defence);

        for (int i = 0; i < n; i++) {
            defences[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            hurts[i] = in.nextInt();
            queue.offer(new Monster(defences[i], hurts[i]));
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            Monster monster = queue.poll();
            if (D < monster.defence) {
                ans += monster.hurt;
            }
            D++;
        }

        System.out.println(ans);
    }

    static class Monster {
        public int defence;
        public int hurt;

        public Monster(int defence, int hurt) {
            this.defence = defence;
            this.hurt = hurt;
        }
    }
}
