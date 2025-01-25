# Problem Link: https://leetcode.com/problems/grid-game/
# Solution Link: https://www.youtube.com/watch?v=Y8VC_OnkazE

class Solution(object):
    def gridGame(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        firstSum =0
        for i in range(len(grid[0])):
            firstSum += grid[0][i]
        secondSum =0
        minSum = 10000000000000000000001
        for i in range(len(grid[0])):
            firstSum -= grid[0][i]
            minSum = min(minSum, max(firstSum, secondSum))
            secondSum += grid[1][i]
        return minSum
