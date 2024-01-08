/**
  Problem Date: 06/01/2024
  Problem Name: Minimum Number of Operations to Make Array XOR Equal to K
  Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/
  Problem Category: Bit Manipulation, Mathematics, Algorithm
*/

class Solution {
    public int minOperations(int[] nums, int k) {
        
        /**
          Java Integer bitCount() method
          public static int bitCount(int n)
          Parameter :
          n : the value whose bits are to be counted
          Return :
          This method returns the count of the number of one-bits in the two's complement 
          binary representation of an int value.
         */

         /**
           Thinking Approach:
             Ultimate goal is to equal the xor value of all the elements of the array with k
            We know For XOR Operation
             1^1 =0
             1^0 =1
             means from same bits it returns 0,
             then after doing all the xor operations
             means Let us assume,
             xor_of_all_element ^ k = x

             then the number of set bits in x will represent the minimum number of operations,
             because, if k == xor_of_all_element, then x must be 0.
          */


          for(int i=0; i<nums.length; i++){
              k^=nums[i];
          }

          /** To get number of set bits in k, there are two approach */

          /** First: You can use an inbuilt method Integer.bitCount() */
          //return Integer.bitCount(k);

          /** Second, unset the setbits, and collect it's count' */
           int count=0;

           while(k!=0){
               k= k&(k-1); // This will unset the first set bit every time
               count++;
           }

           return count;

    }
}
