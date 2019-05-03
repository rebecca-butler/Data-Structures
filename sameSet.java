import java.util.Scanner;
import java.util.ArrayList;

class sameSet
{ 
    //method to merge two sub-arrays, arr[l..m] and arr[m+1..r]. this is done as part of the merge-sort.
    void merge(ArrayList<Integer> arr, int l, int m, int r) 
    { 
        //find the sizes of the two sub-arrays to be merged. 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        //create temporary arrays.
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        //copy data into temporary arrays.
        for (int i = 0; i < n1; ++i) 
            L[i] = arr.get(l + i); 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr.get(m + 1 + j); 
  
        //initial indices of the first and second sub-arrays. 
        int i = 0, j = 0; 

        int k = l; 
        
        //merge the two sub-arrays.
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr.set(k, L[i]); 
                i++; 
            } 
            
            else
            { 
            	arr.set(k, R[j]); 
              j++; 
            } 
            
            k++; 
        } 
  
        //copy remaining elements of L[].
        while (i < n1) 
        { 
        	arr.set(k, L[i]); 
            i++; 
            k++; 
        } 
  
        //copy remaining elements of R[].
        while (j < n2) 
        { 
            arr.set(k, R[j]); 
            j++; 
            k++; 
        } 
    } 
  
    //method to sort the array by calling the merge() function.
    void sort(ArrayList<Integer> arr, int l, int r) 
    { 
        if (l < r) 
        { 
            //find the middle of the array.
            int m = (l+r)/2; 
  
            //sort the first and second halves of the array. 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            //merge the sorted halves of the array.
            merge(arr, l, m, r); 
        } 
    } 
    
    //method to remove duplicate items from a sorted array.
    static void deleteDup(ArrayList<Integer> array, int size) {
    	for (int i = 1; i < size; i++) {
    		if (array.get(i) == array.get(i-1)) { //if there is a duplicate
    			array.remove(i); //remove duplicate from array
    			size--; //decrease size of array by 1
    			i--; //don't increment i
    		}
    	}
    }
    
    //method to check if the sorted sets are identical.
    static boolean checkSame(ArrayList<Integer> array1, ArrayList<Integer> array2, int size1, int size2) {
    	if (size1 != size2)
    		return false; //not identical if size is not the same
    	else {
    		for (int i = 0; i < size1; i++) {
        		if (array1.get(i) != array2.get(i)) //compare each element in order
        			return false;
    		}
    	}
    	return true;
    }
  
    //method to print the array lists.
    static void printArray(ArrayList<Integer> array) 
    { 
    	for (int i : array)
    	      System.out.println(i);
    } 
  
    //driver method to test the above functions.
    public static void main(String args[]) 
    { 
    	//create the set1 and set2 objects and array lists.
    	sameSet set1 = new sameSet(); 
    	sameSet set2 = new sameSet();
    	ArrayList<Integer> array1 = new ArrayList<Integer>();
    	ArrayList<Integer> array2 = new ArrayList<Integer>();
    	
    	//create a scanner object for user input.
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Enter the size of set 1: ");
    	int size1 = scan.nextInt();
    	
    	//add elements to the first set.
    	for(int i = 0; i < size1; i++) {
    		System.out.println("Enter element " + i + " for the first set: ");
    		array1.add(scan.nextInt());
    	}
    	
        System.out.println("First set: "); 
        printArray(array1);
        
    	System.out.println("Enter the size of set 2: ");
    	int size2 = scan.nextInt();
  
    	//add elements to the second set.
    	for(int i = 0; i < size2; i++) {
    		System.out.println("Enter element " + i + " for the second set: ");
    		array2.add(scan.nextInt());
    	}
        
        System.out.println("Second set: "); 
        printArray(array2); 
  
        //sort the sets.
        set1.sort(array1, 0, size1-1); 
        set2.sort(array2, 0, size2-1); 
        
        //delete duplicates before comparison is done.
        deleteDup(array1, size1);
        deleteDup(array2, size2);
        
        System.out.println("Sorted first set (without duplicates): "); 
        printArray(array1); 
        
        System.out.println("Sorted second set (without duplicates): "); 
        printArray(array2); 
        
        //check if the sorted set elements are equal.
        if (checkSame(array1, array2, array1.size(), array2.size()))
            System.out.println("The sequences contain the same set of elements!"); 
        
        else
            System.out.println("The sequences do not contain the same set of elements"); 
    } 
} 
