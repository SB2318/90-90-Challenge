// Problem Link: https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
// Solution Link: https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int sum=0, ans=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);
        for(int i=0; i<arr.length; i++){
            
            if(arr[i] == 0) sum--;
            else sum++;
            
            if(map.containsKey(sum))
               ans = Math.max(ans, i-map.get(sum));
            else
               map.put(sum, i);
        }
        
        return ans;
    }
}
