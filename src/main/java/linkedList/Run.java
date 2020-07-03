package linkedList;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class Run {
    public static void main(String[] args) {
        NodeList nodeList = new NodeList();
        nodeList.insertFirst("hello");
        nodeList.insertFirst("world");
        nodeList.insertFirst("!!!");
        nodeList.delete("world");
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

    public Node find(String key) {
        Node current = head;
        while (!current.getValue().equals(key)) {
            if (current.getValue() == null) return null;
            current = current.getNextNode();
        }
        return current;
    }

    public Node findRecursion(String key) {
        return loop(key, head);
    }

    private Node loop(String key, Node node) {
        if (node.getValue().equals(key)) return node;
        else if (node.getNextNode() == null) return null;
        else return loop(key, node.getNextNode());
    }

    public Node delete(String key) {
        return internalDelete(key, head, null);
    }

    private Node internalDelete(String key, Node node, Node previous) {
        if (node == null) return null;
        if (node.getValue().equals(key) && node == head) {
            deleteFirst();
            return head;
        }
        if (node.getValue().equals(key)) {
            previous.setNextNode(node.getNextNode());
            return node;
        } else return internalDelete(key, node.getNextNode(), node);
    }

}


@Data
@RequiredArgsConstructor
class Node {
    private final String value;
    private Node nextNode;
}
