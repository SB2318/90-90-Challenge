/**
  Problem Date: 12/01/24
  Problem Name:  Determine if String Halves Are Alike
  Problem Link: https://leetcode.com/problems/determine-if-string-halves-are-alike/
  Problem Category: String
*/

class Solution {
    
    Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
  
    public boolean halvesAreAlike(String s) {
        
      /** Two Pointer approach */
      int i=0, j= s.length()-1, countLeft=0, countRight=0;

       while(i<j){

           if(isVowel(s.charAt(i)))
            countLeft++;
          if(isVowel(s.charAt(j)))
            countRight++;

         i++;
         j--;
       }

      return countLeft == countRight;
    }

    private boolean isVowel(char c){
        return set.contains(c);
    }
}
