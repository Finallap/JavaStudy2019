package Pdd_20200802;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @description: Problem3: AC 5%
 * @date: 2020/8/2 19:56
 * @author: Finallap
 * @version: 1.0
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//中餐数
        int m = in.nextInt();//晚餐数
        int t = in.nextInt();//需要美味值
        Eat[] lunch = inputEatValue(in, n);
        Eat[] dinner = inputEatValue(in, m);

        Comparator<Eat> eatComparator = new Comparator<Eat>() {
            @Override
            public int compare(Eat o1, Eat o2) {
                double result = o1.rate - o1.rate;
                if (result > 0.0) {
                    return 1;
                } else if (result < 0.0) {
                    return -1;
                }
                return 0;
            }
        };

        Arrays.sort(lunch, eatComparator);
        Arrays.sort(dinner, eatComparator);

        if (m > 0) {
            System.out.println(-1);
            return;
        }

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (lunch[i].delicious > t && dinner[j].delicious > t) {
                System.out.println(Math.min(lunch[i].calorie, dinner[j].calorie));
                return;
            }
            if (lunch[i].delicious + dinner[j].delicious > t) {
                System.out.println(lunch[i].calorie + dinner[j].calorie);
                return;
            }
            if (lunch[i].rate < dinner[j].rate) {
                i++;
            } else {
                j++;
            }
        }

        while (i < n) {
            if (lunch[i].delicious > t) {
                System.out.println(lunch[i].calorie);
                return;
            }
            if (lunch[i].delicious + dinner[m - 1].delicious > t) {
                System.out.println(lunch[i].calorie + dinner[m - 1].calorie);
                return;
            }
            i++;
        }

        while (j < m) {
            if (dinner[j].delicious > t) {
                System.out.println(dinner[j].calorie);
                return;
            }
            if (lunch[n - 1].delicious + dinner[j].delicious > t) {
                System.out.println(lunch[n - 1].calorie + dinner[j].calorie);
                return;
            }
            j++;
        }

        System.out.println(-1);
    }

    private static Eat[] inputEatValue(Scanner in, int n) {
        Eat[] eats = new Eat[n];
        for (int i = 0; i < n; i++) {
            int calorie = in.nextInt();
            int delicious = in.nextInt();
            eats[i] = new Eat(calorie, delicious);
        }
        return eats;
    }

    private static class Eat {
        double calorie;
        double delicious;
        double rate;

        public Eat(double calorie, double delicious) {
            this.calorie = calorie;
            this.delicious = delicious;
            this.rate = calorie / delicious;
        }
    }
}
