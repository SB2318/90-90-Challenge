# Problem Link: https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
# Solution Link: https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/

# You can say it is a prefix sum approach or hashing technique.
# But It is like a balance problem,
# Whenever you encounter a 1, you increase the sum, whenever you encounter 0, decrease the sum.
# The sum is 0, which means till now, you get a balance sub-array, and each time whenever you check checking the sum key is present in the array or not,
# see for 0 cases, you are storing the max value as i+1, as mp[0] = -1
# But there is a case when there is more than one consecutive 1, or more than one consecutive 0.
# To handle the consecutive cases, we again use HashMap, when two sums superimpose each other, we get the distance, and store if it is max.

# Visual Description:
# You increase the sum when encountering a 1 (sum++).
# You decrease the sum when encountering a 0 (sum--).
# The balance between the number of 0s and 1s can be tracked using the running sum.
# If the sum becomes zero, it means that up to that index, the number of 0s and 1s are balanced, forming a subarray with equal 0s and 1s.

# HashMap Usage:
# The HashMap is used to store first occurence of each sum.
class Solution:
    def maxLen(self, arr):
        # code here
        sum=0
        map={}
        ans=0
        map[0] = -1
        for i in range(len(arr)):
            if arr[i] == 0: 
                sum-=1
            else: 
                sum+=1
            
            if sum in map:
                ans = max(ans, i-map[sum])
            else:
                map[sum]=i
        return ans
