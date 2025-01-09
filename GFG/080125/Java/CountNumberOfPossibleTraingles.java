// Problem Link: https://www.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1

// Chota bhai of CountNumberOfTriplets, For beginners jarroor visit problem description
// Similar Problem Link:  https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
       Arrays.sort(arr);
       int count=0;
       for(int i=arr.length-1; i>=1; i--){
           
           int l=0, r= i-1;
           
           while(l<r){
               
               int sum = arr[l]+arr[r];
               
               if(sum > arr[i]){
                  count+= (r-l);
                  r--;
                 }
               else{
                   l++;
               }
           }
       }
       
       return count;
    }
}
