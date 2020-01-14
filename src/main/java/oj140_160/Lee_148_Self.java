package oj140_160;

import util.CreateLinkLIst;
import util.ListNode;

import java.util.Arrays;

/**
 * 归并排序链表
 */
public class Lee_148_Self {
    //快慢指针实现
    public ListNode middleList(ListNode head){
        if (head == null|| head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //fast指针比较远，所以用它判断空就好不用slow判断null
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null){
            if (left.val <= right.val){
                head.next = left;
                left = left.next;
            }else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        //如果不为null把剩下的链表直接连在head.next就好，不用再循环
        if (left != null){
            head.next = left;
        }
        if (right != null){
            head.next = right;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode middleNode = middleList(head);
        ListNode right = sortList(middleNode.next);
        //关键要变成null这样才能分开链表，分治。
        middleNode.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    public static void main(String[] args) {
        String input = "[4,2,1,3]";
        ListNode head = CreateLinkLIst.stringToListNode(input) ;
        Lee_148_Self self = new Lee_148_Self();
        ListNode list = self.sortList(head);
        System.out.println(CreateLinkLIst.listNodeToString(list));
    }
}
