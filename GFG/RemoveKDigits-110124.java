/***

 Problem Date : 11/01/24
 Problem Name : Remove K Digits
 Problem Link: https://www.geeksforgeeks.org/problems/remove-k-digits/1
 Problem Category: String, Stack, DSA

*/


class Solution {
  public:
    string removeKdigits(string S, int K) {

      /**

        1. Intuition, we have to return the smallest possible number, which means we have to arrange the numbers in increasing order,
        Also have to maintain their relative position.
        2. Don't make the target remove all large elements as soon as you see it, and decrease the array value.
           Rather than try to remove the element from the left side, whenever you see the first large element from the left side, you will remove 
           it, and will decrease the K value, I guess at this position you can visualize it.
        3. You have to available the number on the top of your data structure, Stack will be the most useful data structure for this purpose.
        4. You make available the peak element or max element at the top of the stack.
        5. If the Incoming element is not peak or max, you will start removing the peek from the start until you find your incoming element is largest.
           As well as at this time you decrease the K value.
        6. You have to restrict the entry of the stack also, in this way, it will not contain any leading 0.

      */
        int n = S.size();
        stack<char> mystack;
        
        for(char c: S){

           /** We have to arrange the stack in increasing order.
             * Target : top element will be largest, if incoming element greater than top we will replace it */
             
             /** Remove all perevious smallest element */
            while(!mystack.empty() && K > 0 && mystack.top() > c){
                mystack.pop();
                K--;
            }

            /** Never add leading zero, when stack is empty,
              * add element other than zero when stack is empty *
              * write an efficient condition, which cover both of them */
          
            if(!mystack.empty() || c != '0'){
                mystack.push(c);
            }
        }

       /** In the case when K is still have some positive value
         */
        while(!mystack.empty() && K--){
            mystack.pop();
        }
        
        if(mystack.empty()){
            return "0";
        }

      /** PROPERTY OF STACK : LIFO , So we have to add element in reverse order */
      /** What this code is doing , It is adding each top element of the stack at the end of the String, and similary decreasing the n value */

      /** At last it returns the Substring of S (n, S.size()) */
      
        while(!mystack.empty()){
            
            S[n-1] = mystack.top();
            mystack.pop();
            n--;
        }
        
        return S.substr(n);
    }
};

