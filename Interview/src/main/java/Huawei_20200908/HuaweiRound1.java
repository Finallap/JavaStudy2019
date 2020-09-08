package Huawei_20200908;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Problem1
 * @date: 2020/9/8 18:45
 * @author: Finallap
 * @version: 1.0
 */
public class HuaweiRound1 {
    public static int cal(String expression) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        expression = expression.trim();
        if (expression.length() == 0) {
            return 0;
        }

        int currentResult = expression.charAt(0) - '0';
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                continue;
            } else if (expression.charAt(i) == '*') {
                char nextNumCh = expression.charAt(++i);
                currentResult = currentResult * (nextNumCh - '0');
            } else if (expression.charAt(i) == '/') {
                char nextNumCh = expression.charAt(++i);
                currentResult = currentResult / (nextNumCh - '0');
            } else if (expression.charAt(i) == '+') {
                numbers.add(currentResult);
                currentResult = expression.charAt(++i) - '0';
                ops.add('+');
            } else if (expression.charAt(i) == '-') {
                numbers.add(currentResult);
                currentResult = expression.charAt(++i) - '0';
                ops.add('-');
            }
        }
        numbers.add(expression.charAt(expression.length() - 1) - '0');

        int result = numbers.get(0);
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            if (op == '+') {
                result += numbers.get(i + 1);
            } else if (op == '-') {
                result -= numbers.get(i + 1);
            }
        }
        return result;
    }
}
