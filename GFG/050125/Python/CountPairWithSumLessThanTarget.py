// Problem Link: https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-less-than-target/1

class Solution:
    #Complete the below function
    def countPairs(self, arr, target):
        #Your code here
        arr.sort()
        l=0
        r= len(arr)-1
        cnt=0
        while(l<r):
            if(arr[l]+arr[r] < target):
                cnt+= (r-l)
                l+=1
            else:
               r-=1
        return cnt
