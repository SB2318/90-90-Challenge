/**
  Problem Date: 20/01/2024
  Problem Name: Divide an Array Into Subarrays With Minimum Cost
  Problem Link: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/description/
  Problem Category: Queue

*/

class Solution {
    public int minimumCost(int[] nums) {
        
         PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);

         for(int i=1; i<nums.length; i++){
              
               pq.offer(nums[i]);
              if(pq.size() > 2){
                  pq.poll();
              }
          }
        
        int sum=nums[0];
        
        while(!pq.isEmpty()){
            
            int val = pq.poll();
            System.out.println(val);
            sum += val;
        }
        
        return sum;  
    }
}