//   Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SumOfTwoNumber {

// 8 2 3
// 4 5 6
//=2 8 9 

//  9 9 9 
//  9 9 9 9 9 9 9
//  8 9 9 0 0 0 0 1
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        
        SumOfTwoNumber sum = new SumOfTwoNumber();
        ListNode result = sum.addTwoNumbersTwo(l1, l2);
        while(result != null) {
            System.out.print(result.val+ " ");
            result = result.next;
        }

    }

    int findRemainder(Integer currentSum) {
        if(currentSum > 9) {
            currentSum.valueOf(currentSum % 10);
            return currentSum / 10;
        }
        else {
            return 0;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode head = new ListNode();
        ListNode result = head;
        while(l1 != null || l2 != null) {
            Integer currSum = 0;
            // add two numbers
            if(l1 != null && l2 != null) {
                currSum = l1.val + l2.val + rem;
                rem = 0;
                if(currSum > 9) {
                    rem = currSum / 10;
                    currSum = currSum % 10;
                }
                l1 = l1.next;
                l2 = l2.next;

            }
            else if (l1 != null && l2 == null) {
                currSum = l1.val + rem;
                rem = 0;
                if(currSum > 9) {
                    rem = currSum / 10;
                    currSum = currSum % 10;
                }
                l1 = l1.next;
            }
            else if (l1 == null && l2 != null) {
                currSum = l2.val + rem;
                rem = 0;
                if(currSum > 9) {
                    rem = currSum / 10;
                    currSum = currSum % 10;
                }
                l2 = l2.next;
            }
            if(head == null) {
                head = new ListNode(currSum);
            } else {
                head.next = new ListNode(currSum);
                head = head.next;
            }
        }
        if(rem != 0) {
            head.next = new ListNode(rem);
            rem = 0;
        }
        return result.next;
    }

    ListNode addTwoNumbersTwo(ListNode l1, ListNode l2) {
        int rem=0;
        ListNode result = new ListNode();
        ListNode temp = result;

        while (l1 != null || l2 != null || rem != 0) {
            int total =0;
            if(l1 != null) {
                total +=l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                total +=l2.val;
                l2 = l2.next;
            }
            total += rem;
            rem = total / 10;
            total = total % 10;
            temp.next = new ListNode(total);
            temp = temp.next;
        }
        return result.next;
    }
}
