class Solution {
  public:
    string removeKdigits(string S, int K) {
        
        int n = S.size();
        stack<char> mystack;
        
        for(char c: S){
            
            while(!mystack.empty() && K > 0 && mystack.top() > c){
                mystack.pop();
                K--;
            }
            
            if(!mystack.empty() || c != '0'){
                mystack.push(c);
            }
        }
        
        while(!mystack.empty() && K--){
            mystack.pop();
        }
        
        if(mystack.empty()){
            return "0";
        }
        
        while(!mystack.empty()){
            
            S[n-1] = mystack.top();
            mystack.pop();
            n--;
        }
        
        return S.substr(n);
    }
};

/** Am Sorry, Currently working to convert this code in Java, This is one of the best solution */
