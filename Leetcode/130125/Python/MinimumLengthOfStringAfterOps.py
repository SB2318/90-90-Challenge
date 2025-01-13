# Problem Link: https://leetcode.com/problems/minimum-length-of-string-after-operations/description/?envType=daily-question&envId=2025-01-13
# Intution: 
# Count the frequency of each character
# If it is odd in length, after left-right cancellation, always one character left.
# If it is even, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', always two character left

class Solution(object):
    def minimumLength(self, s):
        """
        :type s: str
        :rtype: int
        """
        freq = [0]*26
        for i in range(len(s)):
            freq[ord(s[i])-ord('a')]+=1
        delCount=0
        for i in range(len(freq)):
            if freq[i]%2==1 and freq[i]>1:
               delCount+= freq[i]-1
            elif freq[i]>2:
                delCount+= freq[i]-2
        return len(s)- delCount
