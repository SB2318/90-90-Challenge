# Problem Link: https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1

# Intuition:
# Product Except Self: Nice Problem
# The intuition is, first calculate the prefix product, at first it is initialized with 1, except arr[0], its prefix product will be 1,
# Then it is calculating the prefix product... and so on
# Similar try to collect suffix product, and similar the element will not add, we will first update res array, followed by we update suffix variable.

class Solution:
    def productExceptSelf(self, arr):
        #code here
        prefix=1
        res =[0]*len(arr)
        for i in range(len(arr)):
            res[i]=prefix
            prefix*= arr[i]
        suffix=1
        for i in range(len(arr))[::-1]:
            res[i] *= suffix
            suffix *= arr[i]
        return res
