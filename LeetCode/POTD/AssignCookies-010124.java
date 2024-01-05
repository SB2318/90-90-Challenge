/**
  Problem Date : 01/01/2024
  Problem Name : Assign Cookies

  Problem Link: https://leetcode.com/problems/assign-cookies/

  Problem Category: Array, DS
  
*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {

       Arrays.sort(g); 
       Arrays.sort(s);
       
       
       int sIndex=s.length-1, count=0;

       for(int i=g.length-1; i>=0; i--){

           if(sIndex>=0 && s[sIndex]>= g[i]){

            
               count++;
               sIndex--;
           }
           if(sIndex <0){
               break;
           }
       }

       return count;
    }
}