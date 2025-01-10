package datastructures.tree;



public class BinarySearchTree {


    public Node add(Node treeNode, Node node) {
        if(treeNode == null) {
            treeNode = node;
            return treeNode;
        }

        if(treeNode.value == node.value) {
            // value already present.
            return treeNode;
        }
        if(treeNode.value > node.value) {
            treeNode.left = add( treeNode.left, node);
        }
        else{
            treeNode.right = add(treeNode.right, node);
        }
        return treeNode;
    }

    public void inorderTriversal(Node treeNode) {
        if(treeNode != null) {
            inorderTriversal(treeNode.left);
            System.out.print(treeNode.value+ " ");
            inorderTriversal(treeNode.right);
        }
        return;
    }

    public void preOrderTraversal(Node treeNode) {
        if(treeNode != null) {
            System.out.print(treeNode.value+" ");
            preOrderTraversal(treeNode.left);
            preOrderTraversal(treeNode.right);
        }
        return;
    }

    public void postOrderTraversal(Node treeNode) {
        if(treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.print(treeNode.value+" ");
    }

    public void printGivenLevelData(Node node, int level) {

        if(node == null) {
            return;
        }

        if(level == 1) {
            System.out.print(node.value+ " ");
        }else {
            printGivenLevelData(node.left, level-1);
            printGivenLevelData(node.right, level-1);
        }
    }


    public static void main(String[] args) {
        Node treeNode = new Node(100);
        
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(treeNode, new Node(20));
        bst.add(treeNode, new Node(200));
        bst.add(treeNode, new Node(10));
        bst.add(treeNode, new Node(30));
        bst.add(treeNode, new Node(150));
        bst.add(treeNode, new Node(300));

        System.err.println("Start");
        System.err.print("Inorder: ");
        bst.inorderTriversal(treeNode);

        System.err.println("END");

        System.err.print("Post Order: ");
        bst.postOrderTraversal(treeNode);

        System.err.println("END");

        System.err.print("Pre Order: ");
        bst.preOrderTraversal(treeNode);
        System.err.println("END");

        System.err.print("Level order: ");

        Node node  = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(7);
        node.left.right = new Node(6);
        node.right.left = new Node(5);
        node.right.right = new Node(4);
        bst.printGivenLevelData(node,3);
        System.err.println("END");

        
    }
}
