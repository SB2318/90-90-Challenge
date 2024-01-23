/**
   Problem Date: 23/01/24
   Problem Name: Course Schedule
   Problem Link: https://www.geeksforgeeks.org/problems/course-schedule/1
   Problem Category: Topological Sort
*/

class Solution
{
  public:
    vector<int> findOrder(int numCourses, int m, vector<vector<int>> prerequisites) 
    {
        //code here
        vector<int>adj[numCourses];
        vector<int>indeg(numCourses,0);
        for(auto i:prerequisites)
        {
            adj[i[1]].push_back(i[0]);
        }
        for(int i=0;i<numCourses;i++)
        {
            for(auto job:adj[i])
            {
                indeg[job]++;
            }
        }
        queue<int>q;
        for(int i=0;i<numCourses;i++)
        {
            if(indeg[i]==0)
                q.push(i);
        }
        vector<int>ans;
        while(!q.empty())
        {
            int k=q.front();
            ans.push_back(k);
            q.pop();
            for(auto j:adj[k])
            {
                indeg[j]--;
                if(indeg[j]==0)
                    q.push(j);
            }
        }
        if(ans.size()==numCourses)
            return ans;
        return {};
    }
};