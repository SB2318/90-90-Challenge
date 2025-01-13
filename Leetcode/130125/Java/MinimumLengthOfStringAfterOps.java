// Problem Link: https://leetcode.com/problems/minimum-length-of-string-after-operations/?envType=daily-question&envId=2025-01-13
// Intution: 
// If it is odd in length, after left-right cancellation, always one character left.
// If it is even, 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', always two character left

class Solution {
    public int minimumLength(String s) {
        
        int del=0;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) -'a']++;
        }

        for(int i: freq){
            
            if(i==0) continue;
            else if(i%2 == 1)
              del+=1;
            else
              del+=2;
        }

       return del;
    }
}
