// Problem Link: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/?envType=daily-question&envId=2025-01-18

// Intution:
// This is a famous type of problem, like "iss problem ka kya naam du"
// (i) Cost Estimation with dp
// (ii) Khandani Template of backtracking with 2D Movements (Directions)
// (iii) Proper utilization  of Djkstra and Graph Concept.. etc
// Solution Link: MIK Bhaiya :) https://www.youtube.com/watch?v=NS3C4W_jJJM

 class Pair {

       int source, dest, cost;

       public Pair(int source, int dest, int cost){
           this.source = source;
           this.dest = dest;
           this.cost = cost;
       }
    }

class Solution {
    public int minCost(int[][] grid) {

       int n = grid.length;
       int m = grid[0].length;
       PriorityQueue<Pair> pq = 
       new PriorityQueue<>(Comparator.comparingInt(pair -> pair.cost));

       int[][] res = new int[n][m];

       for(int[] a: res){
        Arrays.fill(a, Integer.MAX_VALUE);
       }
       res[0][0] =0;

       int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}} ; // R,L,U,D ->1, 2, 4, 3
       pq.offer(new Pair(0,0,0));

       while(!pq.isEmpty()){

           Pair pair = pq.poll();

           int i= pair.source;
           int j= pair.dest;
           int currCost = pair.cost;
         

           for(int k=0; k<dir.length; k++){
      
            int i1= i+ dir[k][0];
            int j1= j+ dir[k][1];

            if (i1<0 || j1<0 || i1>=grid.length || j1>=grid[0].length){
                continue;
            }
            int dirCost = 0;

            if((grid[i][j] == 1 && k!=0) || (grid[i][j] == 2 && k!=1) ||
              (grid[i][j] == 3 && k!=3) || (grid[i][j] == 4 && k!= 2)){
                dirCost = 1;
             }

              int newCost = currCost+dirCost;
           
              if(newCost < res[i1][j1]){
                res[i1][j1] = newCost;
                pq.offer(new Pair(i1, j1, newCost));
              }
           }

        }

        return res[n-1][m-1];
       }

}
