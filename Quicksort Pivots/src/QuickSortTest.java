/** QuickSort.java: 
 *  Michael Madden, NUI Galway.
 *  Based on code from Goodrich & Tamassia, “Data Structures and Algorithms in Java”
 *  With some simplifications for clarity, and test code at the end.
 */

import javax.swing.JOptionPane;
import java.util.Comparator;


public class QuickSortTest
{
    /** QuickSort method:
	  * Sorts the elements of array arr in nondecreasing order according
	  * to comparator c, using the quick-sort algorithm. Most of the work
	  * is done by the auxiliary recursive method quickSortStep.
	  **/
	public static void quickSort (Object[] arr, Comparator c) {
	    if (arr.length < 2) return; // the array is already sorted in this case
	    
	    
	  //mid
	  		Object tempMiddle = arr[(arr.length-1)];
	  		arr[arr.length-1]= arr[(arr.length-1)/2];
	  		arr[0 + (arr.length-1)/2] = tempMiddle;
	  		
	  		//left
	  		//Object tempLeft = arr[(arr.length-1)];
	  		//arr[(arr.length-1)] = arr[0];
	  		//arr[0] = tempLeft;
	    
	    quickSortStep(arr, c, 0, arr.length-1); // call the recursive sort method
	    
	    
	}
	  
	/** QuickSortStep method: 
	  * Method called by QuickSort(), which sorts the elements of array s between
	  * indices leftBound and rightBound, using a recursive, in-place,
	  * implementation of the quick-sort algorithm.
	 **/
	private static void quickSortStep (Object[] s, Comparator c,
	                              int leftBound, int rightBound ) 
	{
	   if (leftBound >= rightBound) return; // the indices have crossed
	   Object temp;  // temp object used for swapping
	    
	   // Set the pivot to be the last element
	   Object pivotValue = s[rightBound];
	    
	   // Now partition the array 
	   int upIndex = leftBound;     // will scan rightward, 'up' the array
	   int downIndex = rightBound-1; // will scan leftward, 'down' the array
	   while (upIndex <= downIndex) 
	   { 
	       // scan right until larger than the pivot
	       while ( (upIndex <= downIndex) && (c.compare(s[upIndex], pivotValue)<=0) )
	    	   upIndex++; 
	       // scan leftward to find an element smaller than the pivot
	       while ( (downIndex >= upIndex) && (c.compare(s[downIndex], pivotValue)>=0))
	    	   downIndex--;
	       if (upIndex < downIndex) { // both elements were found
	          temp = s[downIndex]; 
		      s[downIndex] = s[upIndex]; // swap these elements
		      s[upIndex] = temp;
	       }
	   } // the loop continues until the indices cross
	    
	   int pivotIndex = upIndex;
	   temp = s[rightBound]; // swap pivot with the element at upIndex
	   s[rightBound] = s[pivotIndex]; 
	   s[pivotIndex] = temp; 
	 
	   // the pivot is now at upIndex, so recursively quicksort each side
	   quickSortStep(s, c, leftBound, pivotIndex-1);
	   quickSortStep(s, c, pivotIndex+1, rightBound);
	}

	
	/** M Madden: Main method to test QuickSort */
	public static void main(String[] args){
		
		String arr[] = createArray(12000);//This is a random array
		String arr2[] = arr.clone();//This is a sorted array(Ascending)
		quickSort(arr2, new StringComparator());
		
		//start timer
		long T1 = System.currentTimeMillis();
		//sort arr
		quickSort(arr, new StringComparator());
		//stop timer
		long T2 = System.currentTimeMillis();
		//print random array time
		System.out.println("The time for quickSorting a random array was\n " + (T2 - T1) + "mS");
		
		//start timer
		long T3 = System.currentTimeMillis();
		//sort arr2
		quickSort(arr2, new StringComparator());
		//stop timer
		long T4 = System.currentTimeMillis();
		//print sorted array time
		System.out.println("The time for quickSorting a sorted array was\n " + (T4 - T3) + "mS");
		//change pivot to mid/left & repeat 
		//System.out.println(array2String(arr));
		//System.out.println(array2String(arr2));
		

	}

	/** M Madden: utility method to return string representation of array of strings */
	private static String array2String(String[] a)
	{
		String text="[";
		for (int i=0; i<a.length; i++) {
			text += a[i];
			if (i<a.length-1)
				text += ",";
		}
		text += "]";
		return text;
	}
	private static String[] createArray(int n) {
		String refArr[];
		refArr = new String[n];
		//creates referene array
		for(int i = 0; i < n; i++) {
			//cycles through array values until value of n
			refArr[i]= String.valueOf(Math.random());
			//adds random numbers to array
		}
		return refArr; //returns array
	}
}


/** M Madden: Comparator class for case-insensitive comaprison of strings */
class StringComparator implements Comparator
{
	public int compare(Object ob1, Object ob2)
	{
		String s1 = (String)ob1;
		String s2 = (String)ob2;
		//return s1.compareTo(s2); // use compareTo for case-sensitive comparison
		return s1.compareToIgnoreCase(s2);
	}
}