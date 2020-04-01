package Ctrip_20200401;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: ctrip_20200401.problem1
 * 输入
 * 输入一个n表示要输入的通话记录个数，接下来输入n行，每行为逗号相隔的两个整数，两个数字分别代表呼入时间和挂断时间的时间戳。 举例：10,30，表示[10,30)，代表第10秒呼入，第30秒已经挂断，即第30秒可以接入新的来电； 每一行都是一条通话记录，通话记录已经按呼入时间由小到大排序；
 * <p>
 * 输出
 * 输出一个整数；
 * <p>
 * 代表最少需要多少客服，可以满足所有旅客来电不用等待。
 * <p>
 * <p>
 * 样例输入
 * 6
 * 0,30
 * 0,50
 * 10,20
 * 15,30
 * 20,50
 * 20,65
 * 样例输出
 * 5
 * <p>
 * AC:70%，其他超时
 * @date: 2020/4/1 19:32
 * @author: Finallap
 * @version: 1.0
 */
public class problem1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int calcMinStaff(Scanner in) {
        int result = 1;

        int count = in.nextInt();
        in.nextLine();
        int[] ends = new int[count];
        int[] startRecords = new int[count];
        int[] endRecords = new int[count];

        if (count <= 0)
            return 0;

        for (int i = 0; i < count; i++) {
            String inputString = in.nextLine();
            String[] strAarray = inputString.split(",");
            startRecords[i] = Integer.parseInt(strAarray[0]);
            endRecords[i] = Integer.parseInt(strAarray[1]);
//            int startTime = Integer.parseInt(strAarray[0]);
//            int endTime = Integer.parseInt(strAarray[1]);
//
//            boolean flag = false;
//            for (int j = 0; j < result; j++) {
//                if (startTime >= ends[j] && !flag) {
//                    ends[j] = endTime;
//                    flag = true;
//                }
//                if (startTime >= ends[j] && flag)
//                    ends[j] = 0;
//            }
//            if (!flag) {
//                ends[result] = endTime;
//                result++;
//            }
        }
        Arrays.sort(startRecords);
        Arrays.sort(endRecords);
        int maxStartRecords = startRecords[startRecords.length - 1];
        int minEndRecords = endRecords[0];

        return result;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        res = calcMinStaff(in);
        System.out.println(res);

    }
}
