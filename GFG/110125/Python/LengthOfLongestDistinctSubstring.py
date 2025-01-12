// Problem Link: https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1
// Similar Problem: https://github.com/SB2318/90-90-Challenge/blob/main/GFG/100125/Python/CountDistinctElement.py

class Solution:
    def longestUniqueSubstr(self, s):
        # code here
        set1 = set();
        left=0
        maxSoFar = 0
        
        for right in range(len(s)):
            while s[right] in set1:
                  set1.remove(s[left])
                  left+=1
            set1.add(s[right])
            maxSoFar = max(maxSoFar, right-left+1)
            
        return maxSoFar
