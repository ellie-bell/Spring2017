// Project2.java

import java.io.*; // BufferedReader
import java.util.*; // Scanner

public class Project2
{
	public static void main (String args[]) throws Exception
	{
		// ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED CMD ARGS
		if (args.length < 3)
		{
			System.out.println("\nusage: C:\\> java Project2 <input file name> <lo>  <hi>\n\n"); 
			// i.e. C:\> java Project2 P2input.txt 1 30
			System.exit(0);
		}
		String infileName = args[0]; // i.e. L2input.txt
		int lo = Integer.parseInt( args[1] );   // i.e. 1
		int hi = Integer.parseInt( args[2] );   // i.e. 30

		// STEP #1: OPEN THE INPUT FILE AND COMPUTE THE MIN AND MAX. NO OUTPUT STATMENTS ALLOWED
		Scanner infile = new Scanner( new File(infileName) );
		int min,max;
		min=max=infile.nextInt(); // WE ASSUME INPUT FILE HAS AT LEAST ONE VALUE
		while ( infile.hasNextInt() )
		{
			int comparison = infile.nextInt();
			if (min >= comparison )
				min = comparison;
			if( comparison >= max)
					max = comparison;
			
		}
		System.out.format("min: %d max: %d\n",min,max); // DO NOT REMOVE OR MODIFY IN ANY WAY


		// STEP #2: DO NOT MODIFY THIS BLOCK
		// TEST EVERY NUMBER BETWEEN LO AND HI INCLUSIVE FOR
		// BEING PRIME AND/OR BEING PERFECT 
		for ( int i=lo ; i<=hi ; ++i)
		{
			System.out.print( i );
			if ( isPrime(i) ) System.out.print( " prime ");
			if ( isPerfect(i) ) System.out.print( " perfect ");
			System.out.println();
		}
	} // END MAIN
	
	// *************** YOU FILL IN THE METHODS BELOW **********************
	
	// RETURNs true if and only if the number passed in is perfect
	static boolean isPerfect( int n )
	{	
		boolean isPerfect = true;
		int sum = 0;
		for(int i = 1; i< n; i++)
		{
			if (n%i == 0)
				sum = sum + i;
					
		}
		if (sum != n)
			isPerfect=false;
			
		
		return isPerfect; // (just to make it compile) YOU CHANGE AS NEEDED
	}
	// RETURNs true if and only if the number passed in is prime
	static boolean isPrime( int n )
	{	
		boolean isPrime=true;
		for(int i = 2; i< n; i++)
		{
			if (n%i == 0 )
				isPrime = false;
		}
		if (n==1)
			isPrime = false;
		return isPrime; // (just to make it compile) YOU CHANGE AS NEEDED
	}
} // END PROJECT2 CLASS











