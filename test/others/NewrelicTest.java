package test.others;



import java.io.*;
import java.util.*;


// 2. Connect nodes on the same level
class Node {
    int value;
    Node left;
    Node right;
    Node next;
    int height;
    
    Node(int value) {
      this.value = value;
    }
  }

class Solution {

   public static void inorderTriversal(Node treeNode) {
        if(treeNode != null) {
            inorderTriversal(treeNode.left);
            System.out.println(treeNode.value + " -> " + (treeNode.next != null ? treeNode.next.value : "null"));
            inorderTriversal(treeNode.right);
        }
        return;
    }

  public static void restructure(Node node) {
    if(node == null ) {
      return ;
    }

    // map next
    if(node.left != null){
      node.left.next = node.right;
    }
    
    if(node.next != null && node.right != null)
      node.right.next = node.next.left;

      restructure(node.left);
      restructure(node.right);
  }



  public static void main(String[] args) {
    Node node = getTestData();
    restructure(node);
    inorderTriversal(node);
  }

  private static Node getTestData() {
    Node node8 = new Node(8);
    Node node9 = new Node(9);
    Node node10 = new Node(10);
    Node node11 = new Node(11);
    Node node12 = new Node(12);
    Node node13 = new Node(13);
    Node node14 = new Node(14);
    Node node15 = new Node(15);

    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    
    node4.left = node8;
    node4.right = node9;
    
    node5.left = node10;
    node5.right = node11;
    
    node6.left = node12;
    node6.right = node13;
    
    node7.left = node14;
    node7.right = node15;

    Node node2 = new Node(2);
    Node node3 = new Node(3);
    
    node2.left = node4;
    node2.right = node5;
    
    node3.left = node6;
    node3.right = node7;

    Node root = new Node(1);
    root.left = node2;
    root.right = node3;
    return root;
  }

}


// 1. Rat in a Maze

// class Solution {
//   public static void main(String[] args) {

//     int[][] maze = {
//             {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//             {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
//             {0, 0, 0, 1, 0, 0, 1, 0, 1, 0},
//             {1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
//             {0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
//             {0, 1, 0, 0, 1, 1, 1, 1, 1, 1},
//             {0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
//             {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//             {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
//             {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
//         };
//     System.out.println("Possible: "+check(maze, 0,0));
//   }

//   static boolean check(int[][] maze, int i, int j) {

//     if( i < 0 || j < 0 || i > maze.length-1 || j > maze[0].length-1 || maze[i][j] == 0 || maze[i][j] == -1) {
//       return false;
//     }

   
//     maze[i][j] = -1;

//     if(i == maze.length - 1 && j == maze[0].length - 1 ) {
//       return true;
//     }

//     return 
//       check(maze, i+1, j) ||
//       check(maze, i-1, j) ||
//       check(maze, i, j+1) ||
//       check(maze, i, j-1);
    
//   }
// }
