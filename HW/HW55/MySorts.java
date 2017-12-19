// Andrew Shao and Clarence Cheng
// APCS1 pd1
// HW55 -- Never Fear, Big Oh Is Here!
// 2017-12-15F

import java.util.ArrayList;

public class MySorts
{
	
	//add
	//Execution time for ArrayList of size n: O(n) (linear)
	//Best case: appropriate index is 0 
	//Worst case: appropriate index is n-1
	//add utilizes linear search
	
	//addBin
	//Execution time for ArrayList of size n: O(log2(n)) (logarithimic)
	//Best case: appropriate index is (n-1)/2
	//Worst case: appropriate index is 0,((n-1)/2)-1,((n-1)/2)+1, or n-1
	//addBin utilizes binary search

	// bubbleSort
	// Rearranges elements of input ArrayList
	// postcondition: data's elements sorted in ascending order
	public static void bubbleSort( ArrayList<Comparable> data )
	{	
		//swapCtr keeps track of how many swaps method will make when sorting data
		int swapCtr = 0;
		
		//make n-1 passes across collection
		for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
			//System.out.println( "commencing pass #" + passCtr + "..." );

			//iterate from first to next-to-last element
			for( int i = 0; i < data.size()-1; i++ ) {
				//if element at i > element at i+1, swap
				if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) {
				data.set( i, data.set(i+1,data.get(i)) );   
				swapCtr ++;
				}
				//System.out.println(data); //diag: show current state of list
			}
		}
		System.out.println("# of swaps: " + swapCtr);
	}

	// selectionSort
	// Rearranges elements of input ArrayList
	// postcondition: data's elements sorted in ascending order
	public static void selectionSort( ArrayList<Comparable> data ) 
	{
		//note: this version places greatest value at rightmost end,

		//maxPos will point to position of SELECTION (greatest value)
		int maxPos;
		//swapCtr keeps track of how many swaps method will make when sorting data
		int swapCtr = 0;
		//overwriteCtr keeps track of how many times maxPos is overwritten
		int overwriteCtr = 0;

		for( int pass = data.size()-1; pass > 0; pass-- ) {
			//System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
			maxPos = 0;
			for( int i = 1; i <= pass; i++ ) {
				//System.out.println( "maxPos: " + maxPos );//diag
				//System.out.println( data );//diag
				if ( data.get(i).compareTo( data.get(maxPos) ) > 0 ) {
				maxPos = i;
				overwriteCtr ++;
				}
			}
			data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
			swapCtr ++;
			//System.out.println( "after swap: " +  data );//diag
		}
		System.out.println("# of swaps: " + swapCtr);
		System.out.println("# of times maxPos was overwritten: " + overwriteCtr);
	}//end selectionSortV

	// insertionSort
	// Rearranges elements of input ArrayList
	// postcondition: data's elements sorted in ascending order
	public static void insertionSort( ArrayList<Comparable> data )
	{
		//swapCtr keeps track of how many swaps method will make when sorting data
		int swapCtr = 0;
		
		for( int partition = 1; partition < data.size(); partition++ ) {
			//partition marks first item in unsorted region

			//diag:
			//System.out.println( "\npartition: " + partition + "\tdataset:");
			//System.out.println( data ); 

			//traverse sorted region from right to left
			for( int i = partition; i > 0; i-- ) {

				// "walk" the current item to where it belongs
				// by swapping adjacent items
				if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
					//diag:
					//System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
					data.set( i, data.set( i-1, data.get(i) ) ); 
					swapCtr ++;
				}
				else 
				break; 
			}
		}
		System.out.println("# of swaps: " + swapCtr);
	}//end insertionSortV
	
}