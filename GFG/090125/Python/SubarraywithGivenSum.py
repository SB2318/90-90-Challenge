# Problem Link: https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
# Sliding Window

class Solution:
    def subarraySum(self, arr, target):
        # code here
        curr, start = 0, 0
        res = []
        
        for i in range(len(arr)):
            curr+=arr[i]
            
            while curr>target and start<i:
                  curr-=arr[start]
                  start+=1
            if curr == target:
               res.append(start+1)
               res.append(i+1)
               return res
        res.append(-1)
        return res
