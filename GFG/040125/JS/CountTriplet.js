// Problem Link: https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1

class Solution {
    countTriplets(arr, target) {
        // code here
        
        let n= arr.length;
        let res=0;
        
        for(let i=0; i<n-2; i++){
            
            let left = i+1;
            let right = n-1;
            
            while(left < right){
                
                let sum = arr[left]+arr[i]+arr[right];
                
                if(sum == target){
                    res++;
                    let start = left+1;
                    let end = right -1;
                    
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
