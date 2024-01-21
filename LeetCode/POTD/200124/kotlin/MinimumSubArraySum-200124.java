/**
  Problem Date: 20/01/2024
  Problem Name: Sum of Subarray Minimums
  Problem Link: https://leetcode.com/problems/sum-of-subarray-minimums/
  Problem Category: Array, Stack, DS

*/

class Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        
        val stack = Stack<Int>()
        val nsl = IntArray(arr.size) {-1}
        val nsr = IntArray(arr.size){arr.size}

        /** Fill NSL */
        for(i in 0..arr.size-1){

            while(stack.isNotEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop()
            }
            if(stack.isNotEmpty()){
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear()

        var i=arr.size-1

        while(i>=0){
            while(stack.isNotEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop()
            }
            if(stack.isNotEmpty()){
                nsr[i] = stack.peek();
            }
            stack.push(i);

            i--
        }

    
        var sum:Long =0
        var mod = 1e9.toLong()+7
       
        for(i in arr.indices){

            sum = sum + (i-nsl[i])*(nsr[i]-i)%mod*arr[i]%mod;

            sum = sum%mod;
        }

        return sum.toInt();
        
    }
}