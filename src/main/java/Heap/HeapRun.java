package Heap;

import lombok.AllArgsConstructor;
import lombok.Data;

public class HeapRun {
    public static void main(String[] args) {

    }
}

@Data
@AllArgsConstructor
class Node {
    private int id;
    private String value;
}


class Heap {
    private Node heapArray[];

    public void insert(Node nd) {
    }

    public Node remove() {
        return null;
    }
}

class priorityQueue {
    private Heap theHeap;

    public void insert(Node nd) {
        theHeap.insert(nd);
    }

    public Node remove() {
        return theHeap.remove();
    }
}
