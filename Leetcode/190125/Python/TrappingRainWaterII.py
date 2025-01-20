# Problem Link: https://leetcode.com/problems/trapping-rain-water-ii/?envType=daily-question&envId=2025-01-19

class Solution(object):
    def trapRainWater(self, heightMap):
        """
        :type heightMap: List[List[int]]
        :rtype: int
        """
        row, col = len(heightMap), len(heightMap[0])
        dirs = [(0,-1),(0,1),(-1,0),(1,0)]
        pq = []

        visited = [[False] * col for i in range(row)]

        # add first row and last row
        for i in range(col):
            heapq.heappush(pq, (heightMap[0][i],0,i))
            heapq.heappush(pq, (heightMap[row-1][i],row-1,i))
            visited[0][i] = True
            visited[row-1][i] = True
        
        # add first and last column

        for i in range(row):
            heapq.heappush(pq, (heightMap[i][0],i,0))
            heapq.heappush(pq, (heightMap[i][col-1],i,col-1))
            visited[i][0] = True
            visited[i][col-1] = True
        
        totalVolume = 0

        while pq:
            h, r, c = heapq.heappop(pq)

            for d in dirs:
                newR = r + d[0]
                newC = c + d[1]

                if newR < 0 or newR >= row or newC < 0 or newC >= col or visited[newR][newC]:
                     continue
                newH = heightMap[newR][newC]

                if newH < h:
                    totalVolume += h-newH
                heapq.heappush(pq, (max(h, newH),newR, newC))
                visited[newR][newC] = True
        
        return totalVolume
                
                
        
        
