// Problem Link: https://www.geeksforgeeks.org/problems/container-with-most-water0535/1# Problem Link: https://www.geeksforgeeks.org/problems/container-with-most-water0535/1
// Intution: Two Pointer
// This is a pure mathematics problem, kind of integration or area calculation problem you can think,
// At each step, the area formed between the lines at indices left and right is computed as:
// Area = min(arr[i], arr[j])*(j-i)

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        
        int left=0, right = arr.length-1;
        
        int ans =0;
        
        while(left < right){
            
            int t = Math.min(arr[left], arr[right])*(right-left);
            ans = Math.max(ans, t);
            
            if(arr[left] < arr[right]) left++;
            else right--;
        }
        
        return ans;
    }
}
