/**
   Problem Date: 16/01/2024
   Problem Name : Sequence of Sequence
   Problem Link: https://www.geeksforgeeks.org/problems/sequence-of-sequence1155/1
   Problem Category: Array, DP, Recursion

*/

/**
   Intuition: Mind it these four condition.
    (i) You can take any value up to M means if your current sequence element is x, then x ∈ [1,m]
    (ii) seqi+1 >= 2*seqi 
    (iii) seqi > 0
     (iv) seqi <= m

   Now, the approach is in the function try to follow the bottom-up and take-skip approach and try to fill the List of sequences from
    last, 
   First include M in your sequence, find the remaining sequence from [1, m/2], and reduce the length to n-1 as you already select one 
   element.  why m/2? because seqi+1 >= 2*seqi , i.e. semi < seqi+1/2

   Skip M, means not include m in your current sequence, now try to explore the number of sequences out of  [1,m-1] elements with
    fixed length n.
*/



class Solution{
    static int numberSequence(int m, int n)
    {

       // Base case:
     if (n == 0) {
        return 1; // must be an empty sequence with length 0
      }
        // Base case: if m is 0, there are no valid sequences
     if (m == 0) {
            return 0;  // we can't consider empty sequence here, n might not be 0, the case already covered.
     }
             
    return  numberSequence(m - 1, n) +  numberSequence(m / 2, n - 1);
    
}
       
}


