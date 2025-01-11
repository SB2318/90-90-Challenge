# Problem Link: https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
# Intution: Sliding window
# Take the first k elements and create 1 window, collect distinct elements, and add the window size.
# Then start sliding your window, and collect distinct elements by removing the previous one.

from collections import defaultdict
class Solution:
    def countDistinct(self, arr, k):
        # Code here
        res=[]
        map = defaultdict(int)
        
        for i in range(k):
            map[arr[i]]+=1
        res.append(len(map))
        
        for i in range(k,len(arr)):
            if(map[arr[i-k]] == 1):
                del map[arr[i-k]]
            else:
               map[arr[i-k]]-=1
            map[arr[i]]+=1
            res.append(len(map))
        return res
