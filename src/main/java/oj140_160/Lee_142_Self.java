package oj140_160;

import util.ListNode;

public class Lee_142_Self {
    public ListNode detectCycle(ListNode head) {
        //没有环返回null
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        boolean flag =false;
        while (fast != null && fast.next !=null){
            if (slow == fast){
                flag = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (flag){
            slow = head;
            //slow 和fast.next相等则有环且slow是入口
            while (slow != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
