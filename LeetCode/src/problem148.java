public class problem148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

//        快慢指针
        ListNode fast = head;
        ListNode slow = head;
        ListNode breakN = null;
        while (fast != null && fast.next != null) {
            breakN = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        breakN.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return listMerge(left, right);
    }

    public ListNode listMerge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                ListNode node = new ListNode(left.val);
                curr.next = node;
                curr = curr.next;
                left = left.next;
            } else {
                ListNode node = new ListNode(right.val);
                curr.next = node;
                curr = curr.next;
                right = right.next;
            }
        }

        while (left != null) {
            ListNode node = new ListNode(left.val);
            curr.next = node;
            curr = curr.next;
            left = left.next;
        }

        while (right != null) {
            ListNode node = new ListNode(right.val);
            curr.next = node;
            curr = curr.next;
            right = right.next;
        }

        return dummyHead.next;
    }
}
