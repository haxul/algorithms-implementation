package linkedList;

import lombok.Data;

public class DoubleLinkedListRun {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertFirst("hello");
        list.insertFirst("world");
        list.insertFirst("twice");
        list.insertLast("finish");
        list.insertAfter("twice", "!!!!!!!!");
        list.showList();
    }
}

@Data
class Bind {
    private Bind next;
    private Bind prev;
    private String value;
}

interface Linkable {
    void insertFirst(String elem);
    void insertLast(String elem);
    void insertAfter(String bind, String value);
}

class DoubleLinkedList implements  Linkable{
    public DoubleLinkedList() {
        head = null;
    }
    private Bind head;

    public boolean isEmpty() {
        return head == null;
    }
    @Override
    public void insertFirst(String elem) {
        Bind bind = new Bind();
        bind.setPrev(null);
        bind.setNext(head);
        bind.setValue(elem);
        if (head != null)  head.setPrev(bind);
        head = bind;
    }

    public Bind showList() {
        return display(head);
    }

    private Bind display(Bind bind) {
        if (bind == null) {
            System.out.print( " null ");
            return null;
        } else {
            System.out.print(bind.getValue() + " ===> ");
            return display(bind.getNext());
        }
    }
    @Override
    public void insertLast(String elem) {
        Bind current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        Bind bind = new Bind();
        bind.setValue(elem);
        current.setNext(bind);
        bind.setPrev(current);
        bind.setNext(null);
    }

    @Override
    public void insertAfter(String afterValue, String value) {
        Bind current = head;
        while (!current.getValue().equals(afterValue)) {
            if (current == null) return;
            current = current.getNext();
        }
        Bind after = current;
        Bind bind = new Bind();
        bind.setValue(value);
        Bind before = current.getNext();
        after.setNext(bind);
        before.setPrev(bind);
        bind.setPrev(after);
        bind.setNext(before);
    }
}