# Problem Link: https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
# Solution Link: https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
class Solution:
    def cloneLinkedList(self, head):
        # code here
        map = {}
        curr = head
        
        while curr:
            map[curr] = Node(curr.data)
            curr= curr.next
        
        curr = head
        
        while curr:
              newNode = map.get(curr)
              newNode.next = map.get(curr.next)
              newNode.random = map.get(curr.random)
              curr = curr.next
        return map[head]
