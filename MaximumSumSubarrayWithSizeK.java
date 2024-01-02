/*** 
 
Date: 02/01/2024

Problem Title: Maximum Sum Subarrray with at least size K
Problem Description : Given an array a of length n and a number k, find the largest sum of the subarray containing at least k numbers. It is guaranteed that the size of array is at-least k.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxSumWithK() which takes the array a[], its size n and an integer k as inputs and returns the value of the largest sum of the subarray containing at least k numbers.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105
-105 <= a[i] <= 105
1 <= k <= n

*/

class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        /** Enhancement of Maximum Sum subarray or maximum sum of circular subarray, here we also have to be maintain 
        the size  k*/
        
        /** First determine some known variable */
        long result= Long.MIN_VALUE;
        long sumUptoK=0;
        
        /** First Determine Sum of the elements upto k size */
        for(int i=0; i<(int) k; i++){
            sumUptoK+= a[i];
        }
        
        /** Update the result. */
        result = Math.max(result, sumUptoK);
        /** May be upto k index, the array contains some negative index, which may causes wrong result. */
        
        /** Keep track of the negative value. */
        long prevSum=0;
        int index=0;
        
        /** Now try to determine the sum of the rest element after k */
        
        for(int i=(int)k; i<a.length; i++){
            
            sumUptoK += a[i];
            result = Math.max(result, sumUptoK); 

          
            prevSum+= a[index];
            index++;
            
            /** Now check whether prevSum less than 0 or not. */
            
            if(prevSum < 0){
                
                /** remove those sum */
               /** Don't worry about how much Item  you remove from the array, because you are adding those much amount elements in each   iteration.*/
                sumUptoK -= prevSum;
                result = Math.max(result, sumUptoK);
                
                /** Assign the previous sum to 0 to determine next index*/
                prevSum=0;
                
            }
            
          
        }
         return result; 
    }
}
