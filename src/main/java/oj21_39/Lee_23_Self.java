package oj21_39;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Lee_23_Self {

    PriorityQueue<ListNode> minHeap= new PriorityQueue<ListNode>(new Comparator<ListNode>() {
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val == o2.val){
                return 0;
            }else if (o1.val < o2.val){
                return -1;
            }else {
                return 1;
            }
        }
    });

    public boolean initHeap(ListNode[] lists){
        if (lists.length == 0){
            return false;
        }
        for (int i = 0; i < lists.length; i++){
            if (lists[i] != null){
                minHeap.add(lists[i]);
            }
        }
        if (minHeap.size() == 0){
            return false;
        }else {
            return true;
        }
    }
    public ListNode minListNode(){
        if (minHeap.size() == 0){
            return null;
        }
        ListNode node = minHeap.poll();
        if (node.next != null){
            minHeap.add(node.next);
        }
        return node;
    };
    public ListNode mergeKLists(ListNode[] lists) {
        boolean flag = initHeap(lists);
        if (!flag){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode min = minListNode();
        while (min != null){
            tail.next = min;
            tail = tail.next;
            min = minListNode();
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
