// Problem Link: https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

/**
Intution: Sliding window
Take the first k elements and create 1 window, collect distinct elements, and add the window size.
Then start sliding your window, and collect distinct elements by removing the previous one.
*/

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        res.add(map.size());
        for(int i=k; i<arr.length; i++){
            
            if(map.get(arr[i-k]) == 1){
                map.remove(arr[i-k]);
            }else{
                map.put(arr[i-k], map.get(arr[i-k])-1);
            }
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            
            res.add(map.size());
        }
        
        return res;
    }
}
