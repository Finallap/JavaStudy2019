//在 O(1) 时间内删除链表节点
public class problem18_1 {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;

        if (tobeDelete.next != null) {
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else if (head == tobeDelete)
            head = null;
        else {
            ListNode curr = head;
            while (curr.next != tobeDelete)
                curr = curr.next;
            curr.next = null;
        }
        return head;
    }
}
