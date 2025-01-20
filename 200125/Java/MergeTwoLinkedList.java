// Problem Link: https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
// Intuition: 🤔
// See, today I will only share a beginner-friendly approach, with auxiliary space 🧠, maybe there are better ways to solve this 💡, maybe I will practice someday 🏋️‍♂️
// And yeah! With this answer, I achieved a new milestone of < 1700 points 🎉, and also an 11000 rank 🏅 in the GFG leaderboard.
// Again I love to solve problems ❤️, the rest of the things are like "Upri Paona" (In Bengali) 🤗

// May the solutions also help others to learn coding 💻📚, whoever needs this. 🙌

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        
       Node temp1=head1;
       Node temp2=head2;
       Node head=new Node(100);
       Node temp=head;
       
       while(temp1!=null && temp2!=null)
       {
           if(temp1.data<temp2.data){
               Node a=new Node(temp1.data);
               temp.next=a;
               temp=a;
               temp1=temp1.next;
           }
           else{
               Node a=new Node(temp2.data);
               temp.next=a;
               temp=a;
               temp2=temp2.next;
           }
       }
       
       if(temp1==null){
           temp.next=temp2;
       }
       else{
           temp.next=temp1;
       }
       return head.next;
    }
}
