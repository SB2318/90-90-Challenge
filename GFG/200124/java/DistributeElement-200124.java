/**
  Problem Date: 20/01/2024
  Problem Name: Distribute candies in a binary tree
  Problem Link: https://www.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1
  Problem Category: Tree, Recursion

*/

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/


class Solution
{
  
    
    public static int distributeCandy(Node root)
    {
        //code here
        int[] n= {0};
        helper(root,n);
        
        return n[0];
    }
    
    private static int helper(Node root, int[] n){
        
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left,n);
        int right = helper(root.right, n);
        
        n[0] += Math.abs(left) + Math.abs(right);
        
        return root.data+ left + right -1;
    }
}