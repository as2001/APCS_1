// Andrew Shao
// APCS1 pd1
// HW45 -- In America, the Driver Sits on the Left
// 2017-12-4

/***************************
 * interface List
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of objects.
 ***************************/

public interface List
{
	// Append an object to the end. Return true.
	boolean add( Object x );
	
	// Retrieve the object at index
	Object get( int index );
	
	// Overwrite the int at index
	Object set( int index, Object o );
	
	// Return number of elements in the list
	int size();
	
}