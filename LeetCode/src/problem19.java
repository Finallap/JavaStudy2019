/**
 * @description: LeetCode problem19: 删除链表的倒数第N个节点，使用双指针+哑结点（为了保证只有一个节点的情况）
 * @date: 2020/4/11 11:22
 * @author: Finallap
 * @version: 1.0
 */
public class problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
            if (fast == null)
                return dummy.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
