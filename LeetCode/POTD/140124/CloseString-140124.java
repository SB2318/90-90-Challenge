/**
 Problem Date: 14/01/24
 Problem Name: Determine if Two Strings Are Close
 Problem Link: https://leetcode.com/problems/determine-if-two-strings-are-close/description/
 Problem Category: String, Sorting
*/

class Solution {
    public boolean closeStrings(String word1, String word2) {

      /** Intution :  Two strings contains same characters, but count will different. */ 
      /** Intution 2: You can transform every occurence */
      /** Check length of the strings are equal or not. */

      if(word1.length() != word2.length()){
          return false;
      }

      int[] freq1 = new int[26];
      int[]  freq2 = new int[26];

      for(char c: word1.toCharArray()){
           freq1[c-'a']++;
       }

        for(char c: word2.toCharArray()){
           freq2[c-'a']++;
       }

       /** Check whether this string already contains some dissimilar char or not. */
       for(int i=0; i< 26; i++){

           if((freq1[i] == 0 && freq2[i] != 0) || (freq2[i] == 0 && freq1[i] != 0) ){
               return false;
           }
       }
       Arrays.sort(freq1);
       Arrays.sort(freq2);

       for(int i=0; i<26; i++){
           
         
           if(freq1[i] != freq2[i]){
               return false;
           }
       }
       return true;
    }
}
