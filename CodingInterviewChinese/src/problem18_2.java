//删除链表中重复的结点
public class problem18_2 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (pHead.val == next.val && next != null)
                next = next.next;
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
