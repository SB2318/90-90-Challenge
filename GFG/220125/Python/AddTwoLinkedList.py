# Problem Link: https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
# Solution Link: https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-list/

class Solution:
    def addTwoLists(self, num1, num2):
        # code here
        a = self.reverse(num1)
        b = self.reverse(num2)
        temp = Node(0)
        ans = temp
        carry =0
        
        while a and b:
              d = a.data + b.data + carry
              n = Node(d%10)
              n.next = None
              temp.next = n
              temp = temp.next
              carry = d//10
              a = a.next
              b = b.next
             
        while a:
              d = a.data + carry
              n = Node(d%10)
              n.next = None
              temp.next = n
              temp = temp.next
              carry = d//10
              a = a.next
             
              
        while b:
              d = b.data + carry
              n = Node(d%10)
              temp.next = n
              n.next = None
              temp = temp.next
              carry = d//10
              b = b.next
         
        node = Node(carry)
        temp.next = node
        ans = ans.next
        p = self.reverse(ans)
       
       
         # remove leading 0
         
        while  p.data == 0 and p.next is not None:
               p = p.next
               
        return p
              
        
    def reverse(self, head):
        prev = None
        curr = head
        
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev
        
