class Solution{
    public:
    vector<vector<int>> printPaths(Node *root, int sum){
        //code here
        vector<vector<int>> ans;
        queue<pair<Node* , pair<int,vector<int>>>> q;
        q.push({root,{root->key, {root->key}}});
        //break queue when queue is empty and sum is not 0
        while(!q.empty()){// q as first node then second.first is sum then second.second is array
            auto node= q.front();q.pop();
            if(sum==node.second.first){
                //we got a sum so put it in ans
                ans.emplace_back(node.second.second.begin(),node.second.second.end());
            }
            if(node.first->left){
                //we got left valu put it in queue
                vector<int> tempV(node.second.second.begin(),node.second.second.end());
                int tempS =node.second.first+node.first->left->key;
                tempV.push_back(node.first->left->key);
                q.push({node.first->left,{tempS,tempV}});
            }
           
            if(node.first->right){
                //we got left valu put it in queue
                vector<int> tempV(node.second.second.begin(),node.second.second.end());
                int tempS =node.second.first+node.first->right->key;
                tempV.push_back(node.first->right->key);
                q.push({node.first->right,{tempS,tempV}});
            }
        }
        return ans;
    }
};