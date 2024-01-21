/**
  Problem Date: 20/01/2024
  Problem Name: Find if Array Can Be Sorted
  Problem Link: https://leetcode.com/problems/find-if-array-can-be-sorted/
  Problem Category: Array, Bit Manipulation, Sorting

*/

class Solution {
    
    public boolean sorted(int[] nums){
        
         for(int i=0; i<nums.length-1; i++){
            
             if(nums[i] >nums[i+1]){
                 return false;
             }
         }
        
        return true;
    }
    
    public int countSetBits(int num){
        
        int count =0;
        
        while(num>0){
            num = num &(num-1);
            count++;
        }
        
        return count;
    }
    
   public boolean canSortArray(int[] nums) {
    int  k=0, n= nums.length;
    int[] counts = new int[101];

    for(int i=0; i<n; i++){
        counts[i] = countSetBits(nums[i]);
    }

    while(k<nums.length){
        for(int i=1; i<n; i++){
            if(nums[i] < nums[i-1] && counts[i] == counts[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }

        if(sorted(nums)){
            return true;
        }

        k++;
    }

    return false;
}
}