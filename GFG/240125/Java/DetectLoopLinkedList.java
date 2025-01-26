// Problem Link: https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
// Intution: Floyd's Algorithm (Slow-Fast Pointer Approach) , You can also use Hashset as an alternative, But let's try.
// Key Point to Remember:
// When slow pointer enters the loop, the fast pointer must be inside the loop. 
// slow pointer moves one step forward and the fast pointer moves two steps forward

class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        Node slow = head;
        Node fast = head.next;
        
        while(slow != null && fast != null && fast.next != null){
            
            if(slow == fast){
                return true;
            }
            slow = slow.next; // slow movement
            fast = fast.next.next; // fast movement
        }
        
        return false;
    }
}
