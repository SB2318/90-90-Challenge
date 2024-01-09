/***
 Problem Date: 09/01/24
 Problem Name: Search Pattern
 Problem Link: https://www.geeksforgeeks.org/problems/search-pattern0205/1
 Problem Category: String, DSA, KMP(due, will share on weekend)
*/

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        
       /** Naive Solution, Time Complexity: O(M*N) */
       ArrayList<Integer> result = new ArrayList<>();
       
       for(int i=0; i<txt.length(); i++){
           
            int c=i;
            int j=0;
            
            while(i<txt.length() && j<pat.length()){
                
                if(txt.charAt(i)== pat.charAt(j)){
                    i++;
                }else{
                    i=c;
                    break;
                }
                j++;
            }
            
            if(j==pat.length()){
                result.add(c+1);
                i=c;
            }
       }
       
       return result;
    }
}
