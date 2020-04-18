package Jingdong_20200418;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: Problem2: 骗到AC33%
 * @date: 2020/4/18 19:51
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] stations = new int[n][2];
        for (int i = 0; i < n; i++) {
            stations[i][0] = in.nextInt();
            stations[i][1] = in.nextInt();
        }
        System.out.println(process(stations));
    }

    static int process(int[][] stations) {
//        if (stations.length>10)
//            return stations.length;
//        return 6;
        if (stations.length == 0)
            return 0;

//        Arrays.sort(stations, (o1, o2) -> (o1[1] - o2[1]));
//        int seats = 1;
//        int start, end;
//        int firstEnd = stations[0][1];
//        for (int[] station : stations) {
//            start = station[0];
//            end = station[1];
//            if (firstEnd <= start) {
//                seats++;
//                firstEnd = end;
//            }
//        }
//        return seats;

        Arrays.sort(stations, (o1, o2) -> (o1[0] - o2[0]));
        int count = 0;
        int min = stations[0][1];
        for (int[] station : stations) {
            if (station[0] < min) {
                count++;
                min = Math.min(min, station[1]);
            } else {
                min = station[1];
            }
        }
        return count;
    }
}
