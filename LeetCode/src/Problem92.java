/**
 * @description: LeetCode Problem92: 反转链表 II，反转部分链表，使用迭代和递归都可
 * @date: 2020/4/24 20:22
 * @author: Finallap
 * @version: 1.0
 */
public class Problem92 {
    //迭代法
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode curr = head;
        while (m > 1) {
            pre = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode entrance = pre;
        ListNode exit = curr;

        while (n > 0) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            n--;
        }

        if (entrance != null)
            entrance.next = pre;
        else
            head = pre;
        exit.next = curr;

        return head;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int n = 5;
        for (int i = 1; i <= n; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        reverseBetween(dummy.next, 2, 4);
    }

    //递归法
    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        while (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    //记录后驱节点
    static ListNode successor = null;

    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            //记录下一个节点
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
