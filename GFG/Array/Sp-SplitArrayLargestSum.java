/**
   Problem Date: 07/01/2023
   Problem Name: Split Array Largest Sum
   Problem Link: https://www.geeksforgeeks.org/problems/split-array-largest-sum--141634/1
   Problem Category: Array, DSA, Binary Search
*/

class Solution {
    
    static int splitArray(int[] arr , int N, int K) {
        // code here
        
         /** Find a range of [min_possible_sum_subarray_among_all_subarrays, min_possible_sum_subarray_among_all_subarrays] */
         
         /***
          *  min_possible_sum_subarray_among_all_subarrays = [largest_element_in_arr]
          *  max_possible_sum_subarray_among_all_subarrays = [total_sum] 1 ≤ arr[i] ≤ 104  for all arr[i] >0
          * 
          */
          
          int max=Integer.MIN_VALUE, total =0;
          
      
          for(int i=0; i<N; i++){
              
              if(arr[i] > max){
                  max= arr[i];
              }
              
              total += arr[i];
          }
          
         int low= max, high = total; // for later understanding purpose
        
        
          /** now do a binary search between this range, check whether k subarrays possible or not by considering each element 
           * as minimum sum or not, return the lowest_bound. */
           
           int result= 0;
           while(low <= high){
               
               int mid= (low+high)/2;
               int partitions = getPartitionsNumber(mid,N, arr);
               
               if(partitions > K){
                   low= mid+1;
                   // result = mid;
               }else{
                    result = mid;
                    high= mid-1;
               }
               
           }
           
           return result;
    }
    
    
   static int getPartitionsNumber(int element, int N, int[] arr){
       
        /** Logic Inspiration: Striver Bhaiya */
         int currSum=0;
         int count=1; //This initialization ensures that the algorithm starts with the assumption of at least one partition (the whole array I guess, because element < total always)
         
         for(int i=0; i< N; i++){
             
             if(currSum+arr[i] <= element){
                 currSum += arr[i];
             }else{
                 count++;
                 currSum = arr[i];
             }
         }
       
        return count;
   }
};
