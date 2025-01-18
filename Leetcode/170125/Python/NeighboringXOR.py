
# Problem Link: https://leetcode.com/problems/neighboring-bitwise-xor/submissions/1512378995/?envType=daily-question&envId=2025-01-17

# Intution: XOR Properties
#  (i) XOR is Commutative: a xor b = b xor a
# (ii) XOR is Associative  a xor (b xor c) = (a xor b) xor c 
# (iii) Inversion (Most Important) 
#      if a xor b = c, then  a= b xor c or b = a xor c.

# Now, According to the problem requirement, you need to find the original array, 
#  where for each i belongs to [0, n-1] (n is the length of array)
#     derived[i] = original[i] ^ original[i+1], if i == n-1, then, derived[i] = original[i]^original [0] 
# It means, you have to always take mod of length
# By taking the first condition, let's try to obtain original array
#  derived[i] = original[i] ^ original[i+1]
# original[i+1] = derived[i] ^ original[i]  -> This is the formula
# But, then what about the first element of original array.
# From the given statement, original array is a binary array, it means only two value possible, either 0 or 1
# To determine original array,
# First assume, original[0] = 0
# Now, obtain original array
# Check point: Check whether original[n-1]^original[0] === derived[n-1] or not (you can check any element, to compare really we can derived the given array from
# original or not.
# Now, do same by assuming original[0]=1
# Return the possibilities

# P.S: The  similar problem we have solved, where we have used the property (` if a xor b = c, then  a= b xor c or b = a xor c.` ) of xor.
# Here is the problem link: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
# Solution Link: https://github.com/SB2318/90-90-Challenge/tree/main/GFG/030125

class Solution(object):
    def doesValidArrayExist(self, derived):
        """
        :type derived: List[int]
        :rtype: bool
        """
        n = len(derived)
        original = [0]*(n+1)

        # assuming original[0] = 0
        original[0] =0
        for i in range(n):
           original[i+1] = derived[i]^original[i]
        
        dep = original[0]^original[n-1]
        resultForZero= dep== derived[n-1]

        # assuming original[0] = 1
        original[0] =1
        for i in range(n):
           original[i+1] = derived[i]^original[i]
        
        dep = original[0]^original[n-1]
        resultForOne= dep== derived[n-1]

        return resultForZero or resultForOne

        
