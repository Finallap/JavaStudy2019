package DJI_20200816;

import java.util.Map;
import java.util.Scanner;

/**
 * @description: Problem3
 * @date: 2020/8/16 19:49
 * @author: Finallap
 * @version: 1.0
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputText = sc.nextLine();
        int deleteNum = sc.nextInt();

        int[] count = new int[10];
        for (int i = 0;i<inputText.length();i++){
            int index = inputText.charAt(i) - '0';
            count[index] ++;
        }

        if (count[0] == inputText.length() - deleteNum){
            System.out.println(0);
            return;
        }

//        StringBuilder builder = new StringBuilder();
//        for (int i = 0;i<inputText.length();i++){
//            if ()
//        }

//        while (deleteNum != 0){
//
//            deleteNum--;
//        }

        System.out.println(0);
    }
}
