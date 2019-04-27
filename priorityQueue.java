import java.util.*; 
  
class priorityQueue
{ 
	static class Node {  
		int data;   
		Node next;  
	}
  
	static Node node = new Node(); 
    
	//method to create a new node. parameter x is data to add to node. returns temp node.
	static Node newNode(int x) {  
		Node temp = new Node();  
		temp.data = x;  
		temp.next = null;  
		return temp;
	}  
	
	//method to return number of elements in list, n.
	static int size(Node head) {
		Node temp = (head); 
	    int n = 0; 
	    while (temp != null) 
	    { 
	        n++; 
	        temp = temp.next; 
	    } 
	    return n; 
	}

	//method to return value at head of list.
	static int peek(Node head) {  
		return (head).data;  
	}    
    
	//method to push an element, x, and place it in the queue according to priority (lower numbers have lower priority and will go first).
	static Node add(Node head, int x) {  
		Node start = (head);
		
		//create new node  
		Node temp = newNode(x);
		
		if ((head).data > x) {  
			//insert new node before head  
			temp.next = head;  
			(head) = temp;  
		}  
    
		else {  
        //go through list and find a position to start new node 
			while (start.next != null && start.next.data < x) {  
				start = start.next;  
			}
			
        temp.next = start.next;  
        start.next = temp;
        
		} 
		
		return head;
	}  

	//method to remove element with highest priority (first element) from list.
	static Node deleteMin(Node head) {   
		(head) = (head).next;  
		return head; 
	}  
    
	//method to check if list is empty.  
	static int isEmpty(Node head) {  
		return ((head) == null)? 1:0;  
	}  
    
	//driver code to test implementation.
	public static void main(String args[]) {
		//create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        //get size of queue and items from user input.
        System.out.print("size of queue: ");
        int size = scan.nextInt();
        scan.nextLine();
        int head, item;
        System.out.print("item 0: ");
        head = scan.nextInt();
        Node pq = newNode(head);
        
        if (size > 1) {
            for (int i = 1; i < size; i++) {
            	System.out.print("item " + i + ": ");
                item = scan.nextInt();
            	pq = add(pq, item);  
            }
        }
    
        //print queue with lowest priority item deleted.
		pq = deleteMin(pq);
		System.out.println("queue with minimum item deleted: ");
		while (isEmpty(pq)==0) {  
			System.out.printf("%d ", peek(pq));  
			pq = deleteMin(pq);  
		}  
	}
} 
