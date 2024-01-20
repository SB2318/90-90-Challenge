/**
  Problem Date: 19/01/2024
  Problem Name: Top k numbers in a stream
  Problem Link: https://www.geeksforgeeks.org/problems/top-k-numbers3425/1
  Problem Category: Collections, Array, Queue, CustomComparator,

*/


class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] nums, int N, int k) {
        // code here
     
    /**
     *  you have to iterate over the array, and after each index, determine the top K most frequent numbers until that 
     * iteration and store
     * them in an array in decreasing order of frequency.  wach sublist can contains at most k nums
     
     */
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
       final  HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> container;
        PriorityQueue<Integer> pq;

         /*
        *  Inside map key -> nums[i], value -> frequency of nums[i]
        * 
        * 
        */
        
        Comparator<Integer> customComparator = (x, y) -> {
          
           /** whose frequency is greater */
          int res = Integer.compare(map.get(x), map.get(y));
          
          /** If  freq equal, whose value is greater */
          if (res == 0) {
           res = Integer.compare(y, x);
           }
           return res;
        };
        
        for(int key : nums){
            
            pq = new PriorityQueue<>(customComparator);
             
            map.put(key, map.getOrDefault(key, 0)+1);
             
            for(int key2: map.keySet()){
            // System.out.println("Key :"+value +" : Freq: "+freq);
               pq.add(key2);
             if(pq.size() > k){
                 pq.poll();
             }
            
          
            }
             container = new ArrayList<>();
           
            while(!pq.isEmpty()){

            container.add(pq.poll());
            
          }
            Collections.reverse(container);
            result.add(container);
            
        }

      return result;
    }
}  