/**
  Date: 01/01/2024
  Problem Name: Array Pair Sum Divisibility Problem
  Problem Category: Array, DSA
  Problem Description: Given an array of integers nums and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
  Constraints & Tasks:
  Your Task:  
  You don't need to read input or print anything. Your task is to complete the function maxSumWithK() which takes the array a[], its size n 
  and an integer k as inputs and returns the value of the largest sum of the subarray containing at least k numbers.

  Expected Time Complexity: O(n)
  Expected Auxiliary Space: O(n)

  Constraints:
  1 <= n <= 105
 -105 <= a[i] <= 105
  1 <= k <= n
*/

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        
        if(nums.length%2 == 1){
            return false;
        }
         Set<Integer> usedContainer = new HashSet<>();
        
         
         for(int i=0; i<nums.length; i++){
             
             int rem= nums[i]%k;
             
             if(rem == 0 && usedContainer.contains(0)){
                 usedContainer.remove(0);
                 continue;
             }
             if(!usedContainer.contains(k-rem)){
                 
                
                     usedContainer.add(rem);
               
                 
                
             }else{
                 usedContainer.remove(k-rem);
                 
             }
             
         }
        
        return usedContainer.size()==0;
    }
}
