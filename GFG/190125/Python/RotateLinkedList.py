# Problem Link: https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
# Solution Link: https://www.geeksforgeeks.org/rotate-a-linked-list/
# Intution:
# Calculate the net effort, not do the repeated things, and try to optimize.
# When you are rotating the list k times, if you reach the number of times equal to the length of the linked list, then the list remains unchanged.
# if we rotate the list to the left by (n + 1) places, then it is same as rotating the linked list to the left by 1 place. Similarly, if we rotate the linked list k (k >= n) places to the left, then it is same as rotating the linked list by (k % n) places. 
# So, we can simply update k with k % n to handle large values of k

class Solution:
    
    #Function to rotate a linked list.
    def rotate(self, head, k):
        # code here
        if head == None or k ==0:
           return head
        curr = head
        len = 1
        
        while curr.next != None:
              curr= curr.next
              len+=1
        k = k%len
        
        if k==0:
            return head
        
        curr.next = head
        
        for i in range(k):
            curr = curr.next
        newHead = curr.next
        
        #break the loop
        curr.next = None
        
        return newHead
