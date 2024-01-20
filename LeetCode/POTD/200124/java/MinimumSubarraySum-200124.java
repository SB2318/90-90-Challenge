/**
  Problem Date: 20/01/2024
  Problem Name: Sum of Subarray Minimums
  Problem Link: https://leetcode.com/problems/sum-of-subarray-minimums/
  Problem Category: Array, Stack, DS

*/

class Solution {
    public int sumSubarrayMins(int[] arr) {

       /** Next Smaller element after the array element -> Stack */ 
       /** Next Smaller element from right -> Stack */

       Stack<Integer> stack = new Stack<>();
   
       int[] nsl = new int[arr.length];
       int[] nsr = new int[arr.length];
       
       Arrays.fill(nsl,-1);
       Arrays.fill(nsr,arr.length);

       /** Fill nsl */

       for(int i=0; i<arr.length; i++){

        while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
            stack.pop();
         }

        if(!stack.isEmpty()){
           nsl[i] = stack.peek();
        }
        stack.push(i);
    
     }
       

    stack.clear();
       /** Fill nsr */
       
    for(int i=arr.length-1; i>=0; i--){


        while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
            stack.pop();
        }

        if(!stack.isEmpty()){      
            nsr[i] = stack.peek();
        }
        stack.push(i);    
       }
       /** calculate sum */
       int mod = (int) 1e9+7;
       long sum =0;

       for(int i=0; i<arr.length; i++){

           sum = sum + (long) (i-nsl[i])*(nsr[i]-i)%mod * arr[i]%mod;
           sum = sum%mod;
       }
      return (int) sum;
    }
}