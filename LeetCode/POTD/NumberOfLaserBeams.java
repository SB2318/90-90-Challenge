/***
   Problem Date: 03/01/2024
   Problem Name: Number of Laser Beams in a Bank
   Problem Link: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
   Solution Link: https://www.youtube.com/watch?v=3-c1Gc-5QnE&t=728s
   Problem Category: Array, String, DSA
*/

class Solution {
    public int numberOfBeams(String[] bank) {
        
        int prevDeviceCount=0,  result=0;

        for(int i=0; i<bank.length; i++){

            int currDeviceCount=0;
            for(int j=0; j<bank[i].length(); j++){

                  if(bank[i].charAt(j) == '1'){
                      currDeviceCount++;
                  }     
                  
            } 
            result+= (prevDeviceCount*currDeviceCount);
             if(currDeviceCount>0){
                prevDeviceCount = currDeviceCount;
            }
        }

        return result;
    }
}

/*** Many Many Happy Returns of The Day MIK Sir  🎂🎈🎉🥳 */
