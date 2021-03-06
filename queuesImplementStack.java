import java.util.*;

//an implementation of a FIFO queue as a singly linked list. two of these queues are then used to implement a stack.
public class queuesImplementStack<T> extends AbstractQueue<T> {
	class Node {
		T x;
		Node next;
	}
	
	Node head;
	Node tail;
	
	//number of elements in the queue.
	int n;
	
	public Iterator<T> iterator() {
		class SLIterator implements Iterator<T> {
			protected Node p;

			public SLIterator() {
				p = head;
			}
			public boolean hasNext() {
				return p != null;
			}
			public T next() {
				T x = p.x;
				p = p.next;
				return x;
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
		return new SLIterator();
	}

	//method to return number of elements.
	@Override
	public int size() {
		return n;
	}

	//method to add an element x to the queue. returns true if element was added successfully.
	public boolean add(T x) {
		Node u = new Node();
		u.x = x;
		if (n == 0) {
			head = u;
		} else {
			tail.next = u;
		}
		tail = u;
		n++;
		return true;
	}

	//method to return element at start of queue.
	@Override
	public T peek() {
		return head.x;
	}

	//method to remove element at start of queue and return its value.
	public T remove() {
		if (n == 0)	return null;
		T x = head.x;
		head = head.next;
		if (--n == 0) tail = null;
		return x;
	}	
	
	//create two queues, q1 and q2.
	static Queue<Integer> q1 = new queuesImplementStack<>();
	static Queue<Integer> q2 = new queuesImplementStack<>();
	static int top;

	//push method - add an element x to the top of the stack.
	public static void push(int x) {
	    q1.add(x);
	    top = x;
	}
	
	//pop method - remove the element on top of the stack by transferring between the two queues.
	public static void pop() {
	    while (q1.size() > 1) {
	        top = q1.remove();
	        q2.add(top); 
	    }
	    q1.remove();
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
	}

	//driver code to test implementation.
	public static void main(String[] args) {
		
	//create a Scanner object for user input.
    Scanner scan = new Scanner(System.in);
        
    //get size of queue and items from user input, and perform push operation.
    System.out.print("size of queue: ");
    int size = scan.nextInt();
    scan.nextLine();
        
    int item;
    for (int i = 0; i < size; i++) {
    	System.out.print("item " + i + ": ");
    	item = scan.nextInt();
    	queuesImplementStack.push(item);
	}

	//print queue.
    System.out.println("queue: ");
	System.out.println(q1);
		
	//get number of items to pop from queue and perform pop operation.
    System.out.print("number of items to pop from queue: ");
    int popNum = scan.nextInt();
    scan.nextLine();
		
	for (int i = 0; i < popNum; i++) {
		queuesImplementStack.pop();
	}
		
	//print queue with items popped off.
	System.out.println("queue with items popped off: ");
	System.out.println(q1);
		
	}
}
