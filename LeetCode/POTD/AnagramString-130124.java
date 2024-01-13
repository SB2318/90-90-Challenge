/***
 Problem Date: 13/01/24
 Problem Name: Minimum Number of Steps to Make Two Strings Anagram
 Problem Link: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
 Problem Category: String
*/

class Solution {
    public int minSteps(String s, String t) {
        
        /**Condition of Anagram : Both string will contain identical character. */
        /** Best Approach: Count the occurence of the characters and store it in array. */

        /** Tricky approach: instead of storing two string's character in two different array
        Store it in one array.
        For one source, incremnt the count and another source decrement your count.
         */

         /** At last if your array only contains 0,  strings are anagram */

          int n = s.length();

        int[] mp = new int[26];

        for (int i = 0; i < n; i++) {
            mp[s.charAt(i) - 'a']++;
            mp[t.charAt(i) - 'a']--;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            result += Math.max(0, mp[i]);
        }

        return result;
    }
}
