package oj120_139;

import util.ListNode;
import util.Node;

public class Lee_138_Self {
    public void copyNext(Node head){
        while (head != null){
            Node newNode = new Node();
            newNode.val = head.val;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }

    }

    public void copyRandom(Node head){
        while (head != null){
            if (head.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    public Node splitList(Node head){
        Node dummy = new Node();
        Node tail = dummy;
        while (head != null && head.next != null){
            Node temp = head.next.next;
            tail.next = head.next;
            head = temp;
            tail = tail.next;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);

    }
}
