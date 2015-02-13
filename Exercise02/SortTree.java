/**
This program takes a passage from Social Sciences as Sorcery, by Stanislav Andreski, and sorts it using a binary sort tree. It prints the sorted passage.
*/

public class SortTree{
	
	private static TreeNode root;

	public static void main(String[] args){
		
		String[] tempWords;
		TextIO.readFile("text.txt");
		tempWords = TextIO.getln().split(" ");
		for(int i = 0; i < tempWords.length; i++){
			tempWords[i] = tempWords[i].toLowerCase();
			treeInsert(tempWords[i]);
		}
		treeList(root);
		
	}

	private static class TreeNode{
		
		TreeNode left;
		TreeNode right;
		String item;
		
		TreeNode(String str){
			item = str;
		}
		
	}
	
	private static void treeInsert(String newItem){
		
		if(root == null){
			root = new TreeNode(newItem);
			return;
		}
		
		TreeNode runner;
		runner = root;
		
		while(true){
			
			if(newItem.compareTo(runner.item) < 0){
			
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
	
	private static boolean treeContains(TreeNode root, String item){
		
		if(root == null){
			return false;
		}
		if(root.equals(root.item)){
			return true;
		}
		if(item.compareTo(root.item) < 0){
			return treeContains(root.left, item);
		}
		else{
			return treeContains(root.right, item);
		}
		
	}
	
	private static void treeList(TreeNode root){
		if(root != null){
			treeList(root.left);
			System.out.print(root.item + " ");
			treeList(root.right);
		}
	}
	
	private static int countNodes(TreeNode node){
		
		if(node == null){
			return 0;
		}
		else{
			int leftCount = countNodes(node.left);
			int rightCount = countNodes(node.right);
			return 1 + leftCount + rightCount;
		}
		
	}

}