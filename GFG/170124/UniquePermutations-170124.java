/**
   Problem Date: 17/01/2024
   Problem Name : All Unique Permutations of an array
   Problem Link:  https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
   Problem Category: Recursion, Backtracking

*/

class Solution {
    
     
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code hereGiven an array arr[] of length n. Find all possible unique permutations of the array in sorted order. A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.
          ArrayList<ArrayList<Integer>>  result= new ArrayList<>();
          HashSet<ArrayList<Integer>> set = new HashSet<>();
          solve(arr,0,result,set);
          
          
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                
                /** Customize with your logic */
                for(int i=0; i<list1.size(); i++){
                    
                    if(list1.get(i)!= list2.get(i)){
                        return Integer.compare(list1.get(i),list2.get(i));
                    }
                }
                
                return Integer.compare(list1.get(0),list2.get(0));
            }
        });
          
          return result;
    }
    
     static void solve(ArrayList<Integer> arr, int index, ArrayList<ArrayList<Integer>> result, HashSet<ArrayList<Integer>> set){
        
          if(index == arr.size()){
              
              if(!set.contains(arr))
               result.add(new ArrayList<>(arr));
               set.add(new ArrayList<>(arr));
               
              return;
          }
          
      
          
          for(int i=index; i<arr.size(); i++){
              
           
             // Swap
            int temp= arr.get(index);
            arr.set(index,arr.get(i));
            arr.set(i,temp);
           
            solve(arr, index+1,result,set);
            
            // Backtrack
            temp= arr.get(index);
            arr.set(index,arr.get(i));
            arr.set(i,temp);
                 
         }
          
    }
};