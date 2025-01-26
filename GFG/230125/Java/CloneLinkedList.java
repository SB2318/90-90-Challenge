// Problem Link: https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
// Solution Link: https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/

class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        
        while(curr != null){
            
            map.put(curr, new Node(curr.data));
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr != null){
            
            Node newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }
}
