package ByteDance_20200418;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @description: Problem1
 * 给出一个分子式，比如： HMg2(H2O(N3Ag)2)3N2 计算这个分子式中每个原子出现了多少次，输出一个 map，比如上面的分子式中： map<string, int> {"H": 7, "Mg": 2,"Ag": 6, "N": 20，"O": 3}
 * 分子式的规则：
 * 1. 都以大写字母开头，后面跟 0 个或者 1 个小写字母，比如 Mg, H
 * 2. 单个原子后面跟 0 个或者 1 个数字表示它出现的次数，比如 Mg2 表示 Mg 出现 2 次，数字范围 2-1000
 * 3. 分子式中可能有括号，括号后面可能跟 0 个或者 1 个数字表示整个括号内的原子出现的次数，比如 (N3Ag)2 表示 N出现 6 次，Ag 出现 2 次
 * 4. 括号可以嵌套
 * @date: 2020/4/18 18:29
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        HashMap<String, Integer> map = process(input, 0, input.length(), new HashMap<>());
        System.out.println("Hello World!");
    }

    public static HashMap<String, Integer> process(String input, int start, int end, HashMap hashMap) {
        Stack<Integer> stack = new Stack<>();
        for (int i = start; i < end; i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                int strStart = stack.pop();
                String subStr = input.substring(strStart + 1, i);
                i++;
                int multiVal = input.charAt(i);
                HashMap<String, Integer> innerMap = count(subStr);
                for (String key : innerMap.keySet()) {
                    int val = innerMap.get(key);
                }
            }
        }
        return hashMap;
    }

    public static HashMap<String, Integer> count(String subStr) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < subStr.length(); i++) {
            int start = 0;
            if (subStr.charAt(i) >= 'A' && subStr.charAt(i) <= 'Z') {
                start = i;
                i++;
                while (subStr.charAt(i) >= 'a' && subStr.charAt(i) <= 'z') {
                    i++;
                }
                int end = i;
                String name = subStr.substring(start, end);
                int val = subStr.charAt(i);
                hashMap.put(name, val);
            }
        }
        return hashMap;
    }
}
