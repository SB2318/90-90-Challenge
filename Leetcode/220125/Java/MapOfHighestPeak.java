// Problem Link: https://leetcode.com/problems/map-of-highest-peak/description/?envType=daily-question&envId=2025-01-22
// Solution Link: https://www.youtube.com/watch?v=nQe5OBs0FgQ

// Intution: Multisource BFS

// To solve this question, Prerequisite: A clear and conceptual understanding of QUEUE DS
// BFS from all 0 cells at the same time
//Your queue will look like 0,0,0,0,0,1,2...
// Means try to visualize the things,
// First what are you doing, in the array traversal, you are adding every water element as 0 in the queue, right?
// Then comes to queue traversal, where you are starting from 1st layer,
// Means, that all the 0 cells come in the first layer of the queue, and their corresponding cells will be already visited and assigned to 1 (Initially they are not visited, means -1). 
// Amazing problem, Feeling good to learn the concept.

class Solution {
    public int[][] highestPeak(int[][] isWater) {

        int[][] dirs = {{0,1},{0,-1}, {1,0}, {-1,0}};

        int rows = isWater.length;
        int cols = isWater[0].length;

        Queue<int[]> cellsQueue = new LinkedList<>();
        int[][] cells = new int[rows][cols];

       for(int[] cell: cells)
         Arrays.fill(cell, -1);

       // add all the cells, which are already  0
        for(int i=0; i<rows; i++){

            for(int j=0; j<cols; j++){

                if(isWater[i][j] == 1){
                    cells[i][j] = 0;
                    cellsQueue.add(new int[]{i,j});
                }
            }
        }
       int layer =1;

       while(!cellsQueue.isEmpty()){

           int size = cellsQueue.size();

           for(int i=0; i<size; i++){
               int[] element = cellsQueue.poll();

               int x = element[0];
               int y = element[1];

               for(int[] dir: dirs){
                 
                  int x1 = x + dir[0];
                  int y1 = y + dir[1];

                  if(isValid(x1, y1, cells) && cells[x1][y1] == -1){
                      cells[x1][y1] =layer;
                      cellsQueue.add(new int[] {x1, y1});
                  }
               }
           }

           layer++;
       }

      return cells;
    }

    private boolean isValid(int x, int y, int[][] cells){

        return x>=0 && y>=0 && x<cells.length && y< cells[0].length;
    }
}



