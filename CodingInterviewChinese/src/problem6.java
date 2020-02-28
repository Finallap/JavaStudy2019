import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//problem6：链表，从尾到头打印链表
public class problem6 {
    //    使用栈方法
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.empty()) {
            result.add(stack.pop());
        }

        return result;
    }

    //    使用递归方法
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            result.addAll(printListFromTailToHead1(listNode.next));
            result.add(listNode.val);
        }
        return result;
    }

    //使用Collections的reverse函数反转
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }

        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ListNode ln8 = new ListNode(8);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;
        //ListNode ln1 = new ListNode();
        //ln1=null;
        System.out.println(printListFromTailToHead2(ln1));
//        printListReverseinglyByRecursion(ln1);

    }
}
