package Ctrip_20200401;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @description: problem2
 * 携程海洋馆中有 n 只萌萌的小海豚，初始均为 0 岁，每只小海豚的寿命是 m 岁，
 * 且这些小海豚会在 birthYear[i] 这些年份生产出一位宝宝海豚（1 <= birthYear[i] <= m），每位宝宝海豚刚出生为 0 岁。
 * 问 x 年时，携程海洋馆有多少只小海豚？
 * <p>
 * 输入
 * n（初始海豚数）
 * m（海豚寿命）
 * 海豚生宝宝的年份数量(假设为p)
 * 海豚生宝宝的年份1
 * ...
 * 海豚生宝宝的年份p
 * x（几年后）
 * <p>
 * 输出
 * x年后，共有多少只小海豚
 * <p>
 * 样例输入
 * 5
 * 5
 * 2
 * 2
 * 4
 * 5
 * 样例输出
 * 20
 * <p>
 * AC：25%,其他超时
 * @date: 2020/4/1 19:41
 * @author: Finallap
 * @version: 1.0
 */
public class problem2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static long countDolphin(int n, int m, int[] birthYear, int x) {
        //只计算一只的历程
        int result = 1;
        int currentYear = 1;
        int currentId = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(currentId++, 0);

        TreeSet<Integer> birthYearSet = new TreeSet<>();
        for (int i = 0; i < birthYear.length; i++) {
            birthYearSet.add(birthYear[i]);
        }

        while (!hashMap.isEmpty() && currentYear < x) {
            Iterator<Integer> iterator = hashMap.keySet().iterator();
            int willInsert = 0;
            while (iterator.hasNext()) {
                int key = iterator.next();
                int currentOld = hashMap.get(key) + 1;
                hashMap.put(key, currentOld);
                if (currentOld >= m) {
                    hashMap.remove(key);
                    result--;
                }
                if (birthYearSet.contains(currentOld)) {
                    willInsert++;
                }
            }
            for (int i = 0; i < willInsert; i++) {
                hashMap.put(currentId++, 0);
                result++;
            }
            currentYear++;
        }

        return result * n;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _birthYear_size = 0;
        _birthYear_size = Integer.parseInt(in.nextLine().trim());
        int[] _birthYear = new int[_birthYear_size];
        int _birthYear_item;
        for (int _birthYear_i = 0; _birthYear_i < _birthYear_size; _birthYear_i++) {
            _birthYear_item = Integer.parseInt(in.nextLine().trim());
            _birthYear[_birthYear_i] = _birthYear_item;
        }

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = countDolphin(_n, _m, _birthYear, _x);
        System.out.println(res);

    }
}
