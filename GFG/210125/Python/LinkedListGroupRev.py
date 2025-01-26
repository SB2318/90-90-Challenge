# Problem Link: https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
# Linkedlist is all about visualization
# Explanation: https://github.com/SB2318/90-90-Challenge/blob/main/GFG/210125/Java/LinkedListGroupReverse.java

class Solution:
    def reverseKGroup(self, head, k):
        # Code here
        if k==1:
           return head
        
        prev,curr = None, head
        count=0
        while count<k and curr != None :
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
            count+=1
        
        if curr == None:
            return prev
        count =0
        head1= head
        head = prev
        prev = None
        newHead = curr
        
        while curr:
            if count <k:
               count+=1
               nxt1 = curr.next
               curr.next = prev
               prev = curr
               curr = nxt1
            else:
                head1.next = prev
                head1 = newHead
                newHead = curr
                count =0
                prev = None
                
        head1.next = prev
        return head
