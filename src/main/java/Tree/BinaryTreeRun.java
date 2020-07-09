package Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BinaryTreeRun {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10, "root");
        tree.insert( 11, "rightChild");
        tree.insert( 8, "leftChild");
        tree.insert( 7, "leftLeftChild");
        Node node = tree.find(12);
        System.out.println(node);
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Node {
    public Node (int id, String data) {
        this.id = id;
        this.data = data;
    }
    int id;
    String data;
    Node leftChild;
    Node rightChild;
}

@Data
class BinaryTree {
    private Node root;
    public BinaryTree(int id, String data) {
      root = new Node ();
      root.setId(id);
      root.setData(data);
      root.setLeftChild(null);
      root.setRightChild(null);
    }
    public Node find(int key) {
        return internalFind(key, root);
    }
    private  Node internalFind(int key, Node node) {
        if (node.getId() == key) return node;
        if (node.getLeftChild() == null && node.getRightChild() == null) return null;
        if (key > node.getId()) return internalFind(key, node.getRightChild());
        else return internalFind(key, node.getLeftChild());
    }
    public Node insert(int id, String data) {
        return internalInsert(root, id, data);
    }

    private Node internalInsert(Node node, int id, String data) {
        if (node.getId() < id  && node.getRightChild() == null) {
            Node child = new Node(id, data);
            node.setRightChild(child);
            return child;
        }

        if (node.getId() > id && node.getLeftChild() == null) {
            Node child = new Node(id, data);
            node.setLeftChild(child);
            return child;
        }

        if (node.getId() < id ) return internalInsert(node.getRightChild(), id, data);
        else return internalInsert(node.getLeftChild(), id, data);
    }
}