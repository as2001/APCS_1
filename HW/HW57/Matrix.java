/***
	Andrew Shao
	APCS1 pd1
	HW57 -- How Deep Does the Rabbit Hole Go?
	2017-12-20W
***/

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix( ) 
	{
		matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }//O(1)


  //constructor intializes an a*a matrix
  public Matrix( int a ) 
  {
	  matrix = new Object[a][a];
  }//O(1)


  //return size of this matrix, where size is 1 dimension
  private int size() 
  {
	  return matrix.length;
  }//O(1)


  //return the item at the specified row & column   
  private Object get( int r, int c ) 
  {
	  return matrix[c-1][r-1];
  }//O(1)


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty() 
  {
	  return equals(new Matrix(size()));
  }//O(1)


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal ) 
  {
	  Object retObj = matrix[c-1][r-1];
	  matrix[c-1][r-1] = newVal;
	  return retObj;
  }//O(1)


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString() 
  {
	  String retStr = "";
	  int strLen = 0;
	  String row = "";
	  for( Object[] col: matrix ) {
		  for( Object val: col ) {
			  if ( ("" + val).length() > strLen )
				  strLen = ("" + val).length();
		  }
	  }
	  retStr += " _ ";
	  for( int x = 0; x < size() * (strLen + 1) - 1; x ++ ) {
		  retStr += " ";
	  }
	  retStr += " _ \n";
	  for( int rowCtr = 0; rowCtr < size(); rowCtr ++ ) {
		  retStr += row;
		  row = "|  ";
		  for( Object[] column: matrix ) {
			  row += column[rowCtr];
			  for( int x = strLen; x >= (column[rowCtr] + "").length(); x -- )
				  row += " ";
		  }
		  row += " |\n";
	  }
	  row = row.substring(2, row.length() - 3);
	  row = "|_" + row + "_|\n";
	  retStr += row;
	  return retStr;
  }//O(n^3)


  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Object rightSide ) 
  {
	  Matrix rightSideM = (Matrix) rightSide;
	  if ( rightSideM instanceof Matrix ) {
		  for( Object[] columnL: matrix ) 
			  for( Object val1: columnL )
				  for( Object[] columnR: rightSideM.matrix )
					  for( Object val2: columnR )
						  if ( ! ("" + val1).equals("" + val2) )
							  return false;
		  return true;
	  }
	  return false;
  }//O(n^4)


  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) 
  {
	  Object[] temp = matrix[c1 - 1];
	  matrix[c1 - 1] = matrix[c2 - 1];
	  matrix[c2 - 1] = temp;
  }//O(1)


  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  ) 
  {
	  for( int colCtr = 1; colCtr <= size(); colCtr ++ )
		  set( r1, colCtr, set( r2, colCtr, get(r1,colCtr) ) );
  }//O(n)


  //main method for testing
  public static void main( String[] args ) 
  {
	  Matrix neo = new Matrix();
	  System.out.println("Matrix neo: \n" + neo);
	  System.out.println("neo size: " + neo.size());
	  System.out.println("value at (1, 1): " + neo.get(1,1));
	  System.out.println("neo is empty: " + neo.isEmpty());
	  
	  Matrix trinity = new Matrix();
	  System.out.println("\nMatrix trinity: \n" + trinity);
	  System.out.println("neo equals trinity: " + neo.equals(trinity));	  
	  
	  Matrix morpheus = new Matrix(5);
	  System.out.println("\nempty Matrix morpheus: \n" + morpheus);
	  for( int x = 1; x < 6; x ++ ) {
		  for( int y = 1; y < 6; y ++ )
			  morpheus.set(x,y,x+y);
	  }
	  System.out.println("populated Matrix morpheus: \n" + morpheus);
	  
	  morpheus.swapColumns(1,5);
	  System.out.println("morpheus after column swap: \n" + morpheus);
	  
	  morpheus.swapRows(1,5);
	  System.out.println("morpheus after row swap: \n" + morpheus);
  }

}//end class Matrix
