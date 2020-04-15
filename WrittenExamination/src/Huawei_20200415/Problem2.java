package Huawei_20200415;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @description: Problem2:AC100%
 * @date: 2020/4/15 19:27
 * @author: Finallap
 * @version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        String[] strs = input.split(" ");
        if (strs.length != 2) {
            System.out.println("FAIL");
            return;
        }

        String nameStr = strs[0];
        String waitingMatch = strs[1];

        String[] matchStrs = waitingMatch.split("],");
        for (int i = 0; i < matchStrs.length - 1; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(matchStrs[i]);
            sb.append("]");
            matchStrs[i] = sb.toString();
        }

        int count = 0;
        for (int i = 0; i < matchStrs.length; i++) {
            String pattern = "^" + nameStr + "\\[addr=.*,mask=.*,val=.*]$";
            if (!Pattern.matches(pattern, matchStrs[i])) {
                continue;
            }

            String innerStr = matchStrs[i].substring(nameStr.length() + 1, matchStrs[i].length() - 1);

            String[] subStrs = innerStr.split(",");
            if (subStrs.length != 3)
                continue;

            StringBuffer stringBuffer = new StringBuffer();
            String addr = "", mask = "", val = "";
            for (int j = 0; j < 3; j++) {
                String[] subSubStrs = subStrs[j].split("=");
                if (subSubStrs.length != 2)
                    continue;
                if (j == 0 && !subSubStrs[0].equals("addr")) continue;
                if (j == 1 && !subSubStrs[0].equals("mask")) continue;
                if (j == 2 && !subSubStrs[0].equals("val")) continue;

                if (!subSubStrs[1].startsWith("0x") && !subSubStrs[1].startsWith("0X"))
                    continue;

                if (j == 0) addr = subSubStrs[1];
                if (j == 1) mask = subSubStrs[1];
                if (j == 2) val = subSubStrs[1];
            }
            if (!addr.equals("") && !mask.equals("") && !val.equals("")) {
                count++;
                System.out.println(addr + " " + mask + " " + val + " ");
            }
        }

        if (count == 0)
            System.out.println("FAIL");
    }
}
