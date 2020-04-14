import java.util.Stack;

/**
 * @description: LeetCode Problem445:两数相加 II
 * @date: 2020/4/14 14:57
 * @author: Finallap
 * @version: 1.0
 */
public class Problem445 {
    //使用栈解决，后面的数字先出
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode curr = null;
        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            sum += !stack1.empty() ? stack1.pop() : 0;
            sum += !stack2.empty() ? stack2.pop() : 0;
            ListNode node = new ListNode(sum % 10);
            node.next = curr;
            curr = node;
            carry = sum / 10;
        }

        return curr;
    }

    //转换成数字，相加后再取出，会溢出
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long num1 = 0, num2 = 0;
        while (l1 != null) {
            num1 = num1 * 10 + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 = num2 * 10 + l2.val;
            l2 = l2.next;
        }
        long sum = num1 + num2;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        String strSum = Long.toString(sum);
        char[] chars = strSum.toCharArray();
        for (char ch : chars) {
            int val = ch - '0';
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummyNode.next;
    }
}
