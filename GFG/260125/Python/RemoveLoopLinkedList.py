# Problem Link: https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
# Solution: Floyd’s Cycle-Finding Algorithm 
# Traverse linked list using two pointers (slow and fast).
# Move one pointer(slow) by one step ahead and another (fast) by two steps ahead.
# If these pointers meet at the same node then there is a loop. If pointers do not meet then the linked list doesn’t have a loop.

# If loop not detected, return null
# If loop detect
# Again initialize slow with head, (as fast already points to a node where the loop is detected)
# We need to measure the first node in the loop, so we need to move left, that's why we reinitialize slow with head
# Now Imagine fast already point a node of the loop, slow point head, now move fast and slow again one by one (this time) to detect another node, 
# When they meet again, you will get your answer.
# Now, there will be two cases, May your loop node be the head and it is connected with a tail.
# To handle the case you have to track the previous node, because when the head is your breakpoint (in the case of the cycle), then your previous node will be the tail
# and you have to assign a tail.next to null
# otherwise, find the intersection point

class Solution:
    #Function to remove a loop in the linked list.
    def removeLoop(self, head):
        # code here
        slow, fast, prev = head, head, None
        
        while slow and fast and fast.next:
              prev = slow
              slow = slow.next
              fast = fast.next.next
              if slow == fast:
                 break
             
        if slow != fast:
           return
       
        if slow == fast and fast == head:
            prev.next = None
            return
        
        slow = head
        while slow.next != fast.next:
              slow = slow.next
              fast = fast.next
              
        fast.next = None
