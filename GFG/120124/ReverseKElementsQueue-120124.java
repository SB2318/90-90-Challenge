
/**
  Problem Date: 12/01/24
  Problem Name: Reverse First K elements of Queue
  Problem Link: https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
  Problem Category: Queue, Stack, DSA
*/

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
       /**
         Stack: LIFO (Element will be add at the top of the stack, element removed from the top, last inserted element will remove first.)
         Queue: FIFO  (Element always inserted from end, element always remove from front, First inserted element will remove first)

         Java:
          q.poll() : Remove the front element and will return the element
          q.add() : Will add element at the end

       */
         
        int n= q.size();
        int remaining = n-k;
        
        Stack <Integer> stack = new Stack<Integer>();
         
        while(k-->0) {
            // add first k element into stack;
           stack.push(q.poll());
        }
        
        /** Now add all stack element into q */
         while(!stack.isEmpty()){
             q.add(stack.pop());
         }
         
         /** Now, remove remaining element from q and again add it back */
         
         while(remaining-- >0){
             q.add(q.poll());
         }
        
        return q;
        
    }
}
