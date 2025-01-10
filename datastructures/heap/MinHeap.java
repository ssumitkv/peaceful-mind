package datastructures.heap;
import java.util.ArrayList;
/*
 * TODO: Implement heap sort also.
 */
public class MinHeap {
    // Implement heap sort also.
    
    static ArrayList<Integer> heap = new ArrayList<>();

    public static void main(String[] args) {
        insert(3);
        insert(10);  
        insert(40);
        
        
        insert(51);
        insert(60);
        insert(6);
        insert(16);
        System.out.println(heap);
        
        delete(0);
        
        System.out.println(heap);
        delete(0);
        
        System.out.println(heap);
        delete(0);
        
        System.out.println(heap);
        insert(80);
        insert(0);
        
        
        System.out.println(heap);
        delete(0);
        
        System.out.println(heap);
    }

    public static int delete(int i) {
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapifyDown(i);
        return heap.get(0);
    }

    public static void heapifyDown(int i) {
        // for finding left child in the heap array use this formula:
        // leftChildIndex = i * 2 + 1
        // rightChildIndex = i * 2 + 2

        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int smallest = i;
        if(left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if(right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if(smallest != i) {
            swap(smallest, i);
            heapifyDown(i);
        }


    }

    // Insert at the end and then verify with the parent. Formula for finding the parent of any node is: 
    // parent = ((i - 1) / 2)  [i is node location]
    static void insert(Integer value) {
        heap.add(value);
        int i = heap.size() - 1; // location of new element.
        // varify parent and place it in right location
        // if parent is smaller then replace till it becomes largest among all child nodes.

        while(i > 0) {
            int parentLocation = (i - 1) /2;
            if(heap.get(parentLocation) > heap.get(i)) {
                swap(i, parentLocation);
                i = parentLocation;
            }
            else {
                break;
            }
        }


    }

    static void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

}
