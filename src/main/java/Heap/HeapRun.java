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
    public Node(int key) {
        this.key = key;
    }

    private int key;
    private String value;
}


class Heap {
    private Node heapArray[] = new Node[30];
    int currentSize = 0;
    int maxSize = heapArray.length;

    public boolean insert(int key) {
        if (currentSize == maxSize)
            return false;
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 &&
                heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize && heapArray[leftChild].getKey() <
                    heapArray[rightChild].getKey())
                largerChild = rightChild;
            else largerChild = leftChild;
            if (top.getKey() >= heapArray[largerChild].getKey())
                break;
            heapArray[index] = heapArray[largerChild];
            index = largerChild;

        }
        heapArray[index] = top;
    }
}