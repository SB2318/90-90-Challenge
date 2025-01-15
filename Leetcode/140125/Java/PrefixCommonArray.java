// Problem Link: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/?envType=daily-question&envId=2025-01-14

// Beginner friendly solution
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int[] count = new int[A.length];

        for(int i=0; i<A.length; i++){

            setA.add(A[i]);
            setB.add(B[i]);

            int c=0;

            for(int ele: setA){

                if(setB.contains(ele))
                  c++;
            }
            count[i] = c;
        }

        return count;
        
    }
}
