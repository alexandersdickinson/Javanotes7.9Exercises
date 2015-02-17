/**
This class prints a binary sort tree of words from a passage from Social Sciences as Sorcery, by Stanislav Andreski. Words are printed from a queue.
*/

public class QueuePrint{
	
	private static TreeNode root;
	
	public static void main(String[] args){
		
		TreeNode treeQueueNode;
		
		String[] tempWords;
		TextIO.readFile("text.txt");
		tempWords = TextIO.getln().split(" ");
		for(int i = 0; i < tempWords.length; i++){
			tempWords[i] = tempWords[i].toLowerCase();
			treeInsert(tempWords[i]);
		}
		
		TreeQueue.enqueue(root);
		while(!TreeQueue.isEmpty()){
			treeQueueNode = TreeQueue.dequeue();
			System.out.print(" " + treeQueueNode.item);
			if(treeQueueNode.left != null){
				TreeQueue.enqueue(treeQueueNode.left);
			}
			if(treeQueueNode.right != null){
				TreeQueue.enqueue(treeQueueNode.right);
			}
		}
		
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
	
	private static class TreeQueue{
		
		private static class Node{
			
			TreeNode item;
			Node next;
			
		}
		
		private static Node head = null;
		private static Node tail = null;
		
		/**
		    * Add N to the back of the queue.
		    */
	   public static void enqueue( TreeNode n ) {
	      Node newTail = new Node();  // A Node to hold the new item.
	      newTail.item = n;
	      if (head == null) {
	            // The queue was empty.  The new Node becomes
	            // the only node in the list.  Since it is both
	            // the first and last node, both head and tail
	            // point to it.
	         head = newTail;
	         tail = newTail;
	      }
	      else {
	            // The new node becomes the new tail of the list.
	            // (The head of the list is unaffected.)
	         tail.next = newTail;
	         tail = newTail;
	      }
	   }

	   /**
	    * Remove and return the front item in the queue.
	    * Throws an IllegalStateException if the queue is empty.
	    */
	   public static TreeNode dequeue() {
	      if ( head == null)
	          throw new IllegalStateException("Can't dequeue from an empty queue.");
	      TreeNode firstItem = head.item;
	      head = head.next;  // The previous second item is now first.
	                         // If we have just removed the last item,
	                         // then head is null.
	      if (head == null) {
	            // The queue has become empty.  The Node that was
	            // deleted was the tail as well as the head of the
	            // list, so now there is no tail.  (Actually, the
	            // class would work fine without this step.)
	         tail = null;
	      } 
	      return firstItem;
	   }

	   /**
	    * Return true if the queue is empty.
	    */
	   public static boolean isEmpty() {
	      return (head == null);
	   }
		
	}
	
}