// Problem Link: https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(head == null || head.next == null) return head;
        if(head.next.next == null) {
            if(k % 2 == 0) return head;
            head.next.next = new Node(head.data);
            return head.next;
        }
        Node temp = head;
        int c = 0;
        while(temp != null) {
            temp = temp.next;
            c++;
        }
        k = k % c;
        if(k == 0) return head;
        temp = head;
        while(--k != 0) {
            temp = temp.next;
        }
        if(temp.next == null) {
            return head;
        }
        Node head2 = temp.next;
        temp.next = null;
        temp = head2;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return head2;
    }
}
