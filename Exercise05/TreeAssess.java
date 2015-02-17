/**
This class creates 1023 random numbers and places them in a sort tree. It has subroutines for counting the number of leaves, for finding the sum of all the leaves'
values, and for finding the maximum depth of the leaves. The main() program uses these data to print the average depth of the leaves, and the maximum depth.
*/

public class TreeAssess{
	
	public static TreeNode root;

	private static class TreeNode{
		
		TreeNode left;
		TreeNode right;
		double item;
		
		TreeNode(double str){
			item = str;
		}
		
	}
	
	private static void treeInsert(double newItem){
		
		if(root == null){
			root = new TreeNode(newItem);
			return;
		}
		
		TreeNode runner;
		runner = root;
		
		while(true){
			
			if(newItem < runner.item){
			
				if(runner.left == null){
					runner.left = new TreeNode(newItem);
					return;
				}
				else{
					runner = runner.left;
				}
			
			}
			else{
				
				if(runner.right == null){
					runner.right = new TreeNode(newItem);
					return;
				}
				else{
					runner = runner.right;
				}
				
			}
			
		}
		
	}//end treeInsert
	
	/**
		This function evaluates the number of leaves(nodes without branches) in a binary sort tree using recursion. If the tree has either left or right branches,
		these branches are used as nodes in subsequent leaves() calls. These calls are added to n. If both branches are null, then 1 is returned, signifying that
		one leaf has been counted.
		Precondition: There must be a binary sort tree. A node must be given, which would be the root node if the call if from main().
		Postcondition: The number of leaves in the tree.
		
		@param node The node that is to be assessed. When calling the function, this should be the root of the tree.
		@return The count of leaves.
	*/
	private static int leaves(TreeNode node){
		
		if(node.left == null && node.right == null){//base case
			return 1;
		}
		else if(node.left == null){
			return leaves(node.right);
		}
		else if(node.right == null){
			return leaves(node.left);
		}
		else{
			return leaves(node.left) + leaves(node.right);
		}
		
	}
	
	/**
		This function evaluates the average depth of the leaves in a binary sort tree using recursion.
	*/
	private static double averageDepth(TreeNode node, double depth){
		
		double totalDepth = depth;
		if(node.left == null && node.right == null){
			return totalDepth;
		}
		else if(node.left == null){
			return averageDepth(node.right, totalDepth + 1);
		}
		else if(node.right == null){
			return averageDepth(node.left, totalDepth + 1);
		}
		else{
			return (averageDepth(node.left, totalDepth + 1) + averageDepth(node.right, totalDepth + 1)) / 2;
		}
		
	}
	
	private static int maxDepth(TreeNode node, int depth, int maximum){
		
		int totalDepth = depth;
		int max = maximum;
		int leftMax, rightMax;
		if(node.left == null && node.right == null){//you have reached a leaf.
			return totalDepth;
		}
		else if(node.left == null){
			return maxDepth(node.right, totalDepth + 1, max);
		}
		else if(node.right == null){
			return maxDepth(node.left, totalDepth + 1, max);
		}
		else{
			leftMax = maxDepth(node.left, totalDepth + 1, max);
			rightMax = maxDepth(node.right, totalDepth + 1, max);
			return max = leftMax > rightMax ? leftMax:rightMax;
		}
		
	}
	
	public static void main(String[] args){
		
		double rand;
		int leafCount;
		double leafDepthAverage;
		int leafMaxDepth;
		
		for(int i = 0; i < 1023; i++){
			rand = Math.random() * 100;
			treeInsert(rand);
		}
		
		leafCount = leaves(root);
		leafDepthAverage = averageDepth(root, 0.0);
		leafMaxDepth = maxDepth(root, 0, 0);
		System.out.println("The number of leaves is " + leafCount + ".");
		System.out.println("The average depth of the leaves is " + leafDepthAverage + ".");
		System.out.println("The max depth of the tree is " + leafMaxDepth + ".");
		
	}
	
}