public class problem23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = MeetingNode(pHead);

        if (meetingNode == null)
            return null;

        ListNode pNode = meetingNode.next;
        int cycCount = 1;
        while (pNode != meetingNode) {
            pNode = pNode.next;
            cycCount++;
        }

        ListNode pNode1 = pHead;
        ListNode pNode2 = pHead;

        for (int i = 0; i < cycCount; i++) {
            pNode1 = pNode1.next;
        }

        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }

    public ListNode MeetingNode(ListNode pHead) {
        if (pHead == null)
            return null;

        ListNode pFast = pHead, pSlow = pHead;

        while (pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;

            if (pFast == pSlow)
                return pFast;
        }

        return null;
    }
}
