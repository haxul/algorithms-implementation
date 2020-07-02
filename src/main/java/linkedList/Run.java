package linkedList;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class Run {
    public static void main(String[] args) {
        NodeList nodeList = new NodeList();
        nodeList.insertFirst("hello");
        nodeList.insertFirst("world");
        nodeList.insertFirst("!!!");
        nodeList.displayList(nodeList.getHead());
    }
}
@Data
class NodeList {
    private Node head;

    public NodeList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(String value) {
        Node newNode = new Node(value);
        newNode.setNextNode(head);
        head = newNode;
    }

    public void deleteFirst() {
        if (head == null) return;
        head = head.getNextNode();
    }

    public Node displayList(Node node) {
        if (node.getNextNode() == null) {
            System.out.println("null");
            return null;
        }
        System.out.print(node.getValue() + " ==>  ");
        return displayList(node.getNextNode());
    }
}


@Data
@RequiredArgsConstructor
class Node {
    private final String value;
    private Node nextNode;
}
