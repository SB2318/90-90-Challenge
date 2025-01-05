// Problem Link: https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-less-than-target/1

// Intution: Two pointer approach

class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        int count=0;
        Arrays.sort(arr);
        int l=0, r=arr.length-1;
        
        while(l<r){
            
            if(arr[l]+arr[r] <target){
                count+= (r-l);
                l++;
            }else{
                r--;
            }
        }
        
        return count;
    }
}
