// Problem Link: https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1
// Similar problem with solution: https://github.com/SB2318/90-90-Challenge/tree/main/GFG/040125

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        Arrays.sort(arr);
        int l=0, r= arr.length-1;
        int count=0;
        
        while(l<r){
            
            int sum = arr[l]+arr[r];
            
            if(sum== target){
                count++;
                
                int start = l+1, end = r-1;
                
                while(start<r && arr[start]== arr[start-1]){
                    count++;
                    start++;
                }
                while(l<end && arr[end] == arr[end+1]){
                    count++;
                    end--;
                }
                l++;
                r--;
            }
            else if(sum > target) r--;
            else l++;
        }
        
        return count;
    }
}
