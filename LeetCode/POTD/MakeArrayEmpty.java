/**
  Problem Date: 04/01/2024
  Problem Name: Minimum Number of Operations to Make Array Empty
  Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
  Problem Category: Array,MAP, Mathematics,DSA,
*/

/** Observation Category */
class Solution {
    public int minOperations(int[] nums) {
        
        HashMap<Integer,Integer> freq= new HashMap<>();

        for(int num:nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        int result=0;

    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

     //   System.out.println(entry.getKey() + ":" + entry.getValue());
       int f= entry.getValue();
       if(f==1){
           return -1;
       }
       
       /*** Great technique for this type of question,
       When we want to check, how much we have to reduce from something 
       to make it  divisible. */
       result += (int) Math.ceil(f*1.0/3);
    } 

    return result;  
    }
    
}

