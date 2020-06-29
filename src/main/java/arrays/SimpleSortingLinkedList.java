package arrays;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (node.getNextNode() == null) {
            List<Node> nodes = new LinkedList<>();
            nodes.add(0,node);
            return nodes;
        }
        List<Node> sortedList = sorting(node.getNextNode());
        sortedList.add(0,node);
        return sortedList;
    }
}


@AllArgsConstructor
@Data
class Node {
    private String value;
    private Node nextNode;
}
