// Problem Link: https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1
// Solution: Floyd’s Cycle-Finding Algorithm 
// Traverse linked list using two pointers (slow and fast).
// Move one pointer(slow) by one step ahead and another (fast) by two steps ahead.
// If these pointers meet at the same node then there is a loop. If pointers do not meet then the linked list doesn’t have a loop.

// If loop not detected, return null
// If loop detect
// Again initialize slow with head, (as fast already points to a node where the loop is detected)
// We need to measure the first node in the loop, so we need to move left, that's why we reinitialize slow with head
// Now Imagine fast already point a node of the loop, slow point head, now move fast and slow again one by one (this time) to detect another node, 
// When they meet again, you will get your answer.

class Solution {
    public static Node findFirstNode(Node head) {
        // code here
        Node slow= head, fast = head;
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                // loop detected
                break;
            }
        }
        
        if(slow != fast){
            return null;
        }
        
        slow = head;
        
        while(slow != fast){
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}
