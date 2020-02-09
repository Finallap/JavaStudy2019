public class problem21 {
    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //迭代法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode curr = root;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null)
            curr.next = l2;

        if (l2 == null)
            curr.next = l1;

        return root.next;
    }

    //递归法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
