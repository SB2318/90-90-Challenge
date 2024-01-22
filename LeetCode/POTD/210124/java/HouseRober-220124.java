/**

   Problem Date: 21/01/24
   Problem Name: House Robber
   Problem Link: https://leetcode.com/problems/house-robber/
   Problem Category: Array, DP, Recursion

*/

class Solution {
    private int[] dp;
    
    public int rob(int[] nums) {
        
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums);
        
    }

    private int helper(int index, int[] nums){

        if(index>= nums.length){
            return 0;
        }
        else if(dp[index]!=-1){
            return dp[index];
        }
        else{

            int take = nums[index] + helper(index+2,nums);
            int skip= helper(index+1,nums);

            return dp[index]= Math.max(take,skip);
        }

    }
}