/**
  Problem Date: 14/01/24
  Problem Name: Find duplicate rows in a binary matrix
  Problem Link: https://www.geeksforgeeks.org/problems/find-duplicate-rows-in-a-binary-matrix/1
  Problem Category: Array, DSA, Bit-Manipulation

*/


/*** Approach 1 : Easy Approach: Conevert Row into String */

class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        //code here
        Set<String> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        
         StringBuilder sb = new StringBuilder();
         
        for(int i=0; i<matrix.length; i++){
            
           
            for(int j=0; j< matrix[i].length; j++){
                
                sb.append(matrix[i][j]);
            }
            
            if(set.contains(sb.toString())){
                result.add(i);
            }else{
                set.add(sb.toString());
            }
           sb.setLength(0); 
        }
       return result; 
    }
}

/*** Approach 2: Tricky Approach: Add Rows element as binary integer | Efficient use of OR operator */


/**
   Intuition: 
    OR operator can be used to set an unset bit.
    If you doing OR operation on some number with another number then there will be two cases.
    case 1: If both bits are unset at any position, the result bit remains unset at that position.
    case 2: If one of the bit is set, then the result bit will be set at that position.

  Left Shift Operator:
   Left shift by one position means you are multiplying this number with 2 as long as you are in 32-bit or 64-bit OS.
   ans << 1 == ans*2. ( In binary form, adding one 0 at last)
*/

class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        //code here
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        
         
        for(int i=0; i<matrix.length; i++){
            
           
            int val = convertRows(matrix[i]);
            
            if(set.contains(val)){
                result.add(i);
            }else{
                set.add(val);
            }
           
        }
       return result; 
    }

   /*** 
     This convert row function will convert each row element as it's integer form, like [1,0,1,0,1] will be returned as 10101.
        For this here we are using OR & Left Shift Operator.
       Left shift to increase the position by 1 place for new row array element, like 1,10, 100, 1000.
       OR operator to set the row array element at that position.
        If it is unset (0), no changes will happen.
        If set, then bit position will be set.
       At last, this method will return the binary number. (Remember this 2D array only contains binary elements.)
    */
    static int convertRows(int [] row){
        
        int ans=0;
        
        for(int i : row){

             /*** If it is little bit hard to understand, only mind it */
            ans = (ans << 1) | i; // This is the formula to append the new row array element at the end of the answer.
        }
        
        return ans;
    }
}


