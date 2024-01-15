/**
 Problem Date: 09/01/24
 Problem Name: Leaf-Similar Trees
 Problem Link: https://leetcode.com/problems/leaf-similar-trees/
 Problem Category: Tree, BinaryTree, DFS, Searching
*/

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

  
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        /** DFS */
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        findLeafs(root1,list1);
        findLeafs(root2,list2);

        return list1.equals(list2);
    }

    private void findLeafs(TreeNode root, ArrayList<Integer> list){

         if(root == null){
             return;
         }
        /** Leaf condition : no more inheritance */
        if(root.left == null && root.right == null){
            list.add(root.val);
        }else{

            findLeafs(root.left,list);
            findLeafs(root.right, list);
        }
    }
}
