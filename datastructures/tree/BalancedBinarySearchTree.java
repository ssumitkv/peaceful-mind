package datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class BalancedBinarySearchTree {

    public void storeIntoArrayInroder(Node root, List<Integer> sortedNodes) {
        if(root == null) {
            return ;
        }

        storeIntoArrayInroder(root.left, sortedNodes);
        sortedNodes.add(root.value);
        storeIntoArrayInroder(root.right, sortedNodes);
    }

    public Node rebuildBinarySearchTree(List<Integer> sortedNodes, int start, int end) {

        if(start > end) {
            return null;
        }



        int mid = (end+start) / 2; // this is the root node
        Node root = new Node(sortedNodes.get(mid));

        root.left = rebuildBinarySearchTree(sortedNodes, start, mid-1);
        root.right = rebuildBinarySearchTree(sortedNodes, mid+1, end);
        
        return root;
    }

    public Node balanceBinarySearchTree(Node root) {
        List<Integer> nodeList = new ArrayList<>();

        storeIntoArrayInroder(root, nodeList);
        
        return rebuildBinarySearchTree(nodeList, 0, nodeList.size()-1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(root, new Node(5));
        bst.add(root, new Node(2));
        bst.add(root, new Node(1));
        bst.add(root, new Node(15));
        bst.add(root, new Node(20));
        

        System.err.println("Start");
        System.err.print("Inorder: ");
        bst.inorderTriversal(root);

        System.err.println("END");

        System.err.print("Post Order: ");
        bst.postOrderTraversal(root);

        System.err.println("END");

        System.err.print("Pre Order: ");
        bst.preOrderTraversal(root);

        System.err.println("END");

        BalancedBinarySearchTree bbst = new BalancedBinarySearchTree();
        bbst.balanceBinarySearchTree(root);

        System.err.println("Start");
        System.err.print("Inorder: ");
        bst.inorderTriversal(root);

        System.err.println("END");
    }
    
}
