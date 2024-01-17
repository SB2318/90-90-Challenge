/**
   Problem Date: 18/01/2024
   Problem Name : Unique Number of Occurrences
   Problem Link:  https://leetcode.com/problems/unique-number-of-occurrences/
   Problem Category: HashMap, Set, Array

*/


class Solution {
    public boolean uniqueOccurrences(int[] arr) {
      
       HashMap<Integer, Integer> counter = new HashMap<>();
       HashSet<Integer> set = new HashSet<>();
    
      for(int i: arr)
         counter.put(i, counter.getOrDefault(i,0)+1);

      for(int i: counter.keySet()){

          if(set.add(counter.get(i)) == false){
              return false;
          }
      }

      return true;
    }
}

/** Constraint Specific 
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
      
      
      int[] counter = new int[2001];
    
      for(int i=0;  i<arr.length; i++){
          
           counter[1000+arr[i]]++;
      }

      Arrays.sort(counter);

      for(int i=1; i<counter.length; i++){

          if(counter[i] != 0 && (counter[i] == counter[i-1])) {
              return false;
          }
      }

      return true;
    }
}