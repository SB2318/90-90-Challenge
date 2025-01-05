#problem_link: https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1

class Solution:
    def countTriplets(self, arr, target):
        # code here
        res=0
        n= len(arr)
        
        for i in range(len(arr)-2):
            left = i+1
            right = len(arr)-1
            
            while(left < right):
               sum = arr[i] + arr[left] + arr[right]
               
               if(sum == target):
                   res = res+1
               # count freuency
                 
                   start = left+1
                   end = right-1
                  
               
                   while start < right and arr[start] == arr[start-1]:
                         res+=1
                         start = start+1
                   while left < end and arr[end] == arr[end+1]:
                         end = end-1
                         res+=1
                   left+=1
                   right-=1
                         
                       
               elif(sum >target):
                    right= right-1
               else:
                 left = left+1
                    
                  
        
        return res
