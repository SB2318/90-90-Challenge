/**
   Problem Date: 08/01/2023
   Problem Name: Merge 2 sorted linked list in reverse order
   Problem Link: https://www.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1
   Solution Link: https://www.youtube.com/watch?v=pJP4ZS15F7A
   Problem Category: LinkedList, DSA, Merge Sort
*/

class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
	    // Your code here	
	    Node result = new Node(0);
	    Node temp = result;
	    
	     node1 = reverseList(node1);
	     node2 = reverseList(node2);

      /** This is an evergreen logic provided by MySirG😊(Saurabh Shukla Sir) */
	    while(node1 != null && node2 != null){
	        
	        if(node1.data >= node2.data){
	            Node newNode = new Node(node1.data);
	            temp.next = newNode;
	            temp= temp.next;
	            node1= node1.next;
	        }else{
	           
	            Node newNode = new Node(node2.data);
	            temp.next = newNode;
	            temp= temp.next;
	            node2= node2.next; 
	        }
	    }
	    
	    while(node1 != null){
	        
	          Node newNode = new Node(node1.data);
	            temp.next = newNode;
	            temp= temp.next;
	            node1= node1.next;
	    }
	    
	    while(node2 != null){
	        
	         Node newNode = new Node(node2.data);
	            temp.next = newNode;
	            temp= temp.next;
	            node2= node2.next; 
	    }
	    
	    return result.next;
	    
    }
    
    private Node reverseList(Node node){
        
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
        
    }
}
