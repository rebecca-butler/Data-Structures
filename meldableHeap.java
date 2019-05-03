import java.util.Scanner;
import java.util.Random;
 
//define the Node class.
class Node
{
    Node left, right, parent;
    int x; //the value of the node.
 
    public Node(Node parent, Node left, Node right, int x)
    {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.x = x;
    }
}
 
class meldableHeap
{
    public Random rand; //will be used to randomly select either q1.left or q1.right for merging.
    public int n; //size of heap.
    public static Node root; //root node of heap.
 
    public meldableHeap()
    {
        root = null;
        rand = new Random();
        n = 0;
    }
 
    //method to get size of heap.
    public int getSize()
    {
        return n;
    }
 
    //method to insert an element x into the heap.
    public void add(int x) 
    {
        Node u = new Node(null, null, null, x);
        root = meld(u, root); //merge the new node with the current tree root.
        root.parent = null;
        n++;
    }
 
    //method to remove an element from the heap.
    public int remove() 
    {
        int x = root.x;
        root = meld(root.left, root.right); //merges the left subtree and the right subtree of the root.
        if (root != null) 
            root.parent = null;
        n--;
        return x;
    }
    
    //method to remove a given node, u, from the heap.
	public void removeNode(Node u) {
		if (u == root) {
			remove(); //call remove() function if u is the root
		} else {
			if (u == u.parent.left) {
				u.parent.left = null;
			} else {
				u.parent.right = null;
			}
			u.parent = null;
			root = meld(root, u.left); //merge the root and the left subtree of u.
			root = meld(root, u.right); //merge the root and the right subtree of u.
			root.parent = null;
			n--; //decrease the size of the heap.
		}
	}
	
	//method to find the node containing the given value. this is a utility function used to pass data to the remove(u) method.
	public Node findNode(Node u, int value) {
	    if(u != null){
	        if(u.x == value)
	           return u; //return u if its value equals x
	        else { //recursively search
	            Node foundNode = findNode(u.left, value);
	            if(foundNode == null)
	                foundNode = findNode(u.right, value);
	            return foundNode;
	        }
	    }
	    else
	        return null;
	}
 
    //method to merge two heap nodes, q1 and q2.
    public Node meld(Node q1, Node q2) 
    {
        if (q1 == null) 
            return q2;
        if (q2 == null) 
            return q1;
 
        if (q2.x < q1.x) 
            return meld(q2, q1); //swap q1 and q2 if the value of q1 is greater.
 
        if (rand.nextBoolean()) //randomly merge q2 either with q1.left or q1.right.
        {
            q1.left = meld(q1.left, q2);
            q1.left.parent = q1;
        } 
        else 
        {
            q1.right = meld(q1.right, q2);
            q1.right.parent = q1;
        }
        return q1;
    }
 
    //method to print the heap.
    public void displayHeap()
    {
        System.out.print("\nMeldable Heap : ");
        if (root == null)
        {
            System.out.print("Empty\n");
            return;
        }
 
        Node prev, w = root;
        while (w.left != null) 
            w = w.left;
 
        while (w != null)
        {
            System.out.print(w.x +" ");
            prev = w;
            w = nextNode(w); //find the next node in the heap.           
        }
        
        System.out.println();
    }
 
    //method to find the next node in the heap that follows the given node, w.
    private Node nextNode(Node w) 
    {
        if (w.right != null) 
        {
            w = w.right;
            while (w.left != null)
                w = w.left;
        } 
        
        else 
        {
            while (w.parent != null && w.parent.left != w)
                w = w.parent;
            w = w.parent;
        }
        return w;
    }    
 
    //driver method to test the above functions.
    public static void main(String[] args)
    {
    	//create a scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        meldableHeap mh = new meldableHeap();
 
        char ch; //the user's choice

        do    
        {
            System.out.println("Type 1 to add, or type 2 to remove an element of your choice.");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1: 
                System.out.println("Enter integer element to add: ");
                mh.add(scan.nextInt()); 
                break;                                                     
            case 2:
            	System.out.println("Enter an integer element to remove: ");
            	Node foundNode = mh.findNode (root, scan.nextInt()); //find the node with the given value.
            	if (foundNode != null) {
                	mh.removeNode(foundNode); //remove node if it is not null.
                	System.out.println("Removed node from heap");
            	}
            	else
            		System.out.println("Node is not in heap");
            	break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }

            mh.displayHeap(); //display the heap.
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
        scan.close();
    }
}
