public class problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while (l1!=null||l2!=null||carry!=0){
            int l1val = l1!=null?l1.val:0;
            int l2val = l2!=null?l2.val:0;
            int subVal = l1val+l2val+carry;
            carry = subVal / 10;

            ListNode sumNode = new ListNode(subVal%10);
            current.next = sumNode;
            current = sumNode;

            if (l1!=null)l1=l1.next;
            if (l2!=null)l2=l2.next;
        }

        return dummyHead.next;
    }
}
