import java.io.*;
import java.util.*;
// DO NOT IMPORT JAVA.LANG;

public class Project9 // the swamp
{
    public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		int[][] swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];

		String path = "";
		findPath( row, col, swamp, path );

	} // END MAIN

	private static void  findPath(int r, int c, int[][] swamp, String path )
    {
		path += "[" + r + "," + c + "]"; //  "[3,4]"

		if ( (r==0 || c==0) || (r == swamp.length-1 || c == swamp.length-1) )
		{		System.out.println(path);
				return;
		}

		if ( swamp[r-1][c] == 1) // NORTH 
		{
				swamp[r][c] = -1; 
				findPath( r-1, c, swamp, path );
				swamp[r][c] = 1;
		}
		if(swamp[r-1][c+1] == 1)
		{
				swamp[r][c] = -1; 
				findPath( r-1, c+1, swamp, path );
				swamp[r][c] = 1;
		}
		if(swamp[r][c+1] == 1)
		{
				swamp[r][c] = -1; 
				findPath( r, c+1, swamp, path );
				swamp[r][c] = 1;
		}
		if(swamp[r+1][c+1] == 1)
		{
				swamp[r][c] = -1; 
				findPath( r+1, c+1, swamp, path );
				swamp[r][c] = 1;
		}
		if(swamp[r+1][c] == 1)
		{
				swamp[r][c] = -1; 
				findPath( r+1, c, swamp, path );
				swamp[r][c] = 1;
		}
		if(swamp[r+1][c-1] == 1)
		{
				swamp[r][c] = -1; 
				findPath( r+1, c-1, swamp, path );
				swamp[r][c] = 1;
		}
		if(swamp[r][c-1] == 1)
		{
				swamp[r][c] = -1; 
				findPath( r, c-1, swamp, path );
				swamp[r][c] = 1;
		}
		if(swamp[r-1][c-1] == 1)
		{
				swamp[r][c] = -1; 
				findPath( r-1, c-1, swamp, path );
				swamp[r][c] = 1;
		}
	} // ENd Of DFS  means return
	
	// DO NOT MODIFY THIS METHOD
   	// ----------------------------------------------------------------
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		Scanner infile = new Scanner( new File(infileName) );
		int rows=infile.nextInt();
		int cols = rows;  		// ASSUME A SQUARE GRID
		dropInPt[0]=infile.nextInt();  dropInPt[1]=infile.nextInt();
		int[][] swamp = new int[rows][cols];
		for(int r = 0; r < rows ; r++)
			for(int c = 0; c < cols; c++)
				swamp[r][c] = infile.nextInt();

		infile.close();
		return swamp;
	} // END LOAD SWAMP



  	// DO NOT MODIFY THIS METHOD - IT IS JUST FOr DEBUGGING.
	// ----------------------------------------------------------------
	private static void printSwamp(String label, int[][] swamp )
	{
		System.out.println( label );
		System.out.print("   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print( c + " " ) ;
		System.out.print( "\n   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");

		for(int r = 0; r < swamp.length; r++)
		{	System.out.print( r + "| ");
			for(int c = 0; c < swamp[r].length; c++)
				System.out.print( swamp[r][c] + " ");
			System.out.println("|");
		}
		System.out.print( "   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");
	} // END PRINT SWAMP METHOD

} // E N D   S W A M P    C L A S S