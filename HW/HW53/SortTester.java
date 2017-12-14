// Andrew Shao and Clarence Cheng
// APCS1 pd1
// HW53 -- Solid Comparative Analysis
// 2017-12-14R

import java.util.ArrayList;

public class SortTester
{
	
	//~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
	//precond: lo < hi && size > 0
	//postcond: returns an ArrayList of random integers
	//          from lo to hi, inclusive
	public static ArrayList populate( int size, int lo, int hi ) {
		ArrayList<Integer> retAL = new ArrayList<Integer>();
		while( size > 0 ) {
			//     offset + rand int on interval [lo,hi]
			retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
			size--;
		}
		return retAL;
	}

	//randomly rearrange elements of an ArrayList
	public static void shuffle( ArrayList al ) {
		int randomIndex;
		for( int i = al.size()-1; i > 0; i-- ) {
			//pick an index at random
			randomIndex = (int)( (i+1) * Math.random() );
			//swap the values at position i and randomIndex
			al.set( i, al.set( randomIndex, al.get(i) ) );
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~~~~~~~~~ MAIN METHOD ~~~~~~~~~~~~~~~~~~~~
	public static void main( String args[] ) {
		
		/*	The best case scenario for bubbleSort is an already ordered ArrayList.
			At every index x bubbleSort iterates through, the value at index x will never be greater
			than the value at index x+1 if the ArrayList is already sorted.
			This means bubbleSort will make 0 swaps, the least possible number of swaps.	*/
		ArrayList bestCaseBub = new ArrayList<Integer>();
		for( int x = 0; x < 10; x ++ )
			bestCaseBub.add(x);		
		System.out.println( "\nArrayList bestCaseBub before sorting:\n" + bestCaseBub );
		MySorts.bubbleSort(bestCaseBub);
		System.out.println( "\nArrayList bestCaseBub after sorting:\n" + bestCaseBub );
		
		/* 	The worst case scenario for bubbleSort is an ArrayList with its values in descending order.
			At every index x bubbleSort iterates through, the value at index x will always be greater
			than the value at index x+1 if the ArrayList is in descending order.
			This means bubbleSort will make (y*(y-1))/2 swaps for an ArrayList of size y, 
			the greatest possible number of swaps.	*/
		ArrayList worstCaseBub = new ArrayList<Integer>();
		for( int x = 0; x < 10; x ++ )
			worstCaseBub.add(9-x);		
		System.out.println( "\nArrayList worstCaseBub before sorting:\n" + worstCaseBub );
		MySorts.bubbleSort(worstCaseBub);
		System.out.println( "\nArrayList worstCaseBub after sorting:\n" + worstCaseBub );
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		/*	The best case scenario for selectionSort is an ArrayList with the greatest value at index 0
			and the rest of the values following it in ascending order.
			For every pass selectionSort makes, selectionSort will always make a swap regardless of
			order so number of swaps will always equal the size of the ArrayList minus 1.
			But for every pass maxPos will never be overwritten from zero since the nth largest number
			will always end up at index 0 after a swap/pass occurs, where n-1 is the pass number.
			This means selectionSort will make 0 overwrites, the least possible number of overwrites.	*/
		ArrayList bestCaseSel = new ArrayList<Integer>();
		bestCaseSel.add(9);
		for( int x = 0; x < 9; x ++ )
			bestCaseSel.add(x);
		System.out.println( "\nArrayList bestCaseSel before sorting:\n" + bestCaseSel );
		MySorts.selectionSort(bestCaseSel);
		System.out.println( "\nArrayList bestCaseSel after sorting:\n" + bestCaseSel );
		
		/* 	The worst case scenario for selectionSort is an already ordered ArrayList.
			For every pass selectionSort makes, selectionSort will always make a swap regardless of
			order so number of swaps will always equal the size of the ArrayList minus 1.
			But for every index selectionSort iterates through during every pass, maxPos will always be
			overwritten from zero since the nth largest number will always be at the last index
			iterated through during pass n-1.
			This means selectionSort will make (y*(y-1))/2 overwrites for an ArrayList of size y, 
			the greatest possible number of overwrites.	*/
		ArrayList worstCaseSel = new ArrayList<Integer>();
		for( int x = 0; x < 10; x ++ )
			worstCaseSel.add(x);
		System.out.println( "\nArrayList worstCaseSel before sorting:\n" + worstCaseSel );
		MySorts.selectionSort(worstCaseSel);
		System.out.println( "\nArrayList worstCaseSel after sorting:\n" + worstCaseSel );
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		/* 	The best case scenario for insertionSort is an already ordered ArrayList.
			At every index x insertionSort iterates through, the value at index x will never be greater
			than the value at index x+1 if the ArrayList is already sorted.
			This means insertionSort will make 0 swaps, the least possible number of swaps.	*/
		ArrayList bestCaseIns = new ArrayList<Integer>();
		for( int x = 0; x < 10; x ++ )
			bestCaseIns.add(x);		
		System.out.println( "\nArrayList bestCaseIns before sorting:\n" + bestCaseIns );
		MySorts.insertionSort(bestCaseIns);
		System.out.println( "\nArrayList bestCaseIns after sorting:\n" + bestCaseIns );
		
		/* The worst case scenario for insertionSort is an ArrayList with its values in descending order.
			At every index x insertionSort iterates through, the value at index x will always be greater
			than the value at index x+1 if the ArrayList is in descending order.
			This means insertionSort will make (y*(y-1))/2 swaps for an ArrayList of size y, 
			the greatest possible number of swaps.	*/
		ArrayList worstCaseIns = new ArrayList<Integer>();
		for( int x = 0; x < 10; x ++ )
			worstCaseIns.add(9-x);		
		System.out.println( "\nArrayList worstCaseIns before sorting:\n" + worstCaseIns );
		MySorts.insertionSort(worstCaseIns);
		System.out.println( "\nArrayList worstCaseIns after sorting:\n" + worstCaseIns );
		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
}