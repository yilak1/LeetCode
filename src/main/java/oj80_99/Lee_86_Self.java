package oj80_99;

import util.ListNode;

public class Lee_86_Self {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummyLow = new ListNode(0);
        ListNode preLow = dummyLow;
        ListNode dummyHigh = new ListNode(0);
        ListNode preHigh = dummyHigh;
        ListNode post = head;
        while (post != null){
            if (post.val < x){
                preLow.next = post;
                preLow = preLow.next;
            }else {
                preHigh.next = post;
                preHigh = preHigh.next;
            }
            post = post.next;
            head.next = null;
            head = post;
        }
        preLow.next = dummyHigh.next;
        return dummyLow.next;
    }
}
