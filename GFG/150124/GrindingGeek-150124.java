/***
 Problem Date: 15/01/24
 Problem Name: Grinding Geek
 Problem Link: https://www.geeksforgeeks.org/problems/grinding-geek/1
 Problem Category: Array, DP, Recursion
*/

/** Approach 1 : Recursion */

class Solution {
    int[][] dp;
    public int max_courses(int n, int total, int[] cost) {
        // code here
        dp= new int[cost.length][total+1];
    
         for(int[] arr: dp){
             Arrays.fill(arr,-1);
         }
        return solve(cost,0, total);
    }
    
    private int solve(int[] cost, int index, int total){
        
        if(index == cost.length){
            return 0;
        }
        else if(dp[index][total] != -1){
            return dp[index][total];
        }
        
        else if(total >= cost[index]){
            
            // take
            int newGain = (total - cost[index]) + (int) Math.floor((90*cost[index])/100);
            int take = 1 + solve(cost, index+1, newGain);
            
            //skip
            int skip = solve(cost, index+1, total);
            
            return dp[index][total] = Math.max(take, skip);
        }
        
        // Skip the index
        return  dp[index][total] = solve(cost, index+1, total);
    }
}


/** Approach 2 : Dynamic Programming */

class Solution {
    //int[][] dp;
    public int max_courses(int n, int total, int[] cost) {
        
        /** Take a grid named dp such that
         *  dp[row][column] -> If the student start with row-th course and initially he/she have column amount money,
         *                      then the maximum amount of course he/she can take.
         */
         
       int[][] dp = new int[cost.length + 1][total + 1];

        /** Initialize it with -1 */
        for (int i = 0; i <= cost.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        
        /** Your task is to fill the dp grid */

        for (int index = cost.length - 1; index >= 0; index--) {
            for (int t = 0; t <= total; t++) {
                if (t >= cost[index]) {
                    int newGain = (t - cost[index]) + (90 * cost[index]) / 100;
                    int take = 1 + dp[index + 1][newGain];
                    int skip = dp[index + 1][t];
                    dp[index][t] = Math.max(take, skip);
                } else {
                    dp[index][t] = dp[index + 1][t];
                }
            }
        }

        return dp[0][total];  
    }
}
