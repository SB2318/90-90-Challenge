// Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06

// Approach 1: Basic Approach-> Beginner friendly
// Intution: As your task is to count all possible transtions of each balls inside the array, so run two loop and find your answer

class Solution {
    public int[] minOperations(String boxes) {
        
        int[] ans = new int[boxes.length()];

        for(int i=0; i<boxes.length(); i++){

            if(boxes.charAt(i) == '1'){
                
                for(int i1 =0; i1<boxes.length(); i1++){

                    ans[i1] += Math.abs(i1-i);
                }
            }
        }

        return ans;
    }
}

// Approach 2: Optimized Approach -> O(n)
/**
 Intuition: 
 In the previous approach, you are taking one ball at a time and storing all possible moves of that ball in the answer array
 corresponding index.
 But here, we will try to optimize these things, Instead of doing repeated things for each ball, we are going to precompute their moves.
 Like, you assume a stream of balls from the left side, we are measuring their left moves, similarly, we are measuring right moves from the right stream. 
 (Search Phase of moon)

 Now, the question is, we need one static point, with respect to which we will measure the ultimate left moves as well as right moves.

 This point is the index position.

 The last is what is the measuring point:
  simple, each ball move will be considered as 1, if there are any balls at the corresponding index position we will update the corresponding cumulative
  moves by 1.

  For each index, we will add this ultimate move and will store our answer.

  
*/

class Solution {
    public int[] minOperations(String boxes) {
        int movesLeft=0, leftBalls=0, movesRight=0, rightBalls =0;
        int[] ans = new int[boxes.length()];

        for(int i=0; i<boxes.length(); i++){

             ans[i] += movesLeft;
             leftBalls += boxes.charAt(i) == '1'?1:0;
             movesLeft+= leftBalls;

             int j= boxes.length()-i-1;
             ans[j]+= movesRight;
             rightBalls+= boxes.charAt(j) == '1'?1:0;
             movesRight+= rightBalls;
        }

        return ans;

    }
}


