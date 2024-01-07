/**
  Problem Date: 06/01/2024
  Problem Name: Smallest Missing Integer Greater Than Sequential Prefix Sum
  Problem Link: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
  Problem Category: Array,DSA,Searching
*/

class Solution {
    
    public int missingInteger(int[] nums) {
        int max_sum = maxSumIncreasingSubsequence(nums);
        
         if(!isPresent(nums,max_sum)){
            return max_sum;
        }
         
         while(isPresent(nums,max_sum)){
             max_sum++;
         }
        return max_sum;
    }
    
   public int maxSumIncreasingSubsequence(int[] arr) {
       
      int n = arr.length;
        int maxSum = arr[0];
      

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]+1) {
                maxSum += arr[i];
                 
            } else {
                break;
            }
        }

        return maxSum;
    }
    
    private boolean isPresent(int[] nums, int element) {
        for (int num : nums) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }
}