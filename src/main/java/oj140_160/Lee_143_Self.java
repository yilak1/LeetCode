package oj140_160;

import util.CreateLinkLIst;
import util.ListNode;

public class Lee_143_Self {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode dummy = new ListNode(0);
        //快慢指针找中点，对中电后进行反转；
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        fast = slow.next;
        //slow.next要变成null不然还是和下一个连着而出错
        slow.next = null;
        while (fast != null){
            ListNode temp = fast.next;
            fast.next = pre;
            pre = fast;
            fast = temp;
        }
        ListNode tail = dummy;
        // 原来链表head和反转链表pre一同加入到新的链表中一同加入到dummy中
        while (head != null && pre != null){
            tail.next = head;
            tail = tail.next;
            head = head.next;
            tail.next = pre;
            tail = tail.next;
            pre = pre.next;
        }
        if (head != null){
            tail.next = head;
        }

        head = dummy.next;
    }

    public static void main(String[] args) {
        String input = "[1,2,3,4,5]";
        ListNode head = CreateLinkLIst.stringToListNode(input);
        Lee_143_Self self = new Lee_143_Self();
        self.reorderList(head);
        System.out.println(CreateLinkLIst.listNodeToString(head));
    }
}
