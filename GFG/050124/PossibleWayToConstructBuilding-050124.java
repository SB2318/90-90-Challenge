/**
   Problem Date: 05/01/2024
   Problem Name: Count possible ways to construct buildings
   Problem Link: https://www.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/0
   Problem Category: Array, DSA, DP
*/


class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        int REM = 1000000007;
        long[] zero = new long[N+1];
        long[] one = new long[N+1];
        zero[1] =1; 
        one[1] =1;
        
        for(int i=2; i<=N; i++){
            zero[i]= (one[i-1]+zero[i-1])%REM;
            
            one[i]= (zero[i-1]);
            
        }
        
        long val= (zero[N]+one[N])*(zero[N]+one[N]) %REM;
     
        
        return (int) val;
        
        
    }
}
