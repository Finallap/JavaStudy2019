public class problem2_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode currentNode = root;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int l1_val = l1 != null ? l1.val : 0;
            int l2_val = l2 != null ? l2.val : 0;
            int result = l1_val + l2_val + carry;
            carry = result / 10;

            ListNode node = new ListNode(result % 10);
            currentNode.next = node;
            currentNode = node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }
}

