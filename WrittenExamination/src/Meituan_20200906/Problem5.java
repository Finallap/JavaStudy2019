package Meituan_20200906;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: Problem5
 * @date: 2020/9/6 11:46
 * @author: Finallap
 * @version: 1.0
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Long> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            list.remove(id);
            list.add(0, id);
        }
        for (long id : list) {
            System.out.println(id);
        }
    }
}
