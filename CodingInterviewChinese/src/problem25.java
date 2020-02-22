public class problem25 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null)
            curr.next = list1;

        if (list2 != null)
            curr.next = list2;

        return dummyNode.next;
    }

    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        if (list1.val <= list2.val) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }
}
