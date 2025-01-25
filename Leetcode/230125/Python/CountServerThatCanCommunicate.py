# Problem Link: https://leetcode.com/problems/count-servers-that-communicate/description/?envType=daily-question&envId=2025-01-23
# Intuition: Track the server count of each row and each column, 
# If any row or any columns contain more than one server then they can communicate with each other
# Lastly, for each 1 (means present server we are checking whether they can communicate or not)

class Solution(object):
    def countServers(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid)
        cols = len(grid[0])

        rowCount = [0]*rows
        colCount = [0]*cols

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    rowCount[i]+=1
                    colCount[j]+=1
        serverCount =0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    if rowCount[i] > 1 or colCount[j] > 1:
                       serverCount+=1
        return serverCount
