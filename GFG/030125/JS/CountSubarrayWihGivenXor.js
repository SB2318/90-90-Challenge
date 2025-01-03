// Problem link: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
class Solution {
    subarrayXor(arr, k) {
        // your code here
        let map = new Map();
        let ans =0;
        let currXor=0;
        
        
        for(let e in arr){
            
            currXor^=arr[e];
            
            if(currXor === k){
                ans++;
            }
            
            let z = currXor^k;
            if(map.has(z)){
               ans+= map.get(z);
            }
            
            let x =0;
            
            if(map.has(currXor)){
                x= map.get(currXor);
            }
            
            map.set(currXor, x+1);
        }
        
        return ans;
    }
