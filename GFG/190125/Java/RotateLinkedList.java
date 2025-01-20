// Problem Link: https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
// Intution:
// Calculate the net effort, not do the repeated things, and try to optimize.
// When you are rotating the list k times, if you reach the number of times equal to the length of the linked list, then the list remains unchanged.
// if we rotate the list to the left by (n + 1) places, then it is same as rotating the linked list to the left by 1 place. Similarly, if we rotate the linked list k (k >= n) places to the left, then it is same as rotating the linked list by (k % n) places. 
// So, we can simply update k with k % n to handle large values of k.

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        
        // Check base condition
        if(head == null || k==0) return head;
       
        Node curr = head;
        int length =1;
        
        while(curr.next != null){
            curr = curr.next;
            length++;
        }
        
         k = k% length;
        
        if(k==0){
            // list remain unchanged
            return head;
        }
        // else 
        // it is little bit funny, make the linked list circular
        // and try to find kth rotation, how?
        // If you able to visualize the things, you will get the fun point
        // I will not explain
        // 1->2->3-4->1->2->3
        curr.next = head;
        
        for(int i=0; i<k; i++){
            curr = curr.next;
        }
        
        Node newHead = curr.next;
        
        // Now break the loop
        curr.next = null;
        
        return newHead;
    }
}
