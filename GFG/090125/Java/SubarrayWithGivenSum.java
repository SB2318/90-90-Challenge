// Problem Link: https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
// Intution: Sliding Window


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) 
    {
        // Your code here
        int currentSum = 0, start = 0, i;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Pick a starting point
        for (i = 0; i < n; i++) {
             currentSum = currentSum + arr[i];
            // If currentSum exceeds the sum,
            // then remove the starting elements
            while (currentSum > sum && start < i) {
                currentSum = currentSum - arr[start];
                start++;
            }
 
            // If currentSum becomes equal to sum,
            // then return true
            if (currentSum == sum) {
               
                result.add(start+1);
                result.add(i+1);
                return result;
            }

               
    }
    result.add(-1);
    return result;
    }
}
