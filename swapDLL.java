import java.util.Scanner;

public class swapDLL {

	static Node head;
	static Node tail;
	
	static class Node { 
		int data; 
		Node next, prev; 
		Node(int d) { 
			data = d; 
			next = prev = null; 
	    } 
	} 
	
	//method to swap adjacent elements.
	private static Node swap(Node head) {
		//if list is empty or has only one element, return head.
		if (head == null || head.next == null) {
	        return head;
	    }

		Node a = head;
		Node b = head.next;
		head = b;
		
		//perform the swap by adjusting links.
		while (a != null && b != null)
		{
			a.next = b.next;
			b.next = a;
			b.prev = a.prev;
			a.prev = b;
			if (a.next != null)
				a.next.prev = a;
			if (b.prev != null)
				b.prev.next = b;
			a = a.next;
			b = (a != null)? a.next : null;
		}
		return head;
	}
	  	
	//method to insert new node. parameter data is the data to be added to the node.
	void push(int data) { 
	    Node node = new Node(data); 
	    node.prev = null; 
	    node.next = head; 
	    if (head != null) { 
	        head.prev = node; 
	    } 
	    head = node; 
	} 
	  
	//print list.  
	void printList(Node node) { 
	    while (node != null) { 
	        System.out.print(node.data);
	        System.out.println();
	        node = node.next; 
	    } 
	}    
	    
	//driver code to test implementation.
	public static void main(String[] args) {
		  //create a Scanner object for user input.
	    Scanner scan = new Scanner(System.in);
	        
	    //create a new list.
	    swapDLL list = new swapDLL();  
	        
	    //get size of list and items from user input.
	    System.out.print("size of list: ");
	    int size = scan.nextInt();
	    scan.nextLine();
	    int item;
	        
	    for (int i = 0; i < size; i++) {
	    	System.out.print("item " + i + ": ");
	        item = scan.nextInt();
	        list.push(item);
	    }
	        
	    
	    //swap adjacent elements and print list.
	    System.out.println("Original linked list is: "); 
	    list.printList(head);
	    
	    int firstLink = 0;
	    if (size > 1)
	    	firstLink = head.next.data;
	    
	    System.out.println(""); 
	    System.out.println("Swapped linked list is: ");
		  swapDLL.swap(swapDLL.head); 

	    if (size > 1)
	    	System.out.println(firstLink);
	    list.printList(head); 
	}
}
