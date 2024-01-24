class Solution{

public:

bool detectCycle(int V, vector<int> adj[]) {

        // Write your code here.
        queue<pair<int,int>> q;
        vector<int> vis(V+1, 0);
        vis[1] = 1;
        q.push({1, -1});
        while(!q.empty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                auto it = q.front();
                q.pop();
                for(auto x: adj[it.first]){
                    if(x != it.second){
                        if(vis[x]) return true;
                        else q.push({x, it.first}), vis[x] = 1;
                    }
                }
            }
        }
        return false;
    }
}
int isTree(int n, int m, vector<vector<int>> &v) {
        // code here
        vector<int> vis(n),adj[n];
        for(int i=0; i<m; i++){
            adj[v[i][0]].push_back(v[i][1]);
            adj[v[i][1]].push_back(v[i][0]);
        }
        if(detectCycle(vis, adj)) return 0;
        for(int i=0; i<n; i++) if(!vis[i]) return 0;
        return 1;
    }
};
