import java.util.Scanner;

class hashTable
{
	//variables for current size, maximum size, and an array of keys that will be in the hash table.
    private int currentSize, maxSize;
    int[] keys; 
 
    //constructor.
    public hashTable() 
    {
        currentSize = 0;
        maxSize = 20; //default max size for this test is 20.
        keys = new int[maxSize];
    }  
 
    //method to make an empty hash table.
    public void makeEmpty()
    {
        currentSize = 0;
        keys = new int[maxSize];
    }
 
    //method to return size of hash table.
    public int getSize() 
    {
        return currentSize;
    }
 
    //method to return hash code (index) of a given key.
    private int hash(int key) 
    {
        return (key % 13); //K mod 13 is the hash function that determines the index.
    }    
 
    //method to insert a key into the hash table.
    public void insert(int key) 
    {                
        int tmp = hash(key);
        int i = tmp;
        do
        {
            if (keys[i] == 0) //if the spot at index i is not already taken, put the key in.
            {
                keys[i] = key;
                currentSize++;
                return;
            }
            i = (i + 1) % maxSize; //if the spot is full, implement linear probing.   
        } while (i != tmp);       
    }
 
    //method to print hash table.
    public void printHashTable()
    {
        System.out.println("Hash table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != 0)
                System.out.println(keys[i] + " ");
        System.out.println();
    }   
 
    //driver function to test program.
    public static void main(String[] args)
    {
        hashTable table = new hashTable();

        //create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Type 0 to see the sample hash table. Type 1 to make your own hash table with a max size of 20.");
        int choice = scan.nextInt();
        
        if (choice == 0) {
            table.insert(1);
            table.insert(5);
            table.insert(21);
            table.insert(26);
            table.insert(39);
            table.insert(14);
            table.insert(15);
            table.insert(16);
            table.insert(17);
            table.insert(18);
            table.insert(19);
            table.insert(20);
            table.insert(111);
            table.insert(145);
            table.insert(146);
            
            table.printHashTable();
        }
        
        else if (choice == 1) {
        	char ch;
        	do {
        		System.out.println("Enter an integer: ");
            	table.insert(scan.nextInt());
            	System.out.println("Type y to continue, or type n to stop and print the table.");
            	ch = scan.next().charAt(0);
        	} while (ch == 'y');
        	table.printHashTable();
        }
        
        else
        	System.out.print("Invalid entry");

    }
}
