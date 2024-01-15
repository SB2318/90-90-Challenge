/**
  Problem Date: 07/01/2024
  Problem Name: Maximum Area of Longest Diagonal Rectangle
  Problem Link: https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/
  Problem Category: Basic Math
*/

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
           
        double maxD= 0;
   
        int area= 0;
        
        for(int i=0; i< dimensions.length; i++){
            
            int l= dimensions[i][0];
            int w= dimensions[i][1];
            
            long rec= l*l+w*w;
            
            if(maxD <  rec){
                maxD = rec;
                area= l*w;
            }
            else if( maxD == rec){
               area = Math.max(area,l*w);
            }
        }
        
        return area;
    }
}