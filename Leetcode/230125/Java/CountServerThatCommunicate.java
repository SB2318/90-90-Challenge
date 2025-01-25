// Problem Link: https://leetcode.com/problems/count-servers-that-communicate/description/?envType=daily-question&envId=2025-01-23
// Intuition: Track the server count of each row and each column, 
//If any row or any columns contain more than one server then they can communicate with each other
// Lastly, for each 1 (means present server we are checking whether they can communicate or not)

class Solution {
    public int countServers(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        for(int i=0; i<rows; i++){

            for(int j=0; j<cols; j++){

                if(grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int serverCount = 0;
        // The server can communicate with each other if and only if they lie in same page 
        // sorry for the fun, means only if they are in same row or same columns

        for(int i=0; i<rows; i++){

            for(int j=0; j<cols; j++){

                if(grid[i][j] == 1 && (rowCount[i] > 1  || colCount[j] > 1))
                // why greater than 1? communicate karne walla koi hona chahiye na
                    serverCount++;
            }
        }

        return serverCount;
    }
}
