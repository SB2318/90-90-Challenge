# Problem Link: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

# Intution: Prefix Sum + HashMap

# As this is a famous question, instead of sharing my thoughts, I am sharing article links here from my collection, which might be helpful for all of you. 
# https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/ 
# https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/

class Solution:
    def longestSubarray(self, arr, k):  
        # code here
        map = {}
        prefixSum=0
        ans =0
        
        for i in range(len(arr)):
            prefixSum += arr[i]
            
            if prefixSum == k:
               ans = max(ans, i+1)
             
            if prefixSum-k in map:
                ans = max(ans, i-map[prefixSum-k])
            
            if prefixSum not in map:
               map[prefixSum] = i
            
        return ans
