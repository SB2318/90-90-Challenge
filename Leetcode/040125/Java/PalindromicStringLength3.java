// Problem Link: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/?envType=daily-question&envId=2025-01-04

/**
Intuition:
What do you mean by palindrome? 
(i) str = str.reverse()
(ii) The first character and last character should be the same.

Take things one by one.
The first target is, to check the first and last occurrence of each character.
How can we store it?

The easiest way is to take two arrays, one will contain the indices, which denote the 
the first occurrence of the character in the string.
Another array will store the last occurrence of the character in the string.


When you finish the fill-up process., again look back to achieve the first.

Now here is one mystery, they need subsequences, not substring.

What are subsequences?

A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same order as they appear in the array. For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4].

Now your task is to build those palindromic strings with each possible character.
And you already know the first and last occurrence of every present character.

So, you need to find between unique characters. A set will be helpful for you in that case. 

As the palindrome sring length is 3, and you already know the two character, so the third character will be the each of the unique character in between them.

 */


class Solution {
    public int countPalindromicSubsequence(String s) {
       int[] first = new int[26];
       int[] last = new int[26];

       Arrays.fill(first, -1);

      // Store the first and last occurence of every character
       for(int i=0; i<s.length(); i++){

        int a = s.charAt(i) - 'a';

        if(first[a] == -1){
            first[a] = i;
        }

        last[a] = i;
       }

      int ans =0;

      for(int i=0; i<26; i++){

          if(first[i]== -1){
            // character is not present in the screen
            continue;
          }

          Set<Character> between = new HashSet<>();

          for(int j= first[i]+1; j<last[i]; j++){
            between.add(s.charAt(j));
          }

        // It will take all unique character in between first and last occurence of that 
        // particular character
          ans += between.size();
      }

     return ans;
    }
}
