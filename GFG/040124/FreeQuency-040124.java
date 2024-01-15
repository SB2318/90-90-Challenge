/**
  Date: 04/01/2024
  Problem Name: Find element occuring once when all other are present thrice
  Problem Category: Array, DSA
  Problem Description: 
  Given an array of integers arr[] of length N, every element appears thrice except for one which occurs once.
  Find that element which occurs once.
  Task & Constraints:
  You task is to complete the function singleElement() which takes an array of integers arr and an integer N 
  which finds and returns the element occuring once in the array.

   Constraints:
   1 ≤ N ≤ 105
  -109 ≤ A[i] ≤ 109

   Expected Time Complexity: O(N).
   Expected Auxiliary Space: O(1).
*/

class Solution {
    
    static int singleElement(int[] arr , int N) {
        // code here
        
        /** Expected Time Complexity is O(N). So, traverse to karna padega,
        ab dekhna hai kaise efficiently hum ye karenge */
        
        /**
           Learning Scope : How can we store the freequency of elements in an array without using extra space..
           Article: https://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time/
        */
        /**
          Best Solution : Use HashMap
         */
        
        if(arr.length==1){
            return arr[0];
        }
        Arrays.sort(arr);
        
         /** Check for first & last element */
        if(arr[0]!= arr[1]){
            return arr[0];
        }
        else if(arr[N-2]!=arr[N-1]){
            return arr[N-1];
        }
        
        for(int i=1; i<N-1; i++){
            
            if( i<N-1 && (arr[i] != arr[i-1] && arr[i]!= arr[i+1])){
                return arr[i];
            }
        }
        
        return -1;
        
    }
}
