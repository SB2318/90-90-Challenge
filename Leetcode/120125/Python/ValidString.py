# Problem Link: https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/?envType=daily-question&envId=2025-01-12

class Solution(object):
    def canBeValid(self, s, locked):
        """
        :type s: str
        :type locked: str
        :rtype: bool
        """
        minOpen, maxOpen =0,0

        for i in range(len(s)):
            if locked[i] == '0':
                maxOpen += 1
                minOpen = 1 if minOpen == 0 else minOpen-1 # to balance close parenthesis
            else:
                if s[i] == '(':
                    maxOpen+=1
                    minOpen+=1
                else:
                    maxOpen-=1
                    minOpen = 1 if minOpen == 0 else minOpen-1

                    if minOpen> maxOpen:
                        return False

        return minOpen==0
