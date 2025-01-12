// Problem Link: https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1

/**
  This is one of my favorite problems since I saw its solution, the approach.
  You can consider it a precomputing technique or two-pass DP also. The solution itself was provided by our favorite DSA mentor, Sandeep Jain Sir.

  And he explains it very well, try to collect that video, if possible.
  
  Solution Article Link: https://www.geeksforgeeks.org/trapping-rain-water/
*/

class Solution {
    public int maxWater(int arr[]) {
        // code here
        int[] lmax = new int[arr.length];
        int[] rmax = new int[arr.length];
        
        /** Compute left max value */
        lmax[0] = arr[0];
        for(int i=1; i<arr.length; i++){
           lmax[i]  = Math.max(lmax[i-1], arr[i]);
        }
        
        rmax[arr.length-1] = arr[arr.length-1];
        
        /** Compute right max value */
        for(int j=arr.length-2; j>=0; j--){
            rmax[j] = Math.max(rmax[j+1], arr[j]);
        }
        
        /** Finally compute the trap water amount */
        
        int water =0;
        for(int i=0; i<arr.length; i++){
            water += Math.min(lmax[i], rmax[i])-arr[i];
        }
        
        return water;
    }
}
