# Problem Link: https://leetcode.com/problems/find-eventual-safe-states/description/?envType=daily-question&envId=2025-01-24
# Solution Link: 
# (i) BFS:  https://takeuforward.org/data-structure/find-eventual-safe-states-bfs-topological-sort-g-25/ 
# (ii) DFS: https://takeuforward.org/data-structure/find-eventual-safe-states-dfs-g-20/

class Solution(object):
    def eventualSafeNodes(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[int]
        """
        rows = len(graph)
        visited = [False]*rows
        pathVisited = [False]*rows

        res = []

        for i in range(len(graph)):
            if visited[i] == False:
               self.checkCycleDetection(i, graph, res, visited, pathVisited)
        res.sort()
        return res 
    def checkCycleDetection(self,node, graph, res, visited, pathVisited):
        visited[node] = True
        pathVisited[node] = True

        for i in range(len(graph[node])):
            currNode = graph[node][i]
            if visited[currNode] == False:
                if self.checkCycleDetection(currNode,graph, res, visited, pathVisited):
                    return True
            elif pathVisited[currNode] == True:
                   return True
        
        res.append(node)
        pathVisited[node] = False

        return False
