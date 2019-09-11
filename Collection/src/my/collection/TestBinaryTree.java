package my.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class TestBinaryTree {
    public static void main(String[] args){
        BinaryTree<String> tree = new BinaryTree<>();

        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        System.out.println("InOrder:");
        tree.inorder();
        System.out.println();
        System.out.println("PreOrder:");
        tree.preorder();
        System.out.println();
        System.out.println("PostOrder:");
        tree.postorder();
        System.out.println();

        System.out.println("Peter in tree?" + tree.search("Peter"));
        ArrayList<TreeNode<String>> path = tree.path("Peter");
        for (TreeNode<String> node: path) {
            System.out.print(node.element+" ");
        }
        System.out.println();

        tree.delete("Tom");
        System.out.println("InOrder:");
        tree.inorder();
        System.out.println();

        Iterator iterator = tree.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next()+" ");
    }
}
