package oj120_139;

import util.CreateLinkLIst;
import util.ListNode;

public class Lint_129_Self {
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        ListNode[] table = new ListNode[hashTable.length * 2];
        //不能使用foreach
        for (int i = 0; i < table.length; i++){
            table[i] = new ListNode(0);
        }
        for (int i = 0; i < hashTable.length; i++){
            while (hashTable[i] != null){
                int index = hashCode(hashTable[i].val, hashTable.length * 2);
                ListNode tail = table[index];
                while (tail.next != null){
                    tail = tail.next;
                }
                tail.next = hashTable[i];
                hashTable[i] = hashTable[i].next;
                //要加null，不然出现环。
                tail.next.next = null;

            }
        }
        for (int i = 0; i < table.length; i++){
            table[i] = table[i].next;
        }
        return table;
    }
    public int hashCode(int key, int capacity){
        return (key % capacity + capacity) % capacity;
    }

    public static void main(String[] args) {
        ListNode[] hashTable = new ListNode[3];
        hashTable[2] = CreateLinkLIst.stringToListNode("[29,5]");
        Lint_129_Self self = new Lint_129_Self();
        self.rehashing(hashTable);
        System.out.println(CreateLinkLIst.listNodeToString(hashTable[2]));
    }
}
