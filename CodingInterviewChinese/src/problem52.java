/**
 * @description: 剑指 problem52 : 两个链表的第一个公共节点，先计算链表的长度差，长的先走一部分，然后两个一起走，找到公共部分
 * @date: 2020/3/17 11:12
 * @author: Finallap
 * @version: 1.0
 */
public class problem52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0;
        ListNode curr1 = pHead1, curr2 = pHead2;
        while (curr1 != null) {
            len1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            len2++;
            curr2 = curr2.next;
        }
        int lenGap = len1 - len2;
        curr1 = pHead1;
        curr2 = pHead2;
        if (lenGap >= 0) {
            while (lenGap > 0) {
                curr1 = curr1.next;
                lenGap--;
            }
        } else {
            while (lenGap < 0) {
                curr2 = curr2.next;
                lenGap++;
            }
        }
        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }
}
