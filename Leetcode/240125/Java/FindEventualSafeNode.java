// Problem Link: https://leetcode.com/problems/find-eventual-safe-states/description/?envType=daily-question&envId=2025-01-24
// Solution Link: 
// (i) BFS:  https://takeuforward.org/data-structure/find-eventual-safe-states-bfs-topological-sort-g-25/ 
// (ii) DFS: https://takeuforward.org/data-structure/find-eventual-safe-states-dfs-g-20/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];

        List<Integer> res = new ArrayList<>();

        for(int i=0; i<graph.length; i++){

            if(visited[i] == false){
              checkCycleDetection(i, graph, visited, pathVisited, res);
            }
        }

        Collections.sort(res);
        return res;
    }

    private boolean checkCycleDetection(int node, int[][] graph, boolean[] visited, 
    boolean[] pathVisited, List<Integer> res){

        visited[node] = true;
        pathVisited[node] = true;

        for(int i=0; i<graph[node].length; i++){

            int currNode = graph[node][i];

            if(visited[currNode] == false){

                if(checkCycleDetection(currNode, graph, visited, pathVisited, res)){
                    return true;
                }
            }
            else if(pathVisited[currNode]){
                return true;
            }
        }

        // If any node reach till here, it means this is first time, add it to result as safe node
        res.add(node);
        // Back track, make pathVisited as false
        pathVisited[node] = false;

        return false;


    }
}
