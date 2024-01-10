
/**
  Problem Date: 10/01/24
  Problem Name: Longest subarray with sum divisible by K
  Problem Link: https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
  Problem Category: Array, DSA
  
*/

class Solution{
    int longSubarrWthSumDivByK(int arr[], int n, int k)
    {
        // Complete the function
      
        int prefixSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> prefixSumModulo = new HashMap<>();
        
        prefixSumModulo.put(0, -1); // Initialize with a prefix sum of 0 at index -1

        for (int i = 0; i < arr.length; i++) {
            
            prefixSum += arr[i];
            
            // In Java, you can ensure that the modulo is non-negative by using the following expression
            int modulo = ((prefixSum % k) + k) % k;  
            

            if (prefixSumModulo.containsKey(modulo)) {
                
                /** Check modulo already present or not, in that case calculate maxLen. Actually there is a little optimization
                 * You have to do it in the next step, means after running the loop. But here we are assumimg, may the index present
                 * in the map already. One another thing, it will always calculate the corresponding index which is far left from i. 
                */
                maxLen = Math.max(maxLen, i - prefixSumModulo.get(modulo));
            } else {
                
                /** Put the modulo and it's corresponding index */
                prefixSumModulo.put(modulo, i);
            }
        }

        return maxLen;
    }
}
