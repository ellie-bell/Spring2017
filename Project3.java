/* Project3.java  Dynamic histogram */

import java.io.*;
import java.util.*;

public class Project3
{
	static final int INITIAL_CAPACITY = 10;
	public static void main (String[] args) throws Exception
	{
		// ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED INPUT FILE NAME ON THE COMMAND LINE
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Project3 <input filename>\n\n"); // i.e. C:\> java Project3 dictionary.txt
			System.exit(0);
		}
		int[] histogram = new int[0]; // histogram[i] == # of words of length n

		/* array of String to store the words from the dictionary. 
			We use BufferedReader (not Scanner). With each word read in, examine it's length and update word length frequency histogram accordingly.
		*/

		String[] wordList = new String[INITIAL_CAPACITY];
		int wordCount = 0;
		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
		while ( infile.ready() )
		{
			String word = infile.readLine();
			int n = word.length();
			if ( wordCount == wordList.length ) 
			{
				wordList = upSizeArr( wordList );
			}
			wordList[wordCount++] = word;
			
			if( n >= histogram.length )
			{
				histogram=  upSizeHisto ( histogram,n);
			}
			++histogram[n]; 	
						
			
		}
		infile.close();

		wordList = trimArr( wordList, wordCount );
		System.out.println( "After final trim: wordList length: " + wordList.length + " wordCount: " + wordCount );

		// PRINT WORD LENGTH FREQ HISTOGRAM
		for ( int i = 0; i < histogram.length ; i++ )
			System.out.format("words of length %2d  %d\n", i,histogram[i] );

	} // END main

	// YOU MUST CORRECTLY COPY THE STRING REFS FROM THE OLD ARR TO THE NEW ARR
	static String[] upSizeArr( String[] fullArr )
	{	
		String[] bigArray = new String[fullArr.length*2];
		for ( int i = 0; i <= fullArr.length-1; i++)
		{	
			bigArray[i]= fullArr[i];
		}
		return bigArray;
	}
	static String[] trimArr( String[] arr, int count )
	{
		String fitArr[]= new String [count];
		for ( int i = 0; i <= count-1; i++)
			fitArr[i]= arr[i];
		return fitArr;
	}

	// YOU MUST CORRECTLY COPY THE COUNTS FROM OLD HISTO TO NEW HISTO
	static int[] upSizeHisto( int[] oldArr, int newLength )
	{
		int [] histoLarge = new int[newLength+1];
		for ( int i = 0; i < oldArr.length; i++)
		{	
			histoLarge[i] = oldArr[i];
		}
		return histoLarge;
	}
} // END CLASS PROJECT#3