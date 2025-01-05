
// Problem Link: https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1

class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n= arr.length;
        int res=0;
        
        for(int i=0; i<n-2; i++){
            
            int left = i+1, right = n-1;
            
            while(left < right){
                
                int sum = arr[left]+arr[i]+arr[right];
                
                if(sum == target){
                    res++;
                    int start = left+1;
                    int end = right -1;
                    
                    while(start < right && arr[start] == arr[start-1]){
                        res++;
                        start++;
                    }
                    
                    while(left< end && arr[end] == arr[end+1]){
                        res++;
                        end--;
                    }
                    left++;
                    right--;
                }
                
                else if(sum > target) right-=1;
                else left+=1;
            }
        }
        
        return res;
    }
}
