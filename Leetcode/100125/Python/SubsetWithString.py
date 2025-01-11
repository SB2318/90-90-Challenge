# Problem Link: https://leetcode.com/problems/word-subsets/description/
# Intution: Understanding the problem statement is the key 
# Problem Explanation:
# You are given two list of words, words1 and words2
# words1 -> A list from which you need to find the universal words
# words2 -> A list of word that defines the requirement
# A word in words1, considered universal, if for every word in words2,  it contains at least the same number of each character that appears in that word.
# It might be confusing, let's simplify the statement.
# If a word in words2 has 2 occurences of letter 'a', then any universal word of words1 must contain at least 2 'a'. same for all.
# So, our first target is to find the max freequency of each character ('a' to 'z') in words2 array.
# Then you have to find whether any word in words1 array matches the requirement or not.

class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        res=[]
        bmax= [0]*26

        for word in words2:
            bcount = self.count(word)
            for j in range(26):
                bmax[j] = max(bmax[j], bcount[j])

        for word in words1:
            acount = self.count(word)
            flag = 1
            for j in range(26):
                if acount[j] < bmax[j]:
                    flag=0
                    break
            if flag == 1:
                res.append(word)
        return res
    # @staticmethod allows you to create static method, without an instance of the class
    def count(self,word) -> List[int]:
        ans = [0]*26

        for c in word:
            idx = ord(c) - ord('a')
            ans[idx]+=1

        return ans
