import java.util.Stack;

//判断是不是栈的压入、弹出序列
public class problem31 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();

        while (pushIndex < pushA.length) {
            stack.push(pushA[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
            pushIndex++;
        }

        return stack.isEmpty();
    }
}
