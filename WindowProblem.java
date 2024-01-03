/***

   Problem Date: 03/01/2024
   Problem Name: Smallest window containing 0, 1 and 2
   Problem Category : String, Sliding Window, Algorithm
   Problem Description: Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 
   0, 1 and 2. If no such substring exists, then return -1.

   Task & Constraints:
   Complete the function smallestSubstring() which takes the string S as input, and returns the length of the smallest substring of string S that contains all the three characters 0, 1 and 2.

   Expected Time Complexity: O( length( S ) )
   Expected Auxiliary Space: O(1)

   Constraints:
   1 ≤ length( S ) ≤ 105
   All the characters of String S lies in the set {'0', '1', '2'}

*/

class Solution {
    public int smallestSubstring(String S) {
        // Code here
    
        int i0=-1, i1=-1, i2=-1;
        int result= Integer.MAX_VALUE;
        
        for(int i=0; i<S.length(); i++){
            
            /*** Iteration is important to change the window */
            if(S.charAt(i) == '0'){
              i0 =i;  
            }
            else if(S.charAt(i) == '1'){
              i1 = i;  
            }
            else if(S.charAt(i) == '2'){
              i2= i;  
            }
            
            /** Most Important Part */
            
            if(i0 != -1 && i1 != -1 && i2 != -1){
                    
            int minIndex= Math.min(Math.min(i0,i1),i2);
            int maxIndex= Math.max(Math.max(i0,i1),i2);
           
             result= Math.min((maxIndex-minIndex)+1,result);
            }
        }
        
        return result == Integer.MAX_VALUE?-1:result;
    }
    };
