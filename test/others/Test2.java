package test.others;

import java.util.LinkedList;
import java.util.List;

class Node{
    int data;
    Node next;
    Node(int data, Node next) {
        this.data= data;
        this.next = next;  
    }
}

class DoublyLinkedList{
    // Node head;
    // Node end;  // don't  use it for now.
    // int size;

    boolean insertAt( Node node, int data, int position) {
        int currPosition = 0;
        Node prev = null;
        while (node != null) {
            if(currPosition == position ) {
                // add new node
                Node newNode = new Node(data, node);
                if(prev != null) {
                    prev.next = newNode;    
                }
                return true;
            }
            prev = node;
            node = node.next;
            currPosition++;
        }

        return false;
    }

    boolean removeAt(Node node, int position) {
        int currPosition = 0;
        Node prev = null;
        while (node != null) {
            if(currPosition == position ) {    
                if(prev != null) {
                    prev.next = node.next;    
                }else{
                    // for position 0
                    node = node.next;
                }
                return true;
            }
            prev = node;
            node = node.next;
            currPosition++;
        }

        return false;
    }

    Node reverse(Node node){
      Node temp = null;
      Node head = node;
      while (node.next != null) {
        temp = node;
        temp.next = node.next.next;
        head.next = temp;
      }
      return head;
    }

    static void print(Node node) {
        System.out.print("Display LL - ");
        while (node.next != null) {
            System.out.print("  "+node.data);
            node = node.next;
        }
        System.out.print("End Display LL");

    }
    
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, null)));

        DoublyLinkedList.print(head);
    }

}

public class Test2 {
// DLL insert at, removeat, reverse, display    



}











