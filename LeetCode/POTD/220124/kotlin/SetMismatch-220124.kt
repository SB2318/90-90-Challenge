/**

   Problem Date: 22/01/24
   Problem Name: Set Mismatch
   Problem Link: https://leetcode.com/problems/set-mismatch/
   Problem Category: Array, Set

*/

class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        
        val set = HashSet<Int>()
        val totalSum = (nums.size*(nums.size+1))/2
        var duplicate=0
        var sum=0
        for(i in nums){
           
            if(!set.add(i)){
                duplicate=i
            }
            sum+=i
        }

        return intArrayOf(duplicate, totalSum-sum+duplicate)
    }
}