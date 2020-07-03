package linkedList;

import java.util.LinkedList;
import java.util.List;

public class StakeBasedByLinkedList {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("hello");
        stack.push("world");
        stack.push("!!!");
        stack.pop();
        stack.pop();
    }
}

interface Stackable {
    void push(String element);
    String pop();
    boolean isEmpty();
}

class MyStack implements Stackable{

    private LinkedList<String> storage = new LinkedList<>();

    @Override
    public void push(String element) {
        storage.add(element);
    }

    @Override
    public String pop() {
        if (storage.isEmpty()) throw new RuntimeException();
        String s = storage.getLast();
        storage.removeLast();
        return s;
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }
}
