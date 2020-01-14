package oj1_20;

import util.ListNode;

public class Lee_2_Self {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int car = 0; // 进位
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val+ car;
            l1 = l1.next;
            l2 = l2.next;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (sum >= 10){
                car = 1;
            }else {
                car = 0;
            }
        }
        while (l2 != null){
            int sum = l2.val + car;
            tail.next = new ListNode(sum % 10);
            l2 = l2.next;
            tail = tail.next;
            if (sum >= 10){
                car = 1;
            }else {
                car = 0;
            }
        }
        while (l1 != null){
            int sum = l1.val + car;
            tail.next = new ListNode(sum % 10);
            l1 = l1.next;
            tail = tail.next;
            if (sum >= 10){
                car = 1;
            }else {
                car = 0;
            }
        }
        if (car != 0){
            tail.next = new ListNode(1);
        }
        return dummy.next;
    }
}
