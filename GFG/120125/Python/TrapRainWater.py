# Problem Link: https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1

class Solution:
    def maxWater(self, arr):
        # code here
        n= len(arr)
        lmax=[0]*n
        rmax=[0]*n
        
        
        lmax[0] = arr[0]
        for i in range(1, len(arr)):
            lmax[i] = max(lmax[i-1], arr[i])
            
        rmax[n-1] = arr[n-1]
        for i in range(n-1)[::-1]:
            rmax[i] = max(rmax[i+1], arr[i])
        
        water=0
        
        for i in range(n):
            water+= min(lmax[i], rmax[i])-arr[i]
            
        return water
