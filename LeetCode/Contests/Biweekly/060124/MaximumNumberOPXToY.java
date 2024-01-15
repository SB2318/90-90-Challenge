/**
  Problem Date: 06/01/2024
  Problem Name: Minimum Number of Operations to Make X and Y Equal
  Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/description/
  Problem Category: Queue, BFS, Graph, Nearest Path
*/

class Solution {
public int minimumOperationsToMakeEqual(int x, int y) {

/**
Approach this problem like minimum numbers of steps needed to reach from source to destination with every vertex having 4 possible paths as x+1, x-1, x/11 and x/5. (x/11 and x/5 needs condition check)
*/ 
  Queue<Integer> q = new LinkedList<>();
  int[] visited = new int[10001];
  Arrays.fill(visited,0);

/** Add Source */
  q.add(x);

  if(x==y){
      return 0;
  }

  int ans =0;

  while(!q.isEmpty()){
    
    /** Each element of this q is one destination from reaching x to y. */
      int n = q.size();

      while( n-- > 0){
         
         /** Extract the front element */
          int f = q.poll();

           /** Constraint limitation */
          if(f > 10000 || f <= 0){
              continue;
          }

          /** If you reach the destination. */
          if(f==y){
              return ans;
          }

    /**So from each number we get, we push the 4 numbers (x+1, x-1, x/5, x/11) into queue after checking the conditions. */
        /** Try to explore other destination */
        if(f%11 == 0 && visited[f/11] == 0){
             visited[f / 11] = 1;
             q.add(f / 11);
        }
      
        if (f % 5 == 0 && visited[f / 5] == 0) {
            visited[f / 5] = 1;
            q.add(f / 5);
        }

         if (f - 1 >= 0 && visited[f - 1] == 0) {
             visited[f - 1] = 1;
             q.add(f - 1);
           }
                
          if (f + 1 <= 10000 && visited[f + 1] == 0) {
              visited[f + 1] = 1;
              q.add(f + 1);
            }

      }

      ans++;
  }
    return ans;
 }
}