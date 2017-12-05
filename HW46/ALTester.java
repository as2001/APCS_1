// Andrew Shao
// APCS1 pd1
// HW46 -- Al<B> Sorted!. 
// 2017-12-05

import java.util.ArrayList;

public class ALTester
{
	
	public static void main( String args[] )
	{
		
		ArrayList<Comparable> Arr = new ArrayList<Comparable>();
		
		for( int x = 0; x < 23; x ++)
			Arr.add( x );
		
		System.out.println( Arr );
		
		int ctr = 0;
		
		for( int x = 22; (x >= 1) && (Arr.get( x ).compareTo( Arr.get( x - 1 ) ) > 0); x -- )
			ctr ++;
		
		System.out.println( ctr == 22 );
	}
	
}