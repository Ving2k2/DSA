package Week5.ThucHanh;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> arrayBT = new ArrayBinaryTree<>();
        arrayBT.setRoot(7);
        int root = arrayBT.getRoot();

        arrayBT.setLeft(1, 3);
        arrayBT.setRight(2, 2);
        arrayBT.setLeft(5, 1);
        arrayBT.setRight(10, 6);
        arrayBT.setLeft(21, 5);
        arrayBT.setRight(42, 8);
        arrayBT.printArrayTree(root);

        out.println("Is the tree is empty ? " + arrayBT.isEmpty());
        out.println("Num of child at node 1: " + arrayBT.numChildren(2));
        out.println("Size of the tree: " + arrayBT.size());
        out.println("The left child of node 1: " + arrayBT.getVal(arrayBT.left(2)));
        out.println("The right child of node 1: " + arrayBT.getVal(arrayBT.right(2)));
        out.println("The right child of node 9: " + arrayBT.getVal(arrayBT.right(10)));
        out.println("The root of the tree: " + arrayBT.root());
        out.println("The sibling of node 10 :" + arrayBT.getVal(arrayBT.sibling(11)));

        out.println("----------------------");

        LinkedBinaryTree<Integer, Integer> linkedBT = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer>  rootOfLinkedTree = linkedBT.addRoot(7);

        linkedBT.addLeft(rootOfLinkedTree, 3);
        ;
        linkedBT.addRight(rootOfLinkedTree.getLeft(), 2);
        linkedBT.addLeft(rootOfLinkedTree.getLeft().getRight(), 1);
        linkedBT.addRight(rootOfLinkedTree.getLeft().getRight().getLeft(), 6);
        linkedBT.addLeft(rootOfLinkedTree.getLeft().getRight().getLeft().getRight(), 5);
        linkedBT.addRight(rootOfLinkedTree.getLeft().getRight().getLeft().getRight().getLeft(), 8);
        LinkedBinaryTree.printBinaryTree(rootOfLinkedTree);

        out.println("Is the tree is empty ? " + linkedBT.isEmpty());
        out.println("Num of child at node 1: " + linkedBT.numChildren(1));
        out.println("Size of the tree: " + linkedBT.size());
        out.println("The left child of node 1: " + linkedBT.left(1));
        out.println("The right child of node 1: " + linkedBT.right(1));
        out.println("The right child of node 9: " + linkedBT.right(9));
        out.println("The root of the tree: " + linkedBT.root());
        out.println("The sibling of node 10: " + linkedBT.sibling(10));

    }
}
