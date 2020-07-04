package linkedList;

import lombok.Data;

public class SortedLinkedListRun {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.insert(9);
        list.insert(10);
        list.insert(11);
    }
}

interface Sortable {
    void insert(int element);

    int getSmall();
}

class SortedLinkedList implements Sortable {
    public SortedLinkedList() {
        head = null;
    }

    private Link head;

    @Override
    public void insert(int element) {
        Link current = head;
        Link previous = null;
        while (current != null && element > current.value) {
            previous = current;
            current = current.next;
        }
        Link link = new Link();
        link.value = element;
        if (previous == null) head = link;
        else previous.next = link;
        link.next = current;
     }


    @Override
    public int getSmall() {
        int returnValue = head.value;
        head = head.next;
        return returnValue;
    }
}

@Data
class Link {
    public int value;
    public Link next;
}
