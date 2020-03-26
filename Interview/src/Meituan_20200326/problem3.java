package Meituan_20200326;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description: problem3
 * 题目描述：
 * 一个序列是有趣的需要满足：当且仅当这个序列的每一个元素ai 满足 i 整除ai 。
 * 现在给定一个长度为n的数组，问这个数组有多少个非空的子序列是有趣的，由于答案可能比较大，只需要输出在模998244353意义下答案的就行了。
 * 一个长度为n的数组的非空子序列定义为从这个数组中移除至多n-1个元素后剩下的元素有序按照原顺序形成的数组。比如说对于数组[3,2,1]，它的非空子序列有[3],[2],[1],[3,2],[3,1],[2,1],[3,2,1]。
 * <p>
 * 输入
 * 第一行一个整数n表示序列的长度。(1<=n<=1e5)
 * 第二行n个整数表示给定的序列。(1<=ai<=1e6)
 * <p>
 * 输出
 * 输出一个数表示有趣的子序列的个数。
 * <p>
 * 样例输入
 * 2
 * 3 1
 * 样例输出
 * 2
 * @date: 2020/3/26 19:55
 * @author: Finallap
 * @version: 1.0
 */
public class problem3 {
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        if (len == 0) {
            System.out.print(result);
            return;
        }

        ArrayList<Integer> candidates = new ArrayList<>();
        while (sc.hasNextInt()) {
            candidates.add(sc.nextInt());
        }

        backtrack(candidates, 0, new LinkedList<>());
        System.out.print(result);
    }

    private static void backtrack(ArrayList<Integer> candidates, int start, LinkedList<Integer> track) {
        if (track.size() != 0 && track.peekLast() % track.size() != 0) {
            return;
        } else if (track.size() != 0 && isFunny(track))
            result = (result + 1) % 998244353;

        for (int i = start; i < candidates.size(); i++) {
            track.add(candidates.get(i));
            backtrack(candidates, i + 1, track);
            track.removeLast();
        }
    }

    public static boolean isFunny(LinkedList<Integer> track) {
        int len = track.size();
//        for (Integer num : track) {
//            if (num % len != 0) {
//                return false;
//            }
//        }

        for (int i = 0; i < len; i++) {
            if (track.get(i) % (i + 1) != 0) {
                return false;
            }
        }
        return true;
    }
}
