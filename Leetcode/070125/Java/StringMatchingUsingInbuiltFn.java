// Problem Link: https://leetcode.com/problems/string-matching-in-an-array/?envType=daily-question&envId=2025-01-07
/**
  See what I feel here, The same thing we can do using KMP, although for best practices
  you need to check the result using KMP instead of words[j].contains(words[i]).

  This is also acceptable. And Time complexity is the same. 
 */

class Solution {
    public List<String> stringMatching(String[] words) {
        // First O(n2)
        List<String> res = new ArrayList<>();

        for(int i=0; i<words.length; i++){

            for(int j=0; j<words.length; j++){

                if(i!= j && words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }
}

