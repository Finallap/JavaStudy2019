package Netease_20200407;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description: Problem3:AC 60%
 * @date: 2020/4/7 20:44
 * @author: Finallap
 * @version: 1.0
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int f = in.nextInt();

        Set<Integer> patientSet = new TreeSet<>();
        patientSet.add(f);
        for (int i = 0; i < m; i++) {
            int partyNum = in.nextInt();
            int[] num = new int[partyNum];
            boolean flag = false;
            for (int j = 0; j < partyNum; j++) {
                num[j] = in.nextInt();
                if (patientSet.contains(num[j])) {
                    flag = true;
                }
            }
            if (flag) {
                for (int j = 0; j < partyNum; j++) {
                    patientSet.add(num[j]);
                }
            }
        }

        System.out.println(patientSet.size());
    }
}
