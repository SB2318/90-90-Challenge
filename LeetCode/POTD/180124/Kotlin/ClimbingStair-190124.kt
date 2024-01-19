/**
  Problem Date: 18/01/24
  Problem Name: Climbing Stairs
  Problem Link: https://leetcode.com/problems/climbing-stairs/description
  Problem Category: Array, DP

*/

class Solution {
    fun climbStairs(n: Int): Int {
        
        return if(n==0) 
                0
               else if( n==1)
                1
               else if(n==2)
                2
                else{
              
              val dp = IntArray(n+1)
              dp[0] =0;
              dp[1] =1;
              dp[2] =2;

             for( i in 3..dp.size-1){
                 dp[i] = dp[i-1] + dp[i-2];
             }

             return dp[n];
        }
    }
}
