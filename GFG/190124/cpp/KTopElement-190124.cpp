/**
  Problem Date: 19/01/2024
  Problem Name: Top k numbers in a stream
  Problem Link: https://www.geeksforgeeks.org/problems/top-k-numbers3425/1
  Problem Category: Collections, Array, Queue, CustomComparator,

*/

class Solution {
  public:
    vector<vector<int>> kTop(vector<int>& arr, int n, int k) {
        
        vector<vector<int>> res;
        unordered_map<int, int> mp;
        set<pair<int, int>> s;
        
        for(auto i: arr) {
            vector<int> row;
            if(mp[i] > 0)
                s.erase({-mp[i], i});
                
            mp[i]++;
            s.insert({-mp[i], i});
            
            int t = 1;
            for(auto j: s) {
                if(t > k)
                    break;
                    
                row.push_back(j.second);
                t++;
            }
            
            res.push_back(row);
        }

        return res;
    }
};
