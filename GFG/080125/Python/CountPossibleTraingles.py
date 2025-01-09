# Problem Link: https://www.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1

# Chota bhai of CountNumberOfTriplets, For beginners jarroor visit problem description
# Similar Problem Link:  https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1

class Solution:
    #Function to count the number of possible triangles.
    def countTriangles(self, arr):
        # code here
        arr.sort()
        count=0
        
        for i in range(len(arr))[::-1]:
            l,r=0,i-1
            while l<r:
                 if arr[l]+arr[r] > arr[i]:
                     count+=(r-l)
                     r-=1
                 else:
                     l+=1
        return count
