# Problem Link: https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
# Intution: 
# According to the requirement, you have to check for each index, whether the left sum equal to the right sum or not.
# Here in the code, first calculate the total sum, 
# Then for each index, substract the current element, check if the left sum equal to right sum or not.

# Important Variables: 

# ls => This keeps track of the sum of elements to the left of the current index.
# rs => This keeps track of the sum of elements to the right of the current index.

class Solution:
    #Function to find equilibrium point in the array.
    def findEquilibrium(self, arr):
        # code here
        ls=0
        rs=0
        
        for i in range(len(arr)):
            rs += arr[i]
        for i in range(len(arr)):
            rs-=arr[i]
            if ls == rs:
                return i
            ls+= arr[i]
        return -1
