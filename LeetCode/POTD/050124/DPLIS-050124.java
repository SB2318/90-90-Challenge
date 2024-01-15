
 /***
   Problem Date: 05/01/24
   Problem Name: Longest Increasing Subsequence
   Problem Category: Array, DSA, DP
   Problem Link: https://leetcode.com/problems/longest-increasing-subsequence/
   
  */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, -1, nums, n, dp);
    }

    private int f(int index, int prevInd, int[] nums, int n, int[][] dp) {
        if (index == n) return 0;
        if (dp[index][prevInd + 1] != -1) return dp[index][prevInd + 1];
        int len = 0 + f(index + 1, prevInd, nums, n, dp);
        if (prevInd == -1 || nums[index] > nums[prevInd]) {
            len = Math.max(len, 1 + f(index + 1, index, nums, n, dp));
        }
        return dp[index][prevInd + 1] = len;
    }
}

