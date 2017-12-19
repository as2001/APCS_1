//Andrew Shao
//APCS1 pd1
//HW55 -- Never Fear, Big Oh is Here!
//2017-12-15F

/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();    
  }


  public String toString()
  {
    return _data.toString(); 
  }


  public Comparable remove( int index )
  {	
    return _data.remove(index); 
  }


  public int size()
  { 
    return _data.size();
  }

    
  public Comparable get( int index )
  { 
    return _data.get(index); 
  }


  /***
   * add takes as input any comparable object 
   * (i.e., any object of a class implementing interface Comparable)
   * inserts newVal at the appropriate index
   * maintains ascending order of elements
   * uses a linear search to find appropriate index
   ***/
   //Execution time for ArrayList of size n: O(n) (linear)
   //Best case: appropriate index is 0 
   //Worst case: appropriate index is n-1
   //add utilizes linear search
  public void add( Comparable newVal )
  { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
	    }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end 
  }


  /***
   * addBin takes as input any comparable object 
   * (i.e., any object of a class implementing interface Comparable)
   * inserts newVal at the appropriate index
   * maintains ascending order of elements
   * uses a binary search to find appropriate index
   ***/
   //Execution time for ArrayList of size n: O(log2(n)) (logarithimic)
   //Best case: appropriate index is (n-1)/2
   //Worst case: appropriate index is 0,((n-1)/2)-1,((n-1)/2)+1, or n-1
   //addBin utilizes binary search
  public void addBin( Comparable newVal ) { 
    //initialize upperbound, lowerbound and median
    int lo = 0;
    int med = 0;
    int hi = _data.size()-1;

    while ( lo <= hi ) { //running until target is found or bounds cross

	    med = (lo + hi) / 2;
	    int x = _data.get(med).compareTo( newVal );
	        
	    if ( x == 0 ) { //equal value found, insert here
        _data.add( med, newVal );
        return;
	    }
	    else if ( x > 0 ) //newVal < med, so look at lower half of data
        hi = med - 1;
	    else //newVal > med, so look at upper half of data
        lo = med + 1;
    }
    // If you make it this far, newVal was not in the ArrayList.
    // So insert at lo. Q: How do you know lo is correct insertion index?
    _data.add( lo, newVal );
  }	
  

  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    /*
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );
    */
    
    // testing binary search
    for( int i = 0; i < 15; i++ )
      Franz.addBin( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
