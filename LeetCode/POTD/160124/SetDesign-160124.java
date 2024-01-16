/**
   Problem Date: 16/01/2024
   Problem Name :  Insert Delete GetRandom O(1)
   Problem Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
   Problem Category: Data Structure Design

*/

/** Approach 1 */

class RandomizedSet {

    private ArrayList<Integer> set = new ArrayList<>();
  
    public RandomizedSet() {
         
    }
    
    public boolean insert(int val) {
        
          if(set.contains(val)){
              return false;
          }else{
              set.add(val);
              return true;
          }
    }
    
    public boolean remove(int val) {
        
        if(set.contains(val)){
            /** remove(Object obj) */
              set.remove(Integer.valueOf(val));
              return true;
          }else{ 
               return false;
          }
    }
    
    public int getRandom() {
        
        /** Generate a random number */
         int rnd = new Random().nextInt(set.size());
        return set.get(rnd);
       
    }
}

/** Approach 2: */

class RandomizedSet {
    
    private Map<Integer, Integer> valueToIndexMap; 
    private ArrayList<Integer> set;
  
    public RandomizedSet() {
         set = new ArrayList<>();
         valueToIndexMap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        
      //    if(set.contains(val)){
        if(valueToIndexMap.containsKey(val)){ // takes less time for execution
              return false;
          }else{
              set.add(val);
              valueToIndexMap.put(val, val); // set.size()-1 denotes the current idx
              return true;
          }
    }
    
    public boolean remove(int val) {
        
       // if(set.contains(val)){
           if(valueToIndexMap.containsKey(val)){  // takes less time for execution
            /** remove(Object obj) */
              set.remove(Integer.valueOf(val));
              valueToIndexMap.remove(val);
              return true;
          }else{ 
               return false;
          }
    }
    
    public int getRandom() {
        
        /** Generate a random number */
         int rnd = new Random().nextInt(set.size());
        return set.get(rnd);
       
    }
}