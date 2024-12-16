package com.servicenow;

import common.TreeNode;

/**
 * 
 * You are given the root of a binary tree with unique values, and an integer
 * start. At minute 0, an infection starts from the node with value start. Each
 * minute, a node becomes infected if: The node is currently uninfected. The
 * node is adjacent to an infected node. Return the number of minutes needed for
 * the entire tree to be infected.
 * 
 * Input: root = [1,5,3,null,4,10,6,9,2], start = 3 
 * Output: 4 Explanation: The
 * following nodes are infected during:
 *   
 * - Minute 0: Node 3  
 * - Minute 1: Nodes 1, 10 and 6 
 * - Minute 2: Node 5 
 * - Minute 3: Node 4 
 * - Minute 4: Nodes 9 and 2 
 * It takes 4 minutes for the whole tree to be infected so we return 4.
 * 
 * Input: root = [1], start = 1 Output: 0 Explanation: At minute 0, the only
 * node in the tree is infected so we return 0.
 * 
 * 
 * 分别Iterate 左子树 和 右子树，遇到start，在返回时候 返回 -1 ，一直到根节点，左子树 
 * 
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
	
	 int maxDepth = 0; 
	
	 public int amountOfTime(TreeNode root, int start) {
		 
		return depthOfTree(root, start);
	        
	 }
	 
	 int depthOfTree(TreeNode root, int start) {
		 
		 if (root == null) {
			 return 0;
		 }
		 
		 int leftMaxDepth = depthOfTree(root.left, start);
		 int rightMaxDepth = depthOfTree(root.right, start);
		 
		 // 深度历遍
		 
		 if ( root.val == start ) {
			 maxDepth = Math.max(leftMaxDepth, rightMaxDepth);
			 // 当找到 start的时候 返回标志性 -1， 在逐层返回时候 递增-1
			 return -1;
		 } else if ( leftMaxDepth >= 0 && rightMaxDepth >= 0 ) {
			 // 当2边都是大于0 时候 表面 在start 之下
			 return Math.max(leftMaxDepth, rightMaxDepth) + 1;
		 } else {
			 int distance = Math.abs(rightMaxDepth) + Math.abs(leftMaxDepth);
			 maxDepth = Math.max(maxDepth, distance);
			 // 在返回时候 找小于0 的 一端 返回 因为 是从 start 逆行到 根节点 所以一直是递减 1
			 return Math.min( leftMaxDepth, rightMaxDepth) - 1; 
		 }
		 
		 
		 
	 }

}
