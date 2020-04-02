/**
 * @description: LeetCode problem147: 对链表进行插入排序
 * @date: 2020/4/2 12:01
 * @author: Finallap
 * @version: 1.0
 */
public class problem147 {
    public ListNode insertionSortList(ListNode head) {
        //创建一个最小值作为头结点
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        //pre用来确定插入位置的前驱
        ListNode pre = dummy;
        //end用来确定已排序部分的最后一个节点
        ListNode end = dummy;
        //curr表示目前遍历到的节点
        ListNode curr = head;
        while (curr != null) {
            //如果当前节点的值比最后一个节点的值大，则说明是有序的，遍历下一个
            if (end.val < curr.val) {
                end.next = curr;
                end = curr;
                curr = curr.next;
            } else {
                //定义一个temp，指向下一个节点，防丢
                ListNode temp = curr.next;
                //将尾部接到原本的end节点后，断开要插入的节点
                end.next = temp;
                //找出合适的插入位置
                while (pre.next != null && pre.next.val < curr.val)
                    pre = pre.next;
                //将元素插入进来
                curr.next = pre.next;
                pre.next = curr;
                //插入结束，将定位指针归位
                pre = dummy;
                curr = temp;
            }
        }
        return dummy.next;
    }
}
