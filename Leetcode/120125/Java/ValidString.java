// Problem Link: 
/**
To understand the problem better, let's focus on tracking open brackets and closed brackets
 and their relationship with the locked and unlocked positions.

 If locked[i] == '1', means the character fixed at this position for the string s,
 either is an open bracket, or either it is a closed bracket.
 locked[i] == '0', which means the character can be unlocked, based on the needs we can alter it.

 We need to determine if it's possible, to adjust the unlocked positions, to make the entire
 string valid.

 Now, the point is what do we have to track?

 In normal cases (In fact the here also, the stack solution already available in the editorial), we generally track open brackets, using stack ds.

 But here, do we need to track only the open bracket? As there is lock condition also, based on which we can alter the brackets.

 Then, we have to track, the maximum number of available open brackets (maxOpen), and also we have to track
 the minimum number of open brackets we need to make the string valid. (minOpen)

 But How?
 For each character in s, we will check two things, whether it is locked or unlocked.

 If it is unlocked:
   There are two possibilities:
    
    (a) We can have an unlock closing parenthesis, (b) we can have an unlock open parenthesis
    
    For the first case, to balance the closing parenthesis, we need an opening one, and it will
    be better to take it from minimum needs, that's why they are decrement the minOpen at
    every unlock position.
   ))()))  0100100
 */


class Solution {

   public boolean canBeValid(String s, String locked) {
       int n = s.length();
       int minOpen = 0, maxOpen = 0;
       for (int i = 0; i < n; i++) {
           if (locked.charAt(i) == '0') {
               maxOpen++;
              minOpen = minOpen == 0 ? 1 : minOpen - 1;
           } else {
               if (s.charAt(i) == '(') {
                   minOpen++;
                   maxOpen++;
               } else {
                   maxOpen--;
                   minOpen = minOpen == 0 ? 1 : minOpen - 1;
                   if (minOpen > maxOpen) {
                       return false;
                   }
               }
           }
       }
       return minOpen == 0; //  After complete validation there must not be any parenthesis left
   }
}
