import java.util.Scanner;

public class reverseDLL {

	static Node head;
	
	static class Node { 
		int data; 
		Node next, prev; 
		Node(int d) { 
			data = d; 
			next = prev = null; 
	    } 
	} 
	
	//method to reverse the elements in the doubly linked list.  
	void reverse() { 
		Node temp = null; 
		Node current = head; 
	  
		//swap next and prev for all nodes of list.
		while (current != null) { 
			temp = current.prev; 
			current.prev = current.next; 
			current.next = temp; 
			current = current.prev; 
	    } 
	  
	    //check for empty lists and lists with only one node.
	    if (temp != null) { 
	        head = temp.prev; 
	    } 
	} 
	  	
	//method to insert new node.
	void push(int new_data) { 
	    Node new_node = new Node(new_data); 
	    new_node.prev = null; 
	    new_node.next = head; 
	    if (head != null) { 
	        head.prev = new_node; 
	    } 
	    head = new_node; 
	} 
	  
	//method to print list. 
	void printList(Node node) { 
	    while (node != null) { 
	        System.out.print(node.data + " "); 
	        node = node.next; 
	    } 
	}    
	    
	//driver code to test implementation.
	public static void main(String[] args) {
		//create a Scanner object for user input.
	  	Scanner scan = new Scanner(System.in);
	  	        
	  	//create a new list.
	  	reverseDLL list = new reverseDLL();
	  	        
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
	  	        
	  	//reverse list and print.
		System.out.println("Original linked list is: "); 
		list.printList(head); 
		  
		list.reverse(); 
		System.out.println(""); 
		System.out.println("Reversed linked list is: "); 
		list.printList(head);  
	}
}
