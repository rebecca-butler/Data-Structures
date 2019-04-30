import java.util.Scanner;

public class nextNode { 
  
	//define the Node class.
	static class Node {  
		Node left, right, parent;  
		int value;  
	} 
	
	//method to create a new node with the given value.
	static Node newNode(int value)  
	{  
		Node temp = new Node();  
		temp.left = null; 
		temp.right = null; 
		temp.parent = null;  
		temp.value = value;  
		return temp;  
	}  
  
	//method to find the node that follows n in post-order (left subtree, right subtree, root).
	static Node postOrderNext(Node n)  
	{  
		//if n is the root (has no parent), it will be the last node in the search.
		if (n.parent == null)
			return null;
		
		//if n is the right child of its parent or the parent's right child is empty, then the parent follows n in post-order.  
		Node parent = n.parent;  
		if (parent.right == null || parent.right == n)  
			return parent;  

		//otherwise, the leftmost child in the right subtree of the parent follows n.  
		Node curr = parent.right;  
		while (curr.left != null)  
			curr = curr.left;  

		return curr;  
	}  

	//method to find the node that follows n in in-order (left subtree, root, right subtree) - this algorithm was given in Pat Morin's BT implementation.
	static Node inOrderNext(Node n) {
		
		//the right child follows n, unless the right child has a left child, in which case its leftmost child follows n.
		if (n.right != null) {
			n = n.right;
			while (n.left != null)
				n = n.left;
		} 
		
		//if there are no children, travel up until we reach a parent node of a left child.
		else {
			while (n.parent != null && n.parent.left != n)
				n = n.parent;
			n = n.parent;
		}
		
		return n;
	}

	//method to find the node that follows n in pre-order (root, left subtree, right subtree).
	static Node preOrderNext(Node n) {

		//if the left child is not null, it follows n. 
		if (n.left != null)
			return n.left;

		Node curr = n;
		Node parent = curr.parent;
		
		//if n is the right child of its parent, move up the tree until you reach a node that is the left child of its parent.
		while (parent != null && parent.right == curr) {
			curr = curr.parent;
			parent = parent.parent; //assign the parent to be the parent of the parent
		}

		//if the parent of the parent is null, n is the last node in the search.
		if (parent == null)
			return null;

		//return the parent's right child.
		return parent.right;
	}
	
	//method to return the node containing the given value. this will be used for testing purposes.
	static Node findNode(Node current, int value) {
	    if(current != null){
	        if(current.value == value)
	           return current;
	        else {
	            Node foundNode = findNode(current.left, value);
	            if(foundNode == null)
	                foundNode = findNode(current.right, value);
	            return foundNode;
	        }
	    }
	    
	    else
	        return null;
	}

	//driver code to test the above functions.
	public static void main(String[] args)  
	{  
		//create the test tree.
		Node root = newNode(1);  
		root.parent = null;  
		root.left = newNode(2);  
		root.left.parent = root;  
		root.left.left = newNode(4);  
		root.left.left.parent = root.left;  
		root.left.right = newNode(5);  
		root.left.right.parent = root.left;  
		root.right = newNode(3);  
		root.right.parent = root;    
		
    	//create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter an integer from 1-5 to find the node that follows it when traversing the tree: ");
        int testNum = scan.nextInt();
        
        if (testNum > 5 || testNum < 1)
        	System.out.print("Invalid entry");
        
        else {
        	Node testNode = findNode(root, testNum);

        	Node post = postOrderNext(testNode);  
        	if (post != null)  
        		System.out.println("In post-order, " + testNum + " is followed by " + post.value);  
        	else
				System.out.println("In post-order, " + testNum + " is the last node in the search"); 

        	Node in = inOrderNext(testNode);  
        	if (in != null)  
        		System.out.println("In in-order, " + testNum + " is followed by " + in.value);  
        	else
        		System.out.println("In in-order, " + testNum + " is the last node in the search"); 

        	Node pre = preOrderNext(testNode);  
        	if (pre != null)  
        		System.out.println("In pre-order, " + testNum + " is followed by " + pre.value);  
        	else
        		System.out.println("In pre-order, " + testNum + " is the last node in the search"); 
        }
	}  
} 
