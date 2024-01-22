/**

   Problem Date: 21/01/24
   Problem Name: House Robber
   Problem Link: https://leetcode.com/problems/house-robber/
   Problem Category: Array, DP, Recursion

*/
class Solution {
    private lateinit var dp: IntArray

    fun rob(nums: IntArray): Int {
        dp = IntArray(nums.size) { -1 }
        return helper(0, nums)
    }

    private fun helper(index: Int, nums: IntArray): Int {
        if (index >= nums.size) {
            return 0
        } else if (dp[index] != -1) {
            return dp[index]
        } else {
            val take = nums[index] + helper(index + 2, nums)
            val skip = helper(index + 1, nums)
            dp[index] = maxOf(take, skip)
            return dp[index]
        }
    }
}
