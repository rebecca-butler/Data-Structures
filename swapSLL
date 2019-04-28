import java.util.Scanner;

public class swapSLL {
	  static class Node {  
		int data;   
		Node next;  
	}
  
	static Node node = new Node(); 
    
	//method to create new node. parameter x is data to add to node. returns temp node. 
	static Node newNode(int x) {  
		Node temp = new Node();  
		temp.data = x;  
		temp.next = null;  
		return temp;
	}  

	//method to swap adjacent elements.
	public static Node swap(Node head) {
		  //if list is empty or has only one element, return head.
	    if (head == null || head.next == null) {
	        return head;
	    }

	    Node result = head.next;

	    Node prev = null;
	    while (head != null && head.next != null) {
	        if (prev != null) {
	            prev.next = head.next;
	        }
	        
	        prev = head;
	        
	        //swap nodes.
	        Node temp = head.next;
	        head.next = temp.next;
	        temp.next = head;
	        head = head.next;
	    }

	    return result;
	}
	
	static Node head;

    
    //method to insert a new node into given list. parameter data is the data to be added to the node.
    public static swapSLL insert(swapSLL list, int data) 
    { 
        //create new node.
        Node node = newNode(data); 
        node.next = null; 
  
        //if list is empty, new node is head.
        if (swapSLL.head == null) { 
            swapSLL.head = node; 
        } 
        else { 
            //go through list until last node is reached.
            Node last = swapSLL.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            //insert new node at last node. 
            last.next = node; 
        } 
  
        return list; 
    } 
    
    //method to print list.
    public static void printList(swapSLL list) 
    { 
        Node currNode = swapSLL.head;  
        while (currNode != null) { 
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    } 
    
	//driver code to test implementation.
	public static void main(String[] args) {
		//create a Scanner object for user input.
    Scanner scan = new Scanner(System.in);
        
    //create a new list.
    swapSLL list = new swapSLL(); 
        
    //get size of list and items from user input.
    System.out.print("size of list: ");
    int size = scan.nextInt();
    scan.nextLine(); 
    int item;
        
    for (int i = 0; i < size; i++) {
    	System.out.print("item " + i + ": ");
      item = scan.nextInt();
      list = insert(list, item); 
    }
        
    System.out.print("the list is: ");
    printList(list);
    System.out.println();
        
    //swap and print list.
    head = swap(swapSLL.head);
    System.out.print("the swapped list is: ");
    printList(list);
	}
}  
