# Problem Link: https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1

class Solution:
    def reverseList(self, head):
        # Code here
        
        prev, next = None, None # null initialization in python
        currHead = head;
        
        
        while currHead:
            
            next = currHead.next;
            currHead.next = prev;
            prev = currHead;
            currHead = next;
        
        
        return prev;
