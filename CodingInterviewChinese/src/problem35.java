import java.util.HashMap;

/**
 * @description: 复杂链表的复制
 * @date: 2020/2/29 12:01
 * @author: Finallap
 * @version: 1.0
 */

public class problem35 {
    //方法一：先复制一遍链表，然后再从头连接random指针
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        //利用HashMap实现原先的Node和复制的Node相对应的作用，方便后面直接查找出需要连接的random的地址
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();

        //复制一遍链表
        RandomListNode pNode = pHead;
        RandomListNode cloneHead = new RandomListNode(pHead.label);
        RandomListNode cloneNode = cloneHead;
        hashMap.put(pNode, cloneNode);
        pNode = pNode.next;
        while (pNode != null) {
            cloneNode.next = new RandomListNode(pNode.label);
            hashMap.put(pNode, cloneNode.next);
            cloneNode = cloneNode.next;
            pNode = pNode.next;
        }

        //从头遍历链表，查找并连接random指针
        pNode = pHead;
        cloneNode = cloneHead;
        while (pNode != null) {
            if (pNode.random != null) {
                cloneNode.random = hashMap.get(pNode.random);
            }
            cloneNode = cloneNode.next;
            pNode = pNode.next;
        }

        return cloneHead;
    }

    //方法二：在原来链表的每个Node后面都复制一个Node出来，然后连接Node，最后拆分
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // 插入新节点
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode originalNext = pNode.next;
            pNode.next = new RandomListNode(pNode.label);
            pNode.next.next = originalNext;
            pNode = pNode.next.next;
        }

        // 建立 random 链接
        pNode = pHead;
        while (pNode != null) {
            if (pNode.random != null) {
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }

        // 拆分
        pNode = pHead;
        RandomListNode cloneHead = pNode.next;
        while (pNode.next != null) {
            RandomListNode originalNext = pNode.next;
            pNode.next = originalNext.next;
            pNode = originalNext;
        }
        return cloneHead;
    }
}