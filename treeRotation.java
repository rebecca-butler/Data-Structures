import java.util.Scanner;

//define the node class.
class Node {
    int key; //value of node
    Node left; //left child of node
    Node right; //right child of node
    int height; //height of node

    Node(int value) {
        key = value;
        left = null;
        right = null;
        height = 1;
    }
}

class treeRotation {
	
    static Node root;

    //method to return height of tree, starting at root.
    static int height(Node root) {
        if (root == null)
            return 0;

        return root.height;
    }

    int findHeight() {
        return height(root);
    }

    //method to return height of tree, starting at the node with the given value.
    int findHeightFrom(int value) {
        Node Node = search(root, value);
        if (Node == null)
            return -1;

        return Node.height;
    }

    //method to search for a given value in the tree.
    Node search(Node root, int value) {
        if (root == null)
            return null;
        else {
            if (value == root.key)
                return root;
            else if (value < root.key)
                return search(root.left, value); //recursively search left subtree.
            else
                return search(root.right, value); //recursively search right subtree.
        }
    }

    //method to determine if a given value is in the tree. returns true if found, false if not.
    boolean find(int value) {
        Node Node = search(root,value);

        if (Node == null)
            return false;

        return true;
    }

    //method determine which of the two given integers is higher, and return the higher value.
    static int max(int one, int two) {
        return (one > two) ? one : two;
    }

    //method to rotate a BST right.
    static Node rightRotate(Node root) {
        Node rootLeftChild = root.left;
        root.left = rootLeftChild.right;
        rootLeftChild.right = root;

        root.height = max(height(root.left), height(root.right)) + 1; //return the height of the higher subtree + 1.
        rootLeftChild.height = max(height(rootLeftChild.left), height(rootLeftChild.right)) + 1;

        return rootLeftChild;
    }

    //method to rotate a BST left.
    static Node leftRotate(Node root) {
        Node rootRightChild = root.right;
        root.right = rootRightChild.left;
        rootRightChild.left = root;

        root.height = max(height(root.left), height(root.right)) + 1; //return the height of the higher subtree + 1.
        rootRightChild.height = max(height(rootRightChild.left), height(rootRightChild.right)) + 1;

        return rootRightChild;
    }

    //method to add a node to the tree while self-balancing to maintain the BST property.
    Node insertNode(Node root, int value) {
        if (root == null)
            root = new Node(value);
        
        else {
            if (value < root.key)
                root.left = insertNode(root.left, value); //recursively insert in left subtree.
            else
                root.right = insertNode(root.right, value); //recursively insert in right subtree.
        }

        root.height = max(height(root.left), height(root.right)) + 1;

        int balanceFactor = height(root.left) - height(root.right);

        if (balanceFactor > 1) {
            //either left-left case or left-right case.
            if (value < root.left.key) {
                // left-left case
                root = rightRotate(root);
            } else {
                //left-right case.
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        } else if (balanceFactor < -1) {
            //either right-right case or right-left case.
            if (value > root.right.key) {
                //right-right case.
                root = leftRotate(root);
            } else {
                //right-left case.
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }

        return root;
    }

    void insert(int value) {
        root = insertNode(root, value);
    }

    //method to return the in-order traversal of the tree.
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    void inorderTraversal() {
        inorder(root);
        System.out.println();
    }

    //method to return the pre-order traversal of the tree.
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void preorderTraversal() {
        preorder(root);
        System.out.println();
    }

    //driver method to test the above functions.
    public static void main(String[] args) {
    	
        treeRotation BST = new treeRotation();
        
        //scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        char choice; //the user's choice.
        
        do {
        	System.out.println("Enter an integer to add to tree: ");
        	BST.insert(scan.nextInt());
            System.out.println("\nDo you want to continue adding? (Type y or n) \n");
            choice = scan.next().charAt(0);                        
        } while (choice == 'Y'|| choice == 'y');  

        //print in-order and pre-order traversals of tree.
        System.out.print("Inorder Traversal : "); 
        BST.inorderTraversal();
        System.out.print("Preorder Traversal : "); 
        BST.preorderTraversal();

        System.out.print("Type L to flip left or R to flip right");
        
        choice = scan.next().charAt(0);  
        
        switch (choice)
        {
        	case 'L' : 
                System.out.println("Flipping left");
                root = leftRotate(root);
                break;                          
            case 'R' :                 
                System.out.println("Flipping right");
                root = rightRotate(root);
                break;                         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
        } 
        
        //print in-order and pre-order traversals of rotated tree.
        System.out.print("The new inorder traversal is: "); 
        BST.inorderTraversal();
        System.out.print("The new preorder traversal is: "); 
        BST.preorderTraversal();
        
        scan.close(); 
    }
}
