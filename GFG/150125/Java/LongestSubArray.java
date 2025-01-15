// Problem Link: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

// Intution: Prefix Sum + HashMap

// As this is a famous question, instead of sharing my thoughts, I am sharing article links here from my collection, which might be helpful for all of you. 
// https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/ 

class Solution {
    
    public int longestSubarray(int[] arr, int k) {
        // code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum=0, ans=0;
        
        for(int i=0; i<arr.length; i++){
            
            prefixSum+= arr[i];
            
            if(prefixSum == k){
                ans = Math.max(ans, i+1);
            }
            
            if(map.containsKey(prefixSum-k)){
                ans= Math.max(ans, i-map.get(prefixSum-k));
            }
            
            if(!map.containsKey(prefixSum))
              map.put(prefixSum, i);
            
        }
        
        return ans;
        
    }
}

