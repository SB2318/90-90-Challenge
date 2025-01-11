// Problem Link: https://leetcode.com/problems/word-subsets/?envType=daily-question&envId=2025-01-10

/**
 Intution: Understanding the problem statement is the key 
 Problem Explanation:
You are given two list of words, words1 and words2

words1 -> A list from which you need to find the universal words
words2 -> A list of word that defines the requirement
A word in words1, considered universal, if for every word in words2,  it contains at least the same number of each character that appears in that word.

It might be confusing, let's simplify the statement.
If a word in words2 has 2 occurences of letter 'a', then any universal word of words1 must contain at least 2 'a'. same for all.

So, our first target is to find the max freequency of each character ('a' to 'z') in words2 array.
Then you have to find whether any word in words1 array matches the requirement or not.

*/

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

       int[] bmax = new int[26];

       for(String word: words2){

          int[] bcount = count(word);

          for(int i=0; i<26; i++){
            bmax[i] = Math.max(bcount[i], bmax[i]);
          }
       }
   
       List<String> res = new ArrayList<>();

       for(String word: words1){

          int[] acount = count(word);
           boolean flag = true;
          for(int i=0; i<26; i++){

            if(acount[i] < bmax[i]){
                flag=false;
                break;
            }      
          }

          if(flag) res.add(word);
       }

       return res;
    }

    public int[] count(String s){

        int[] ans = new int[26];

        for(char a: s.toCharArray()){
            ans[a-'a']++;
        }

        return ans;

    }
}
