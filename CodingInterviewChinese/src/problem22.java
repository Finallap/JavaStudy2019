public class problem22 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;

        ListNode curr1 = head;
        ListNode curr2 = head;
        int index = 0;

        while (curr1 != null) {
            if (index >= k)
                curr2 = curr2.next;
            index++;
            curr1 = curr1.next;
        }

        if (index < k)
            return null;
        else
            return curr2;
    }
}
