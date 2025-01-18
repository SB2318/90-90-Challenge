// Problem Link: https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1

class Solution {
    Node reverseList(Node head) {
        // code here
        
        Node prev = null;
        Node currHead = head;
        Node next = null;
        
        while(currHead != null){
            
            next = currHead.next;
            currHead.next = prev;
            prev = currHead;
            currHead = next;
        }
        
        return prev;
    }
}
