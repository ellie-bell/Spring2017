/* Project4.java  InsertInOrder with bSearch optimization to compute insertion index */

import java.util.*;
import java.io.*;

public class Project4
{
	static final int INITIAL_CAPACITY = 5;

	public static void main( String args[] ) throws Exception
	{
		// ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED INPUT FILE NAME ON THE COMMAND LINE
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Project4 <input filename>\n\n"); // i.e. C:\> java Project4 P4input.txt
			System.exit(0);
		}

		// LOAD FILE INTO ARR USING INSERINORDER

		Scanner infile =  new Scanner( new File( args[0] ) );
		int[] arr = new int[INITIAL_CAPACITY];
		int count= 0;
		while (infile.hasNextInt())
		{
			if ( count==arr.length )
					arr = upSizeArr(arr);
			insertInOrder( arr, count++, infile.nextInt() );
		}
		infile.close();
		arr=trimArr(arr,count); // Now count == .length
		System.out.println( "Sorted array of " + arr.length + " ints from " + args[0] + " after insertInOrder:" );
		printArray( arr );  // we trimmed it thus count == length so we don't bother to pass in count

	} // END MAIN
	// ############################################################################################################

	// USE AS IS - DO NOT MODIFY
	static void printArray( int[] arr  )
	{
		for( int i=0 ; i<arr.length ;++i )
			System.out.print(arr[i] + " " );
		System.out.println();
	}

	// USE AS IS - DO NOT MODIFY
	static int[] upSizeArr( int[] fullArr )
	{
		int[] upSizedArr = new int[ fullArr.length * 2 ];
		for ( int i=0; i<fullArr.length ; ++i )
			upSizedArr[i] = fullArr[i];
		return upSizedArr;
	}

	// USE AS IS - DO NOT MODIFY
	static int[] trimArr( int[] oldArr, int count )
	{
		int[] trimmedArr = new int[ count ];
		for ( int i=0; i<count ; ++i )
			trimmedArr[i] = oldArr[i];
		return trimmedArr;
	}

	// ############################################################################################################
	static void insertInOrder( int[] arr, int count, int key   )
	{
		int index = bSearch( arr, count, key ); // LEAVE THIS HERE
		
	
		if ( index < 0 )
		{
			index = -(index +1 );
		}
		
		for (int i = count-1 ; (i >= index ) ; i--)
		{	
			arr[i+1]= arr[i];		
		}
		
		arr[index] = key;
		
	}


	// IF KEY EXISTS IN THE ARRAY RETURN indexWhereFound
	// ELSE FIGURE OUT THE indexWhereItBelongs
	// AND return -(indexWhereItBelongs+1);
	//
	static int bSearch(int[] a, int count, int key)
	{
		int lo = 0;
		int high = count - 1;
		while( lo <= high )
		{
			int m = lo + ((high - lo)/2);
			if( a[m] == key )
			{
				return m;
			}
			if( a[m] < key )
			{
				lo = m + 1;
			}
			if ( a[m] > key )
			{
				high = m - 1;
			}
			
		}
		
			return - ( lo + 1); // JUST TO MAKE IT COMPILE
	}
	
} // END PROJECT4

