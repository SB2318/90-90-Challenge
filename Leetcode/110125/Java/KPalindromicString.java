// Problem Link: https://leetcode.com/problems/construct-k-palindrome-strings/?envType=daily-question&envId=2025-01-11
// Key Point:
// 1. Every single character string is palindrome
// 2. A string contains all even occurence of its character can be symmetric
// 3. A string contains all even occurence of its character except one can be symmetric
// 4. If every individual character can form a palindrome, then the maximum number of palindrome we can form is the length of the string

// From the above points it is clear that, to constuct k palindromes strings, we need 
// (i) at least k length strings
// (ii) at max k odd occuences, A palindrome can take only one odd occurences

class Solution {
    public boolean canConstruct(String s, int k) {

       if(s.length()< k)  return false;
       else if(s.length() == k) return true;

       int oddC = 0;
       int[] freq = new int[26];

       for(char c: s.toCharArray())
          freq[c-'a']++;

       for(int i: freq)
          if(i%2 == 1) oddC++;

       return oddC <=k;
  
    }
}
