/**
  Problem Date: 06/01/2024
  Problem Name: Count the Number of Powerful Integers
  Problem Link: https://leetcode.com/problems/count-the-number-of-powerful-integers/
  Problem Category: Mathematics, Permutation and Combination, Prefix Sum Technique, Recursion, Algorithm
*/

class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        
        /** First Iterate through the digit of s, If any digit itself is greater than 
        limit,  return 0, the suffix needs to be there at the end.*/
        for(int i=0; i< s.length(); i++){

            int item = Integer.parseInt(s.charAt(i)+"");
            if(item > limit){
                return 0;
            }
        }

        /** Invertible operation use prefix sum technique */
         /** [start, finish] =  upto_finish - upto_(start-1) */

         return calculatePowerfulInt(finish,limit,s) - calculatePowerfulInt(start-1, limit, s);

    }

    private long calculatePowerfulInt(long highest, long limit, String suffix){

        String highestStr= String.valueOf(highest);
        /** If highest less than suffix, there will be no answer */
        if(highest < Long.parseLong(suffix)){
            return 0;
        }
        /** If  highest == suffix, return 1, we have checked previously all digits
         in suffix less than limit.*/
        else if (highestStr.length() == suffix.length() ){
            return 1;
        }
        else{
            
            /** If the first digit we are encountering is more than the limit
             every position, we can place [0...limit] value -> (limit+1)
             
             But we have to preserve the suffix part also,
             For remaining digit place apply Permutation and combination technique*/
           if(highestStr.charAt(0)- '0'  > limit){
               return power(limit+1, limit+1, highestStr.length() - suffix.length() -1);
           }else{

               /** First digit is less than limit,
               So, first we calculate the powerful numbers for that particular string,
               then we call the function for remaining part from substr(1) */
               /** For first digit we only have [0..first_digit] choices */
          return 
          power(highestStr.charAt(0)- '0', limit+1, highestStr.length() - suffix.length() -1 )
           + calculatePowerfulInt(Long.parseLong(highestStr.substring(1)),limit, suffix);
           }
        }
        
    }

    private long power( long first, long limt, long numOfDigits){

        long result = (long) Math.pow(limt, numOfDigits);

        return result*first;
    }
}