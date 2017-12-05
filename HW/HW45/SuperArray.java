// Andrew Shao
// APCS1 pd1
// HW45 -- In America, the Driver Sits on the Left
// 2017-12-4

/***************************
 * class SuperArray version 3.0
 * ( SKELETON )
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * List interface. (List.java must be in same dir as this file)
 ***************************/

public class SuperArray implements List
{

  private Object[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new Object[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ )
      foo += get( i ) + ",";
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    Object temp[] = new Object[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = get( i );
    _data = temp;
  }


  //accessor -- return value at specified index
  public Object get( int index )
  {
	if( index < 0 || index >= size() )
	  throw new IndexOutOfBoundsException( "invalid index; index out of bounds" );
    return _data[index];
  }
    

  //mutator -- set value at index to newVal,
  //           return old value at index
  public Object set( int index, Object newVal )
  {
	if( index < 0 || index >= size() )
	  throw new IndexOutOfBoundsException( "invalid index; index out of bounds" );
    Object retObj = _data[index];
    _data[index] = newVal;
    return retObj;
  }


  //adds an item after the last item
  public boolean add( Object newVal )
  {
    add( _size, newVal );
	return true;
  }


  //inserts an item at index
  public void add( int index, Object newVal )
  {	
    _size ++;
	if ( index < 0 || index >= size() )
		throw new IndexOutOfBoundsException( "invalid index; index out of bounds" );
    //first expand if necessaryz
    if ( _size >= _data.length )
      expand();
    for( int i = _size; i > index; i-- )
      _data[i] = _data[i-1]; //each slot gets value of left neighbor
    set( index, newVal );
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public Object remove( int index )
  {
	if( index < 0 || index >= size() )
	  throw new IndexOutOfBoundsException( "invalid index; index out of bounds" );
	Object retObj = get( index );
    for( int i = index; i < _size - 1; i++ )
      set( i, get( i + 1 ) );
    _size--;
	return retObj;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
    List mayfield = new SuperArray();
    System.out.println("Printing empty SuperArray mayfield...");
    System.out.println(mayfield);
	System.out.println(mayfield.size());

    System.out.println(mayfield.add(5));// true
    System.out.println(mayfield.add(4.0));// true
    System.out.println(mayfield.add("abc"));// true
    System.out.println(mayfield.add(true));// true

    System.out.println("Printing populated SuperArray mayfield...");
    System.out.println(mayfield);
	
	System.out.println(mayfield.get(0));// 5
	System.out.println(mayfield.get(1));// 4.0
	System.out.println(mayfield.get(2));// abc
	System.out.println(mayfield.get(3));// true
	
	System.out.println(mayfield.set(0, 6));// 5
	System.out.println(mayfield.set(1, 3.9));// 4.0
	System.out.println(mayfield.set(2, "def"));// abc
	System.out.println(mayfield.set(3, false));// true

	System.out.println("Printing SuperArray mayfield post-changes...");
    System.out.println(mayfield);
    /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class


/***
             ,,########################################,,
          .*##############################################*
        ,*####*:::*########***::::::::**######:::*###########,
      .*####:    *#####*.                 :*###,.#######*,####*.
     *####:    *#####*                      .###########*  ,####*
  .*####:    ,#######,                        ##########*    :####*
  *####.    :#########*,                       ,,,,,,,,.      ,####:
    ####*  ,##############****************:,,               .####*
     :####*#####################################**,        *####.
       *############################################*,   :####:
        .#############################################*,####*
          :#####:*****#####################################.
            *####:                  .,,,:*****###########,
             .*####,                            *######*
               .####* :*#######*               ,#####*
                 *###############*,,,,,,,,::**######,
                   *##############################:
                     *####*****##########**#####*
                      .####*.            :####*
                        :####*         .#####,
                          *####:      *####:
                           .*####,  *####*
                             :####*####*
                               *######
                                 *##

         -Miranda Chaiken '16

         ***/
