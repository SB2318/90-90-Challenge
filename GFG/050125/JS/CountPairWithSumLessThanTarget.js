// Problem Link: https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-less-than-target/1

class Solution {
    countPairs(arr, target) {
        // write your code here
        arr.sort((a, b)=> a-b);  //   custom comparator
       
        let l=0;
        let r= arr.length-1;
        let cnt=0;
        
        while(l<r){
            
            if(arr[l]+arr[r] < target){
                cnt+= (r-l);
                l++;
            }else{
                r--;
            }
        }
        
        return cnt;
    }
}
