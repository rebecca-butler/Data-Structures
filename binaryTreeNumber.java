import java.util.Scanner;

//define the Node class.
class NewNode 
{ 
    int value; 
    int postCount; //field for post-order traversal position
    int preCount; //field for pre-order traversal position
    int inCount; //field for in-order traversal position
    
    NewNode left, right; 
  
    public NewNode(int item) 
    { 
        value = item; 
        postCount = item;
        preCount = item;
        inCount = item;
        left = right = null; 
    } 
} 

public class binaryTreeNumber
{ 
    
    NewNode root; 
  
    public binaryTreeNumber() 
    { 
        root = null; 
    } 
    
    //define variables to act as counters for the positions.
    int postCount = 0;
    int preCount = 0;
    int inCount = 0;
    
    //method to print in post-order and assign the correct post-order position to the given node.
    void postOrderNumber(NewNode NewNode) 
    { 
        if (NewNode == null) 
            return; 
  
        postOrderNumber(NewNode.left); 
        postOrderNumber(NewNode.right); 
        System.out.print(NewNode.value + " ");
        postCount++; //increase position counter
        NewNode.postCount = postCount;
    } 
    
    //method to print in in-order and assign the correct in-order position to the given node.
    void inOrderNumber(NewNode NewNode) 
    { 
        if (NewNode == null) 
            return; 
  
        inOrderNumber(NewNode.left); 
        System.out.print(NewNode.value + " "); 
        inCount++; //increase position counter
        NewNode.inCount = inCount;
        inOrderNumber(NewNode.right); 
    } 
  
    //method to print in pre-order and assign the correct pre-order position to the given node.
    void preOrderNumber(NewNode NewNode) 
    { 
        if (NewNode == null) 
            return; 
  
        System.out.print(NewNode.value + " ");
        preCount++; //increase position counter
        NewNode.preCount = preCount;
        preOrderNumber(NewNode.left); 
        preOrderNumber(NewNode.right); 
    } 
  
    //wrappers over above recursive functions.
    void postOrderNumber()  {     postOrderNumber(root);  } 
    void inOrderNumber()    {     inOrderNumber(root);   } 
    void preOrderNumber()   {     preOrderNumber(root);  } 
  
    //method to find a node given its value. this will be used for testing purposes.
	static NewNode findNode(NewNode current, int value) {
	    if(current != null){
	        if(current.value == value)
	           return current;
	        else {
	            NewNode foundNode = findNode(current.left, value);
	            if(foundNode == null)
	                foundNode = findNode(current.right, value);
	            return foundNode;
	        }
	        
	    }
	    else
	        return null;
	}
    
    //driver code to test implementation.
    public static void main(String[] args) 
    {   
    	//create the test tree.
        binaryTreeNumber tree = new binaryTreeNumber(); 
        tree.root = new NewNode(1); 
        tree.root.left = new NewNode(2); 
        tree.root.right = new NewNode(3); 
        tree.root.left.left = new NewNode(4); 
        tree.root.left.right = new NewNode(5);
        
    	//create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter an integer from 1-5 to find its post, pre, and in-order positions: ");
        int testNum = scan.nextInt();
        
        if (testNum > 5 || testNum < 1)
        	System.out.print("Invalid entry");
        
        else {
        	NewNode testNode = findNode(tree.root, testNum);
  
        	System.out.println("Post-order traversal of binary tree is "); 
        	tree.postOrderNumber(); 
        
        	System.out.println("\nPre-order traversal of binary tree is "); 
        	tree.preOrderNumber(); 
  
        	System.out.println("\nIn-order traversal of binary tree is "); 
        	tree.inOrderNumber(); 
        
        	System.out.println("\nFor " + testNode.value + ", post-position is " + testNode.postCount + ", pre-position is " + testNode.preCount + ", and in-position is " + testNode.inCount);
        }
    } 
} 
