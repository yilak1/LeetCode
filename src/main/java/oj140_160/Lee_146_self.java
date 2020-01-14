package oj140_160;

import java.util.HashMap;

public class Lee_146_self {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(){}
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public Lee_146_self(int capacity) {
        this.capacity = capacity;
        this.tail.prev = head;
        this.head.next = tail;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        //1. 将该key移动到队列尾部
        moveToTail(key);
        //2.通过hashMap获得value返回
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (get(key) != -1){
            map.get(key).value = value;
            return;
        }
        if (map.size() == this.capacity && map.size() > 0){
            map.remove(head.next.key);
            head.next.next.prev = head;
            head.next = head.next.next;

        }

        Node node = new Node(key, value);
        map.put(key, node);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public void moveToTail(int key){
        Node keyNode = head;
        while (keyNode.key != key){
            keyNode = keyNode.next;
        }
        //将节点移动到队列的队尾
        keyNode.prev.next = keyNode.next;
        keyNode.next.prev = keyNode.prev;
        keyNode.prev = tail.prev;
        tail.prev.next = keyNode;
        keyNode.next = tail;
        tail.prev = keyNode;
    }

    public static void main(String[] args) {
        Lee_146_self self = new Lee_146_self(2);
        self.put(1, 1);
        self.put(2, 2);
        System.out.println(self.get(1));
        self.put(3, 3);
        System.out.println(self.get(2));
        self.put(4, 4);
        System.out.println(self.get(1));

    }
}
