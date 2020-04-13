package Jianzhi;

import java.util.Stack;

/**
 * @description: 剑指 Problem31: 栈的压入、弹出序列，栈压入并弹出，最后判断栈是否为空
 * @date: 2020/4/13 20:31
 * @author: Finallap
 * @version: 1.0
 */
public class Problem31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && poppedIndex < popped.length && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }
        return stack.isEmpty();
    }
}
