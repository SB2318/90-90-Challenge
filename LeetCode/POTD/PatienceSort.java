/***
   Problem Date: 05/01/24
   Problem Name: Longest Increasing Subsequence
   Problem Category: Array, DSA, DP
   Problem Link: https://leetcode.com/problems/longest-increasing-subsequence/
   
  */

class Solution {
    public int lengthOfLIS(int[] nums) {

       List<Integer> sortedList = new ArrayList<>();

       for(int i=0; i<nums.length; i++){

           /** Find the index of the element in the sorted array which is just greater than or
           equal to nums[i] */
           int index= lower_bound(sortedList, nums[i]);

           if(index == -1){
               /** Add the element into list */
               sortedList.add(nums[i]);
           }else{

               /** Replace the element with nums[i], as nums[i] shorter than this.*/
               sortedList.set(index,nums[i]);
           }
       }

       return  sortedList.size();
    }

    private int lower_bound(List<Integer> sortedList, int element){

         if(sortedList.size() ==0){
             return -1;
         }
         int low=0, high = sortedList.size();

         int result =-1;

         while(low< high){

             int mid= (low+high)/2;

             if(sortedList.get(mid)>=element ){
                 result=mid;
                 high = mid;
             }else{
                 low= mid+1;
             }
         }

         return result;
    }
}
