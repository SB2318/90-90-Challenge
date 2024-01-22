/**

   Problem Date: 22/01/24
   Problem Name: Set Mismatch
   Problem Link: https://leetcode.com/problems/set-mismatch/
   Problem Category: Array, Set

*/
class Solution {
    public int[] findErrorNums(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        int totalSum = (nums.length *(nums.length+1))/2;

        int duplicate=0, sum=0;

        for(int i=0; i<nums.length; i++){

            if(!set.add(nums[i])){
                duplicate = nums[i];
            }
            sum+=nums[i];
        }
       
        return new int[] {duplicate, totalSum-sum+duplicate};

    }
}