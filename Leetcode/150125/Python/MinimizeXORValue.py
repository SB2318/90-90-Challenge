# Problem Link: https://leetcode.com/problems/minimize-xor/submissions/1510626724/?envType=daily-question&envId=2025-01-15
# Intution:
# Question Requirements: We have to find x,
# (i) x has the same number of set bits as num2, and
# (i) The value x XOR num1 is minimal.
# To get a minimal XOR value between two numbers, you have to ensure that
# The XOR value between two numbers is minimal. (as per the question requirements)
 
class Solution(object):
    def minimizeXor(self, num1, num2):
        """
        :type num1: int
        :type num2: int
        :rtype: int
        """
        targetBitCount= self.countSetBits(num2)
        setBitCount=0
     
        res=0

        for i in range(32)[::-1]:
            if num1 & (1 << i) != 0 or targetBitCount - setBitCount > i:
                res |= 1<<i
                setBitCount+=1
            if setBitCount >= targetBitCount: 
                break
              
        return res
                  
                 
    def countSetBits(self, num):
        count=0
        while num > 0:
            num = num&(num-1)
            count+=1
        return count

        
