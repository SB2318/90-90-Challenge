// problem link: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        
        /**
         * Thought Process:
         *   C= A ^ B
         *   A = B ^ C
         * 
         * For a given subarray [i,j],
         * A -> xor of [0,i]
         * B -> xor of [i+1, j]
         * C -> xor of [0,j]
         */
        int curXor=0;
        Map<Integer,Integer> map=new HashMap<>();
        
        int ans=0;
        for(int ele : arr){
            curXor^=ele;
            
            if(curXor==k)
                ans++;
            int z=curXor^k; // z-> A k-> C 
            if(map.containsKey(z))
                ans+=(map.get(z));
            
        
            
            map.put(curXor , map.getOrDefault(curXor, 0)+1);
          
            
        }
        
        
        return ans;
    }
}
