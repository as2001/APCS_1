/***************************
* class SuperArray
* Wrapper class for array. Facilitates resizing,
* getting and setting element values.
***************************/

public class SuperArray
{

	private int[] _data;  //underlying container
	private int _size;    //number of elements in this SuperArray


	//default constructor – initializes 10-item array
	public SuperArray()
	{
		/* YOUR IMPLEMENTATION HERE */
		_data = new int[10];
		_size = 10;
	}


	//output SuperArray in [a,b,c] format
	public String toString()
	{
		/* YOUR IMPLEMENTATION HERE */
		String retStr = "[";
		for(int x: _data)
		retStr += x + ",";
		retStr = retStr.substring( 0, retStr.length() - 1 ) + "]";
		return retStr;
	}


	//double capacity of SuperArray
	private void expand()
	{
		/* YOUR IMPLEMENTATION HERE */
		int[] temp = new int[_size * 2];
		for(int index = 0; index < _size; index ++)
		temp[index] = _data[index];
		_size *= 2;
		_data = new int[_size];
		_data = temp;
	}


	//accessor -- return value at specified index
	public int get( int index )
	{
		/* YOUR IMPLEMENTATION HERE */
		return _data[index];		
	}


	//mutator -- set value at index to newVal,
	//           return old value at index
	public int set( int index, int newVal )
	{
		/* YOUR IMPLEMENTATION HERE */
		int temp = get( index );
		_data[index] = newVal;
		return temp;
	}


	//main method for testing
	public static void main( String[] args )
	{
		
		SuperArray curtis = new SuperArray();
		System.out.println( "Printing empty SuperArray curtis..." );
		System.out.println( curtis );
		
		for( int i = 0; i < curtis._data.length; i++ ) {
			curtis.set( i, i * 2 );
		}

		System.out.println("Printing populated SuperArray curtis...");
		System.out.println(curtis);

		for( int i = 0; i < 3; i++ ) {
			curtis.expand();
			System.out.println("Printing expanded SuperArray curtis...");
			System.out.println(curtis);
		}
		/*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
	}//end main()


}//end class
