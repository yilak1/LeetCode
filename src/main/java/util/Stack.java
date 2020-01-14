package util;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> list = new LinkedList();
    public void push(T t){
        list.addFirst(t);
    }
    public T peek(){
        return list.getFirst();
    }
    public T pop(){
        return list.removeFirst();
    }
    public boolean empty(){
        return list.isEmpty();
    }
    public int size(){
        return list.size();
    }
    public String toString(){
        return list.toString();
    }

}
