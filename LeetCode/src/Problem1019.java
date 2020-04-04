import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: LeetCode Problem1019: 链表中的下一个更大节点，使用单调递减栈来解决，栈中保存索引值，而不是保存实际值
 * @date: 2020/4/4 16:16
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1019 {
    public static int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        int index = 0;
        while (head != null) {
            res.add(0);
            data.add(head.val);

            while (!stack.isEmpty() && head.val > data.get(stack.peek())) {
                res.set(stack.pop(), head.val);
            }
            stack.push(index);

            index++;
            head = head.next;
        }

        int[] ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 5, 1, 9, 2, 5, 1};
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        int[] result = nextLargerNodes1(dummy.next);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }

    public static int[] nextLargerNodes1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;

        while (head != null) {
            data.add(head.val);
            res.add(0);

            while (!stack.empty() && head.val > data.get(stack.peek())) {
                res.set(stack.pop(), head.val);
            }
            stack.push(index);

            head = head.next;
            index++;
        }

        int[] results = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            results[i] = res.get(i);
        }
        return results;
    }
}
