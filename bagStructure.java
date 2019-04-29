public class bagStructure {

	//array to store items.
    private Object[] items;
    
    //size of bag.
    private int numItems;
    
    //maximum size of bag array.
    public static final int MAX_SIZE = 50;
    
    public bagStructure() {
        this.items = new Object[MAX_SIZE];
        this.numItems = 0;
    }
    
    //create new bag.
    public bagStructure(int maxSize) {
        this.items = new Object[maxSize];
        this.numItems = 0;
    }
    
    //method to return size of bag.
    public int numItems() {
        return this.numItems;
    }
    
    //method to add item to bag. returns true if item can be added, false if bag is full.
    public boolean add(Object item) {
        if (this.numItems == this.items.length) {
            return false;    //bag is full.
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }
    
    //method to remove an item from the bag, if it is in the bag. returns true on success, false if item is not in bag.
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                //shift remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                
                this.items[this.numItems - 1] = null;
                
                this.numItems--;
                return true;
            }
        }
        
        return false;  //if item is not found.
    }
    
    //method to determine if an item is in the bag. returns true if found, false if not.
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    //find - method to find an element, x, in the bag and return it.
    public Object find(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return this.items[i];
            }
        }
		return 0;
    }
    
    //findAll - method to find all elements equal to x and return them.
    public Object [] findAll(Object item) {
    	Object[] foundItems = new Object[this.numItems];
    	
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                foundItems[i] = this.items[i];
            }
        }
        return foundItems;
    }
    
    //method to convert bag to a string that can be printed.
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }
        
        str = str + "}";
        return str;
    }
    
    //driver code to test implementation.
    public static void main(String[] args) {
        //create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        //get size from user input and create a new bag.
        System.out.print("size of bag: ");
        int size = scan.nextInt();
        bagStructure bag = new bagStructure(size);
        scan.nextLine();
        
        //read in strings, add them to bag, and print out bag.
        String itemStr;        
        for (int i = 0; i < size; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag.add(itemStr);
        }
        System.out.println("bag = " + bag);
        System.out.println();
        
        //find an item in the bag.
        System.out.print("item to find: ");
        itemStr = scan.nextLine();
        
        if (bag.contains(itemStr)) {
        	System.out.println("the bag contains this item! the element is: " + bag.find(itemStr));
        }
        
        else
        	System.out.println("this item is not in the bag");
        
        //find all items in the bag that match the given item.
        System.out.print("item to find all of: ");
        String itemAll;
        itemAll = scan.nextLine();
        
        if (bag.contains(itemAll)) { 
        	System.out.println("the bag contains this item! here are the elements: ");
            for (int i = 0; i < bag.findAll(itemAll).length; i++) {
            	if (bag.findAll(itemAll)[i] != null)
            		System.out.print(bag.findAll(itemAll)[i] + " ");
            }
        }
        
        else
        	System.out.println("this item is not in the bag");
        System.out.println();
        
        //remove an element from the bag and reprint.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag.contains(itemStr)) {
            bag.remove(itemStr);
        }
        System.out.println("bag = " + bag);
        System.out.println();
    }
}
