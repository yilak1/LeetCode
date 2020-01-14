package oj21_39;

import util.ListNode;

public class Lee_21_Self {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        while (l1 != null){
            head.next = l1;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null){
            head.next = l2;
            head = head.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}