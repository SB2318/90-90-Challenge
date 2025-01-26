// Problem Link: https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
         //  list = 1->2->3->4->5->6->7->8
         // k=4, 1->2->3->4 => 4->3->2->1, 5->6->7->8 => 8->7->6->5
         if(k==1){
             // means reverse each one node by group reverse 1=>1,2=>2
             return head;
         }
         
         // First reverse first K group;
         Node curr = head, prev=null;
         
         for(int i=0; i<k && curr != null; i++){
             Node next = curr.next; 
             curr.next = prev;
             prev = curr; // 1, 2, 3, 4
             curr = next ; // 2, 3, 4, 5
         }
         // After completion, your list look like
         // 4->3->2->1->5->6->7->8, curr ->5, head->1 (head is pointing to 1, the previous linked list)
         // see, reverse linked list solution
        
         // Now,assign head to prev (The pointer which is pointing to the first group after reverse)
         // Mind it,now your linkedlist looks like 4->3->2->1->....,
         // head -> 1 (the outdated version), prev -> 4 (the new version)
        
         int count =0; // to track every k group reverse
         
         // take a prev variable(you already have), assign it to null
         if(curr == null){
             // means , no more group left,you already reach end
             // we can also do it, by calculating linked list length, but it will
             // take extra o(n) time, so, here you can use intution
             return head;
         }
         
        // curr, not null, repeat the reverse approach for every k group
         // To reverse a linked list, what you do?
          Node head1 = head;
         head = prev; // it will point the first
         prev = null;
         
         Node newHead = curr;
         
         // Start group reversing while curr1 != null,
         
         while(curr != null){
             
           if(count<k){
               count++;
             Node nxt1 = curr.next;
             curr.next = prev;
             prev = curr;
             curr = nxt1;  
             
           }else{
               
               // assign count to 0, as k group complete
               // clear every variable
               head1.next = prev; // as we always return prev, at the end of reverse process
               head1 = newHead;
               newHead = curr;
               
               count =0;
               prev= null;
            }
            
         }
         
         head1.next = prev;
         
         return head;
    }
}

// Now definitely one question come to your mind? why I am doing a separate operation for  first K group?
// It is intentional, to track the head pointer of the result linkedlist.
// How? You have to find it. 
