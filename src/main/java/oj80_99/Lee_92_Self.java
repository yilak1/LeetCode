package oj80_99;

import util.ListNode;

public class Lee_92_Self {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next ==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++){
            head = head.next;
        }
        ListNode pre = null;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        for (int j = m; j < n; j++){
            ListNode temp = nNode.next;
            nNode.next = pre;
            pre = nNode;
            nNode = temp;
        }
        ListNode postNNode = nNode.next;
        nNode.next = pre;
        mNode.next = postNNode;
        head.next = nNode;
        return dummy.next;
    }
}
