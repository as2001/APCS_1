// Andrew Shao
// APCS1 pd1
// HW48 -- Keep Guessing
// 2017-12-07

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre: int a and int b
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	/* YOUR IMPLEMENTATION HERE */
		_target = (int) (Math.random() * (b - a) + a);
		_guessCtr = 1;
		_lo = Math.min(a,b);
		_hi = Math.max(a,b);
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre: all instance variables initalized from constructor
      post: _guessCtr is equal to number of guesses 
      ==================================================*/
    public void playRec() 
    {
	/* YOUR IMPLEMENTATION HERE */
		System.out.print("Guess a # fr " + _lo + "-" + _hi + ": ");
		int guess = Keyboard.readInt();
		if( guess == _target ) {
			System.out.println("Correct! It took " + _guessCtr + " guesses");
			return;
		}
		if( guess < _target ) {
			System.out.println("Too low");
			_lo = guess + 1;
		}
		else {
			System.out.println("Too high");
			_hi = guess - 1;
		}
		_guessCtr ++;
		playRec();
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre: all instance variables initalized from constructor
      post: _guessCtr is equal to number of guesses
      ==================================================*/
	public void playIter() 
	{
		/* YOUR IMPLEMENTATION HERE */
		int guess;
		while( true ) {
			System.out.print("Guess a # fr " + _lo + "-" + _hi + ": ");
			guess = Keyboard.readInt();
			if( guess == _target ) {
				System.out.println("Correct! It took " + _guessCtr + " guesses");
				return;
			}
			if( guess < _target ) {
				System.out.println("Too low");
				_lo = guess + 1;
			}
			else {
				System.out.println("Too high");
				_hi = guess - 1;
			}
			_guessCtr ++;
		}
	}


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class
