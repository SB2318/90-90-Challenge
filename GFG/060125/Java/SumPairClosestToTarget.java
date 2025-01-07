// Problem Link: https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/1

/**
There was one tricky part in this question. 
Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: 
As (4, 7) and (2, 7) both are closest to 10, the absolute difference of (2, 7) is 5 and (4, 7) is 3. 
Hence, [2, 7] has maximum absolute difference and is closest to the target. 

But here I am checking only the absolute difference between target and sum.

 if(d< diff){
    diff = d;
    start = arr[l];
    end = arr[r];
  }

 As we are taking l from 0, and r (n-1).. so from the first we are taking the lowest possible value of l and the highest possible value of r.
 The second point is the array is already sorted, which means the left-to-right array always increasing.

The third point is once, we get the smaller diff, we further do not update the diff variable.

Now, the last point is you have to check the code flow. 
*/

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        
        if(arr.length < 2){
            return new ArrayList<>();
        }
        int l=0, r= arr.length-1;
        
        int start= arr[0], end =arr[arr.length-1], diff= Integer.MAX_VALUE;
        while(l<r){
           
           int sum = arr[l] +arr[r];
           
           int d = Math.abs(target-sum);
           
           if(d< diff){
               diff = d;
               start = arr[l];
               end = arr[r];
           }
           
           if(sum > target) r--;
           else l++;
           
        }
        
        List<Integer> res = new ArrayList<>();
        
        res.add(start);
         res.add(end);
        return res;
    }
}

