// Problem Link: https://leetcode.com/problems/number-of-ways-to-split-array/

class Solution {
    public int waysToSplitArray(int[] nums) {
 
       long[] prefixSum = new long[nums.length];
       prefixSum[0] = nums[0];

       for(int i=1; i<nums.length; i++){
           prefixSum[i]= prefixSum[i-1]+nums[i];
       }

       int count =0;
       for(int i=0; i<nums.length-1; i++){
          long leftSum = prefixSum[i];
          long rightSum = prefixSum[nums.length-1] - prefixSum[i];

          if(leftSum >= rightSum){
            count++;
          }
       }

       return count;
    }
}
