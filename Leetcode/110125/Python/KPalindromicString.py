# Problem Link: https://leetcode.com/problems/construct-k-palindrome-strings/?envType=daily-question&envId=2025-01-11
# Key Point:
# 1. Every single character string is palindrome
# 2. A string contains all even occurence of its character can be symmetric
# 3. A string contains all even occurence of its character except one can be symmetric
# 4. If every individual character can form a palindrome, then the maximum number of palindrome we can form is the length of the string

# From the above points it is clear that, to constuct k palindromes strings, we need 
# (i) at least k length strings
# (ii) at max k odd occuences, A palindrome can take only one odd occurences

class Solution(object):
    def canConstruct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: bool
        """
        if len(s)==k: 
            return True
        if len(s)<k:
            return False
        oc=0
        freq=[0]*26
        for c in s:
            freq[ord(c)-ord('a')]+=1
        for e in freq:
            if e%2 == 1:
                oc+=1
        return oc<=k
