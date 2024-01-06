/**
  Date: 06/01/2024
  Problem Name: Techfest and the Queue
  Problem Category: Mathematics
  Problem Link: https://www.geeksforgeeks.org/problems/techfest-and-the-queue1044/1
 

  Expected Time Complexity: O( b*log(b) )
  Expected Space Complexity: O( b*log(b) )

  Constraints:
  1 <= a <= b <= 2x105
  1 <= b-a <= 105

*/



class Solution {
    public static long sumOfPowers(long a, long b) {
        
        
        
        // code here
        
        // Base Problem : Print all the prime factors of a given number in sorted order
        long result=0;
        
        for(long i=a; i<=b; i++){
            
            result += countPrimeFactor(i);
        }
        return result;
    }
    
    
    /** It is one by one taking out the prime factors and their powers and printing those prime factors
       28 -> 2^2 *7^1
    */
    
    private  static long countPrimeFactor(long n){
        
        if(n<=1){
            return 0;
        }
        long count=0;
        
        for(int i=2; i*i<=n; i++){
            
            while(n%i==0){
                count++;
                n=n/i;
            }
        }
        
        if(n>1){
            count++;
        }
        
        return count;
    }
}