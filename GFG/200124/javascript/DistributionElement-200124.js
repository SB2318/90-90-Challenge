/**
  Problem Date: 20/01/2024
  Problem Name: Distribute candies in a binary tree
  Problem Link: https://www.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1
  Problem Category: Tree, Recursion

*/

/*
class Node
{
    constructor(x){
        this.key=x;
        this.left=null;
        this.right=null;
    }
}
*/

/**
 * @param {Node} root
 * @return {number}
*/
class Solution {
    n=0;
    
  	distributeCandy(root){
  		//code here
  		this.helper(root);
  		return this.n;
  	}
  	
    helper(root){
  	    
  	    if(root == null){
  	        return 0;
  	    }
  	    
  	    let left = this.helper(root.left)
  	    let right = this.helper(root.right)
  	    
  	    this.n+= Math.abs(left) + Math.abs(right);
  	    
  	    return root.key + left + right -1;
  	}
}