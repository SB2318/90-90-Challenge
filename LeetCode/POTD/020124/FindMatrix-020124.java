/**
  Problem Date: 02/01/2024
  Problem Name: Convert an Array Into a 2D Array With Conditions
  Problem Link: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
  Problem Category: Array, DSA, MAP
*/


class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        /** Let us store the result first */
        List<List<Integer>> result = new ArrayList<>();
       /** Take extra space to store the freequency of the array  */
       HashMap<Integer,Integer> map = new HashMap<>();

       for(int i=0; i<nums.length; i++){

           int freq= map.getOrDefault(nums[i],0);
          
           if(freq == result.size()){
              /** Add a new row */
               result.add(new ArrayList<>());
           }
           /** Insert the element into new row */
           result.get(freq).add(nums[i]);

           map.put(nums[i], map.getOrDefault(nums[i],0)+1);

       }

       return result;
    }
}
