// Problem Link: https://leetcode.com/problems/grid-game/description/
// Solution Link: https://www.youtube.com/watch?v=Y8VC_OnkazE

class Solution {
    public long gridGame(int[][] grid) {
      long firstSum =0;

      for(int num: grid[0]){
         firstSum += num;
      }

      long secondSum =0;
      long miniSum = Long.MAX_VALUE;

      for(int ti=0; ti<grid[0].length; ti++){
          firstSum -= grid[0][ti];

          miniSum = Math.min(miniSum, Math.max(firstSum, secondSum));

          secondSum += grid[1][ti];
      }

      return miniSum; 
    }
}
