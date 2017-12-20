/* Fraction.java  A class (data type) definition file
   This file just defines what a Fraction is
   This file is NOT a program
   ** data members are PRIVATE
   ** method members are PUBLIC
*/
public class Fraction
{
	private int numer;
	private int denom;
	// ACCESSORS
	public int getNumer()
	{
		return numer;
	}
	public int getDenom()
	{
		return denom;
	}
	public String toString()
	{
		return numer + "/" + denom;
	}

	// MUTATORS
	public void setNumer( int n )
	{
		numer = n;
	}
	public void setDenom( int d )
	{
		if (d!=0)
			denom=d;
		else
		{
			System.out.println("Error:  Negative denom");
      		System.exit(0);
		}
	}

	// DEFAULT CONSTRUCTOR - no args passed in
	public Fraction(  )
	{
		this( 0, 1 ); // "this" means call a fellow constructor
	}

	// 1 arg CONSTRUCTOR - 1 arg passed in
	// assume user wants whole number
	public Fraction( int n )
	{
		this( n, 1 ); // "this" means call a fellow constructor

	}

	// FULL CONSTRUCTOR - an arg for each class data member
	public Fraction( int n, int d )
	{
		// you could calc the gcd(n,d) here and then divide both by gcd in the setter calls
		setNumer(n); // i.e. setNumer( n/gcd );
		setDenom(d); // same here
		reduce();
	}

	// COPY CONSTRUCTOR - takes ref to some already initialized Fraction object
	public Fraction( Fraction other )
	{
		this( other.numer, other.denom ); // call my full C'Tor with other Fraction's data
	}
  	
  	private void reduce()
  	{
		
		int divisor = gcd (numer, denom);
		setNumer(numer/divisor);
		setDenom(denom/divisor);
		
	}	
  	private int gcd (int n, int d) 
  	{
      if (d == 0)
          return n;
      else
          return gcd(d, n%d);
	}
	
	public Fraction add( Fraction other) //returns a Fraction that is the sum of the two Fractions.
	{
		return ( new Fraction((this.numer * other.denom) + (other.numer * this.denom), this.denom  * other.denom));
	}
	public Fraction subtract( Fraction other) //returns a Fraction that is the difference between this Fraction minus the other Fraction.
	{
		return ( new Fraction((this. numer * other.denom) - (other.numer * this.denom), this.denom  * other.denom));
	}
	public Fraction multiply( Fraction other) //returns a Fraction that is the product of the two Fractions.
	{
		return ( new Fraction( this.numer * other.numer, this.denom * other.denom));
	}
	public Fraction divide( Fraction other)// returns a Fraction that is the quotient of the two Fractions.
	{
		return (new Fraction( this.numer * other.denom, this.denom * other.numer));
	}
	public Fraction reciprocal() 
	{
		return ( new Fraction(this.denom, this.numer)) ;

	}
}// EOF