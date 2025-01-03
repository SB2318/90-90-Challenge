# problem_link: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1

class Solution:
    def subarrayXor(self, arr, k):
        # code here
        currXor =0
        map = {}
        ans=0
        for ele in arr:
            currXor^=ele
            if(currXor == k):
                ans+=1
            z= currXor^k
            
            if(z in map):
                ans+= map[z]
            map[currXor] = map.get(currXor,0)+1
            
        return ans
