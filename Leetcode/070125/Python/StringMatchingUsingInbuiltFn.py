 # Problem Link: https://leetcode.com/problems/string-matching-in-an-array/?envType=daily-question&envId=2025-01-07
 # See what I feel here, The same thing we can do using KMP, although for best practices
 # you need to check the result using KMP instead of words[j].contains(words[i]).
 #  This is also acceptable. And Time complexity is the same. 


class Solution(object):
    def stringMatching(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        res=[]

        for i in range(len(words)):
            for j in range(len(words)):
                if i != j and words[i] in (words[j]):
                    res.append(words[i])
                    break

        return res
        
