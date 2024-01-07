/**
  Problem Date: 07/01/2024
  Problem Name: Arithmetic Slices II - Subsequence
  Problem Link: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/?envType=daily-question&envId=2024-01-07
  Problem Category: Array, 2D-Array,DSA,DP

*/

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int total_count = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                long diff = (long) nums[i] - nums[j]; 

                /** For test  Case [0,2000000000,-294967296] */
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue; 
                }

                int diffInt = (int) diff;
    
      /** dp[i] contains the common differences and corresponding subsequences count with this differences */
      
     /** Update dp[i][diff] by incrementing it by 1, indicating that we have 
    found a new arithmetic subsequence ending at index i with a common difference of diff. */
                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + 1); 

                /** Check whether these difference present in previous map or not. */ 
                if (dp[j].containsKey(diffInt)) {
                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
                    total_count += dp[j].get(diffInt);
                }
            }
        }


       /**
    After the loops, the total_count will contain the total number of arithmetic subsequences.
        */
        return total_count;


        /*** Time & Space Complexity : O(n^2) */
    }
}
