// Problem Link: https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1
// Similar Problem: https://github.com/SB2318/90-90-Challenge/blob/main/GFG/100125/Java/CountDistinctElements.java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashSet<Character> set = new HashSet<>();
        
        int left=0, maxSoFar =0;
        
        for(int right=0; right<s.length(); right++){
            
             while(set.contains(s.charAt(right))){
                 set.remove(s.charAt(left));
                 left++;
             }
             
             set.add(s.charAt(right));
             
             maxSoFar = Math.max(maxSoFar, right-left+1);
        }
        
        return maxSoFar;
    }
}

// geeksforgeeks
