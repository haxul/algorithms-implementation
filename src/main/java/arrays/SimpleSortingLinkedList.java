package arrays;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleSortingLinkedList {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        Node four = new Node("four", null);
        Node three = new Node("three", four);
        Node two = new Node("two", three);
        Node one = new Node("one", two);
        Node head = new Node(null, one);
        nodes.add(three);
        nodes.add(head);
        nodes.add(two);
        nodes.add(one);
        nodes.add(four);
        List<Node> sorting = sorting(head);
        System.out.println(sorting);
    }
    public static List<Node> sorting(Node node) {
        final int HEAD = 0;
        if (node.getNextNode() == null) {
            List<Node> nodes = new LinkedList<>();
            nodes.add(HEAD,node);
            return nodes;
        }
        List<Node> sortedList = sorting(node.getNextNode());
        sortedList.add(HEAD,node);
        return sortedList;
    }
}


@AllArgsConstructor
@Data
class Node {
    private String value;
    private Node nextNode;
}
