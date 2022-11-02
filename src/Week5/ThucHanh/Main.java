package Week5.ThucHanh;

import javax.swing.*;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        ArrayBinaryTree<String, Integer> arrayBT = new ArrayBinaryTree<>();
        arrayBT.setRoot("A");

        arrayBT.setRight(1, "C");
        arrayBT.setLeft(1, "D");
        arrayBT.setRight(2, "E");
        arrayBT.setLeft(2, "F");
        arrayBT.printTree();

        out.println("Is the tree is empty ? " + arrayBT.isEmpty());
        out.println("Num of child at node 1: " + arrayBT.numChildren(1));
        out.println("Size of the tree: " + arrayBT.size());
        out.println("The left child of node 1: " + arrayBT.getVal(arrayBT.left(1)));
        out.println("The right child of node 3" + arrayBT.getVal(arrayBT.right(3)));
        out.println("The root of the tree: " + arrayBT.root());
        out.println("The sibling of node 3:" + arrayBT.getVal(arrayBT.sibling(3)));
        arrayBT.setRoot("W");
        arrayBT.printTree();

        out.println("----------------------");

        LinkedBinaryTree<String, Integer> linkedBT = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<String> root = linkedBT.addRoot("A");

        linkedBT.addRight(root, "C");
        linkedBT.addLeft(root, "D");

        LinkedBinaryTree.Node<String> leaf1 = root.getLeft();
        linkedBT.addRight(leaf1, "E");
        linkedBT.addLeft(leaf1, "F");
        LinkedBinaryTree.printBinaryTree(root);

        out.println("Is the tree is empty ? " + linkedBT.isEmpty());
        out.println("Num of child at node 1: " + linkedBT.numChildren(0));
        out.println("Size of the tree: " + linkedBT.size());
        out.println("The left child of node 1: " + linkedBT.left(1));
        out.println("The right child of node 1: " + linkedBT.right(1));
        out.println("The right child of node 2: " + linkedBT.right(2));
        out.println("The root of the tree: " + linkedBT.root());
        out.println("The sibling of node 2: " + linkedBT.sibling(2));
        linkedBT.setRoot("W");
        LinkedBinaryTree.printBinaryTree(root);

    }
}
