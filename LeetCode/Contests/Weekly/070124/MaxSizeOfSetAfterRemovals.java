/**
  Problem Date: 07/01/2024
  Problem Name: Maximum Size of a Set After Removals
  Problem Link: https://leetcode.com/problems/maximum-size-of-a-set-after-removals/description/
  Problem Category: Basic Math, Set
*/
class Solution {
    public int maximumSetSize(int[] num1, int[] num2) {
  

        /** Set Difference */
        Set<Integer> set1= new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
       
        for(int num: num1){
            set1.add(num);
        }

        for(int num: num2){
            set2.add(num);
        }
        
         HashSet<Integer> common= new HashSet<>(set1);
         common.retainAll(set2);

         /** The maximum possible size of set is n */
         /** Our first target will be to remove the common elements from both array. */

         /** After removing all the common elements, our answer will be 
          the remaining size of set 1 and set2 */

    /**
Since we are not considering the common elements by subtracting ccc, and even then if they make a sum greater than nnn, then we have enough elements and we can safely keep any nnn elements from them in final set.

But if their sum is not reaching nnn, then we need to take help from common ccc elements. These elements can increase the final answer at most by c. In that case we can remove any n/2 elements.
    */ 
     
       int n1 = set1.size(), n2= set2.size(), c= common.size(), n= num1.length;

      return Math.min(n, Math.min(n1-c, n/2)+Math.min(n2-c, n/2)+c); 
      // we can take at most n/2 elements from each array 

    }
}