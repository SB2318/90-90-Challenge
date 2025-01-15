# Problem Link: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/?envType=daily-question&envId=2025-01-14
# Beginner Friendly Solution

class Solution(object):
    def findThePrefixCommonArray(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        setA = set()
        setB = set()
        count = [0]*(len(A))

        for i in range(len(A)):
            setA.add(A[i])
            setB.add(B[i])

            for e in setA:
                if e in setB:
                   count[i]+=1

        return count
