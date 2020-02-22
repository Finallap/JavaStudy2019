public class problem24 {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
