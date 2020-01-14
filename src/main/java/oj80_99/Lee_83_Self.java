package oj80_99;

import util.ListNode;

public class Lee_83_Self {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next ==null){
            return null;
        }
        ListNode node = head;
        while (node.next != null){
            if (node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }
}
