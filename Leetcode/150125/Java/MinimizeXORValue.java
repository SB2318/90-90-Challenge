// Problem Link: https://leetcode.com/problems/minimize-xor/submissions/1510323719/?envType=daily-question&envId=2025-01-15
/**
 Intution:
Question Requirements: We have to find x,
(i) x has the same number of set bits as num2, and
(i) The value x XOR num1 is minimal.

 To get a minimal XOR value between two numbers, you have to ensure that
The XOR value between two numbers is minimal. (as per the question requirements)
 */

class Solution {
    public int minimizeXor(int num1, int num2) {

      int result=0;
      int bitsInNum2 = countSetBits(num2); 
      int c=0;

      for(int i=31; i>=0;i--){

        // check if ith bit of num1 is set or not
        if ( ((1 << i) & num1) !=0 || (bitsInNum2-c)>i) {
        // set the bit of result
            result |= (1 << i);
             c++;
       }

        if(c>= bitsInNum2) break;
      }

      return result;
    }

    private int countSetBits(int num){

        int count=0;

        while(num>0){
            num= num&(num-1); // It will unset first set bit
            count++;
        }

        return count;
    }
    
}
