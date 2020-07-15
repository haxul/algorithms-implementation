package Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BinaryTreeRun {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10, "root");
        tree.insert(12, "leftLeftChild");
        tree.insert(11, "rightChild");
        tree.insert(8, "leftChild");
        tree.insert(9, "leftChild");
        tree.insert(7, "leftLeftChild");
//        tree.insert(14, "leftLeftChild");
        tree.symRound(tree.getRoot());
        tree.delete(12, null, tree.getRoot());
        System.out.println(tree);
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class NodeB {
    public NodeB(int id, String data) {
        this.id = id;
        this.data = data;
    }

    int id;
    String data;
    NodeB leftChild;
    NodeB rightChild;
}

@Data
class BinaryTree {
    private NodeB root;
    public int min;
    public int max;

    public BinaryTree(int id, String data) {
        root = new NodeB();
        root.setId(id);
        root.setData(data);
        root.setLeftChild(null);
        root.setRightChild(null);
        min = root.getId();
        max = root.getId();
    }

    public void delete(int id, NodeB parent, NodeB nodeB) {
        if (nodeB.getRightChild() == null && nodeB.getLeftChild() == null && nodeB.getId() == id) {
            if (parent.getLeftChild() == nodeB) parent.setLeftChild(null);
            if (parent.getRightChild() == nodeB) parent.setRightChild(null);
        } else if (nodeB.getLeftChild() != null && nodeB.getRightChild() == null && nodeB.getId() == id) {
            if (parent.getRightChild() == nodeB) parent.setRightChild(nodeB.getLeftChild());
            if (parent.getLeftChild() == nodeB) parent.setLeftChild(nodeB.getLeftChild());
        } else if (nodeB.getLeftChild() == null && nodeB.getRightChild() != null && nodeB.getId() == id) {
            if (parent.getRightChild() == nodeB) parent.setRightChild(nodeB.getRightChild());
            if (parent.getLeftChild() == nodeB) parent.setLeftChild(nodeB.getRightChild());
        } else {
            if (nodeB.getRightChild() != null) delete(id, nodeB, nodeB.getRightChild());
            if (nodeB.getLeftChild() != null) delete(id, nodeB, nodeB.getLeftChild());
        }
    }

    private NodeB getSuccessor(NodeB delNodeB) {
        NodeB successorParent = delNodeB;
        NodeB successor = delNodeB;
        NodeB current = delNodeB.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNodeB.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNodeB.rightChild;
        }
        return successor;
    }

    public NodeB find(int key) {
        return internalFind(key, root);
    }

    private NodeB internalFind(int key, NodeB nodeB) {
        if (nodeB.getId() == key) return nodeB;
        if (nodeB.getLeftChild() == null && nodeB.getRightChild() == null) return null;
        if (key > nodeB.getId()) return internalFind(key, nodeB.getRightChild());
        else return internalFind(key, nodeB.getLeftChild());
    }

    public NodeB insert(int id, String data) {
        return internalInsert(root, id, data);
    }

    private NodeB internalInsert(NodeB nodeB, int id, String data) {
        if (nodeB.getId() < id && nodeB.getRightChild() == null) {
            NodeB child = new NodeB(id, data);
            nodeB.setRightChild(child);
            return child;
        }

        if (nodeB.getId() > id && nodeB.getLeftChild() == null) {
            NodeB child = new NodeB(id, data);
            nodeB.setLeftChild(child);
            return child;
        }

        if (nodeB.getId() < id) return internalInsert(nodeB.getRightChild(), id, data);
        else return internalInsert(nodeB.getLeftChild(), id, data);
    }

    public void symRound(NodeB nodeB) {
        if (nodeB != null) {
            if (nodeB.getId() < min) min = nodeB.getId();
            if (nodeB.getId() > max) max = nodeB.getId();
            symRound(nodeB.getLeftChild());
            symRound(nodeB.getRightChild());
        }
    }
}