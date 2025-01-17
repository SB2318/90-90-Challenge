// Problem Link: https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1

// Intuition:
// Product Except Self: Nice Problem
// The intuition is, first calculate the prefix product, at first it is initialized with 1, except arr[0], its prefix product will be 1,
// Then it is calculating the prefix product... and so on
// Similar try to collect suffix product, and similar the element will not add, we will first update res array, followed by we update suffix variable.

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int[] res = new int[arr.length];
        
        int prefix=1;
        
        for(int i=0; i<arr.length; i++){
            res[i] = prefix;
            prefix*= arr[i];
            
        }
        
        int suffix=1;
        
        for(int i=arr.length-1; i>=0; i--){
            
            res[i] *= suffix;
            suffix *= arr[i];
        }
        
        return res;
    }
}
