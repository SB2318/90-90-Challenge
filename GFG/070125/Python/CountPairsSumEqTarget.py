# Problem Link: https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1
# Similar problem with solution: https://github.com/SB2318/90-90-Challenge/tree/main/GFG/040125

class Solution:
    def countPairs (self, arr, target) : 
        #Complete the function
        arr.sort()
        l,r= 0, len(arr)-1
        count=0
        
        while l<r:
            sum= arr[l]+arr[r]
            
            if sum> target: r-=1
            elif sum< target: l+=1
            else:
                count+=1
                start, end = l+1, r-1
                while start<r and arr[start]== arr[start-1]:
                     count+=1
                     start+=1
                while l<end and arr[end] == arr[end+1]:
                      count+=1
                      end-=1
                      
                l+=1
                r-=1
                
        return count

