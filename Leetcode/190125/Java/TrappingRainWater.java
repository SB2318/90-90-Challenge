// Problem Link: https://leetcode.com/problems/trapping-rain-water-ii/?envType=daily-question&envId=2025-01-19

class Solution {

    public int trapRainWater(int[][] heightMap) {
        
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}} ;
        int rows = heightMap.length;
        int cols = heightMap[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>();

        boolean[][] visited = new boolean[rows][cols];

        // Add first and last rows in the queue and mark them as visited

        for(int i=0; i<cols; i++){

            pq.offer(new Cell(heightMap[0][i],0,i));
            pq.offer(new Cell(heightMap[rows-1][i], rows-1, i));

            visited[0][i] = true;
            visited[rows-1][i] = true;
        }

        // Add first and last columns and mark them as visited

        for(int j=0; j<rows; j++){

            pq.offer(new Cell(heightMap[j][0],j,0));
            pq.offer(new Cell(heightMap[j][cols-1], j, cols-1));
            visited[j][0] = true;
            visited[j][cols-1] = true;
        }

        // start calculating total volume, Djkstra
        int totalVolume =0;

        while(!pq.isEmpty()){

            Cell cell = pq.poll();
            // process it
            int h = cell.height;
            int r = cell.row;
            int c = cell.col;

            for(int[] d: dir){

                int newR = r+ d[0];
                int newC = c+ d[1];

                if(newR <0 || newR >= rows || newC<0 || newC >= cols || visited[newR][newC]){
                    continue;
                }

                int nHeight = heightMap[newR][newC];

                if(nHeight < h){
                    totalVolume += h-nHeight;
                }

                pq.offer(new Cell(Math.max(nHeight, h), newR, newC));
                visited[newR][newC] = true;
            }
        }

        return totalVolume;
    }

    class Cell implements Comparable<Cell>{
        int height;
        int row;
        int col;

        public Cell(int height, int row, int col){
             this.height = height;
             this.row = row;
             this.col = col;
        }

        @Override
        public int compareTo(Cell other){
            return Integer.compare(this.height, other.height);
        }
    }
}
