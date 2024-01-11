/**
   Problem Date: 11/01/24
   Problem Name :  Maximum Difference Between Node and Ancestor
   Problem Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor
   Problem Category: Tree, Recursion, DFS, DSA
*/

/*** Bruteforce Approach */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int maxDiff =-1;

    public int maxAncestorDiff(TreeNode root) {
        
     
         findMaxDiff(root);
         return maxDiff;
    }

    private void  findMaxDiff(TreeNode root){
          
          if(root == null)
             return;
          /** Fix one node, and explore it's left side to store maximum difference. */
           findMaxDiffUtil(root, root.left);
         /** explore it's right side to store maximum difference. */
           findMaxDiffUtil(root, root.right);

           /** Now call the function for left subtree */
           findMaxDiff(root.left);

           /** Call the function for right subtree */
           findMaxDiff(root.right);


    }

    private void  findMaxDiffUtil(TreeNode root, TreeNode child){

        if(root == null || child == null){
            return;
        }

        maxDiff = Math.max(maxDiff, Math.abs(root.val-child.val));

        findMaxDiffUtil(root, child.left);
        findMaxDiffUtil(root, child.right);
    }
}


/*** Optimize Solution */

/***
  Explore the path :
  In one path the difference between th min_node & max_node will be the answer.
*/

class Solution {

    public int maxAncestorDiff(TreeNode root) {
        
        /** Starting root value will be minimum as well as maximum */
        return findMaxDiff(root,root.val,root.val);
    }

    private int  findMaxDiff(TreeNode root, int maxV, int minV){
          
          if(root == null)
             return Math.abs(maxV-minV); // Return the absolute value
          
          /*** Update max value and min value */
          maxV = Math.max(maxV, root.val);
          minV = Math.min(minV, root.val);

          /** Explore further path (left path) */
          int leftPth = findMaxDiff(root.left,maxV, minV );

         /**  Explore further path (right path) */
          int rightPth = findMaxDiff(root.right, maxV, minV);

          return Math.max(leftPth, rightPth);
    }

  
}
