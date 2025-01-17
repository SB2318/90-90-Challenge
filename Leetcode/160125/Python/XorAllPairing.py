# Problem Link: https://leetcode.com/problems/bitwise-xor-of-all-pairings/?envType=daily-question&envId=2025-01-16

class Solution(object):
    def xorAllNums(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        xor1, xor2=0,0
        
        # every element in nums1, will appear odd number of times
        if len(nums2)%2 == 1:
           for i in nums1:
               xor1^=i
        # every element in nums2, will appear odd number of times
        if len(nums1)%2 == 1:
           for i in nums2:
               xor2^=i
        return xor1^xor2
        
