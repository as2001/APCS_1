// Andrew Shao
// APCS1 pd1
// HW47 -- ascending
// 2017-12-06

import java.util.ArrayList;

public class OrderedArrayList extends ArrayList<Comparable>
{
	
	public void add( int index, Comparable element )
	{
		if( get( index ).compareTo( element ) >= 0 && element.compareTo( get( index - 1 ) ) >= 0 )
			super.add( index, element );
		else
			throw new IndexOutOfBoundsException( "invalid index; list must remain sorted" );
	}
	
	
	public boolean add( Comparable element )
	{
		for( int x = 0; x < size(); x ++ )
		{
			if( get( x ).compareTo( element ) >= 0 )
			{
				super.add( x, element );
				return true;
			}
		}
		super.add( element );
		return true;
	}

	
    public static void main( String args[] )
    {
		
		OrderedArrayList mayfield = new OrderedArrayList();
        System.out.println("Printing empty ArrayList mayfield...");
        System.out.println(mayfield);
		
		mayfield.add(5);
		mayfield.add(6);
		mayfield.add(-5);
		mayfield.add(0);
		mayfield.add(-2);
		
		System.out.println("Printing SuperArray mayfield's capacity...");
        System.out.println(mayfield.size());
		
		System.out.println("Printing populated SuperArray mayfield...");
        System.out.println(mayfield);
		
		mayfield.remove(3);
        System.out.println("Printing SuperArray mayfield post-remove...");
        System.out.println(mayfield);
		
		mayfield.add(2,-1);
        System.out.println("Printing SuperArray mayfield post-insert...");
        System.out.println(mayfield);
		
		// uncommenting the following code should produce an error
        // mayfield.add(2,100);
        // System.out.println("Printing SuperArray mayfield post-insert...");
        // System.out.println(mayfield);
		
    }
	
}
