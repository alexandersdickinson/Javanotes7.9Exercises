public class ListReverse{
	
	private static ListNode head;

	public static void main(String[] args){
		
		int num;
		
		for(int i = 0; i < 10; i++){
			num = (int)(Math.random() * 10) + 1;
			addItem(num);
		}
		
		printList();
		printReverse();
		
	}
		
	private static class ListNode{
		
		private int item;
		ListNode next;
		
		ListNode(int newItem){
			item = newItem;
		}
		
		public int getItem(){
			return item;
		}
		
		public void setItem(int newItem){
			item = newItem;
		}
		
	}
	
	private static void addItem(int newItem){
		
		ListNode newNode = new ListNode(newItem);
		
		//if head is null, make one.
		if(head == null){
			head = newNode;
		}
		else if(head.item >= newNode.item){
			newNode.next = head;
			head = newNode;
		}
		else{
			
			ListNode runner = head.next;
			ListNode previous = head;
			
			//while runner is less than newItem, traverse one item down the list
			while(runner != null && runner.item < newNode.item){
				previous = runner;
				runner = runner.next;
			}
			
			newNode.next = runner;
			previous.next = newNode;
			
		}
		
	}
	
	static void printList(){
		
		ListNode runner = head;
		while(runner.next != null){
			System.out.println(runner.item);
			runner = runner.next;
		}
		
	}
	
	static void printReverse(){
		
		ListNode runner = head;
		
		int[] intList = new int[10];
		for(int i = 0; i < 10; i++){
			intList[i] = runner.item;
			runner = runner.next;
		}
		
		for(int i = 9; i >= 0; i--){
			System.out.println(intList[i]);
		}
		
	}

}