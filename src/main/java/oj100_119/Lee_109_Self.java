package oj100_119;

import util.ListNode;
import util.TreeNode;

//完全不会
public class Lee_109_Self {
    private ListNode current;
    public int getListLength(ListNode head){
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    private TreeNode sortedListToBSTHelper(int size) {
        if(size <= 0){
            return null;
        }
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        int size = getListLength(head);
        return sortedListToBSTHelper(size);
    }
}
