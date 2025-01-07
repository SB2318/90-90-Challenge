# Problem Link:  https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06

# Approach 1: Basic Approach-> Beginner friendly
# Intution: As your task is to count all possible transtions of each balls inside the array, so run two loop and find your answer

class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        n= len(boxes)
        ans = [0]*n
        for currIndex in range(n):
            if(boxes[currIndex] == '1'):
                #move it through all boxes
              for newPos in range(n):
                  ans[newPos] += abs(newPos-currIndex)

        return ans

# Approach 2: Optimized Approach -> O(n)
# Intuition: 
# In the previous approach, you are taking one ball at a time and storing all possible moves of that ball in the answer array
# corresponding index.
# But here, we will try to optimize these things, Instead of doing repeated things for each ball, we are going to precompute their moves.
# Like, you assume a stream of balls from the left side, we are measuring their left moves, similarly, we are measuring right moves from the right stream. 
# (Search Phase of moon)

# Now, the question is, we need one static point, with respect to which we will measure the ultimate left moves as well as right moves.

# This point is the index position.

# The last is what is the measuring point:
#  simple, each ball move will be considered as 1, if there are any balls at the corresponding index position we will update the corresponding cumulative
#  moves by 1.

#  For each index, we will add this ultimate move and will store our answer.

  
class Solution(object):
    def minOperations(self, boxes):
        """
        :type boxes: str
        :rtype: List[int]
        """
        n= len(boxes)
        leftBalls,movesLeft,movesRight,rightBalls = 0,0,0,0
        
        ans = [0]*n

        for i in range(n):
            #left 
            ans[i]+=movesLeft
            leftBalls += 1 if boxes[i] == '1' else 0
            movesLeft+= leftBalls

            #right
            ans[n-i-1]+=movesRight
            rightBalls+= 1 if boxes[n-i-1] == '1' else 0
            movesRight+=rightBalls

        return ans
