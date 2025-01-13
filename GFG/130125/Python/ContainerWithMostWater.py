# Problem Link: https://www.geeksforgeeks.org/problems/container-with-most-water0535/1
# Intution: Two Pointer
# This is a pure mathematics problem, kind of integration or area calculation problem you can think,
# At each step, the area formed between the lines at indices left and right is computed as:
# Area = min(arr[i], arr[j])*(j-i)

class Solution:
    def maxWater(self, arr):
        # code here
        left=0
        right=len(arr)-1
        ans=0
        
        while left<right:
              t = min(arr[left], arr[right])*(right-left)
              ans = max(ans, t)
              
              if arr[left] <arr[right]:
                   left+=1
              else:
                  right-=1
        return ans
