import java.util.*;
import java.io.*;

public class Boggle
{
	public static TreeSet<String> dictionary = new TreeSet<String>();
	public static TreeSet<String> foundWordList = new TreeSet<>();
	public static void main(String[] args) throws Exception
	{
		if (args.length < 1 )
		{
			System.out.println("<\nusage: C:\\> java Project10 <board.txt>\n\n");
			System.exit(0);
		}

		String[][] board = loadBoard( args[0]);
		BufferedReader infile = new BufferedReader(new FileReader("dictionary.txt"));
		
		while ( infile.ready() )
		{
			String dict = infile.readLine();
   			dictionary.add(dict);
		}
		infile.close();
		
		for (int r=0; r<board.length ; ++r)
		{
			for (int c=0 ; c<board[r].length ; ++c )
				dfs(r,c,board,"");
		}
		 for (String value : foundWordList)
		 {
            System.out.println(value);
       	 }
		
	}
   private static void  dfs(int r, int c, String[][] board, String word )
   {	
		String letter = board[r][c];
		word += letter;

		if ( word.length() > 2 && dictionary.contains(word)) 
		{
			foundWordList.add(word);
		}
		if ( !dictionary.ceiling(word).startsWith(word))
		{		
			return;
		}
		
		//For all of the if statements below you only need to check for out of bounds in the direction you are checking. Meaning if your at the top of the grid you only need to check r > 0 not all of the other cases
		// your output should still work just might be a little redundant. Don't want Hoffman to nitpick that. 
		
		if ( (r>0) && board[r-1][c].equals(board[r-1][c].toLowerCase()))
		{
				board[r][c] = board[r][c].toUpperCase(); 
				dfs( r-1, c, board, word );
				board[r][c] = board[r][c].toLowerCase();
		}
		if( (r>0) && (c<board.length-1) && board[r-1][c+1].equals(board[r-1][c+1].toLowerCase()))
		{
				board[r][c] = board[r][c].toUpperCase();
				dfs( r-1, c+1, board, word );
				board[r][c] = board[r][c].toLowerCase();
		}
		if((c<board.length-1) && board[r][c+1].equals(board[r][c+1].toLowerCase()))
		{
				board[r][c] = board[r][c].toUpperCase(); 
				dfs( r, c+1, board, word );
				board[r][c] = board[r][c].toLowerCase();
		}
		if((r<board.length-1) && (c<board.length-1) && board[r+1][c+1].equals(board[r+1][c+1].toLowerCase()))
		{
				board[r][c] = board[r][c].toUpperCase(); 
				dfs( r+1, c+1, board, word );
				board[r][c] = board[r][c].toLowerCase();
		}
		if((r<board.length-1) && board[r+1][c].equals(board[r+1][c].toLowerCase()))
		{
				board[r][c] = board[r][c].toUpperCase(); 
				dfs( r+1, c, board, word );
				board[r][c] = board[r][c].toLowerCase();
		}
		if((r<board.length-1) && (c>0) && board[r+1][c-1].equals(board[r+1][c-1].toLowerCase()))
		{
				board[r][c] =board[r][c].toUpperCase(); 
				dfs( r+1, c-1, board, word );
				board[r][c] = board[r][c].toLowerCase();
		}
		if((c>0) && board[r][c-1].equals(board[r][c-1].toLowerCase()))
		{
				board[r][c] = board[r][c].toUpperCase(); 
				dfs( r, c-1, board, word );
				board[r][c] = board[r][c].toLowerCase();
		}
		if((r>0) && (c>0) && board[r-1][c-1].equals(board[r-1][c-1].toLowerCase()))
		{
				board[r][c] = board[r][c].toUpperCase(); 
				dfs( r-1, c-1, board, word );
				board[r][c] = board[r][c].toLowerCase();
		}


		
	}
	private static String[][] loadBoard( String infileName) throws Exception
	{
		Scanner infile = new Scanner( new File(infileName) );
		int rows = infile.nextInt();
		int cols = rows; 
		String[][] board = new String[rows][cols];
		for(int r = 0; r < rows ; r++)
			for(int c = 0; c < cols; c++)
				board[r][c] = infile.next();

		infile.close();
		return board;
	} 

}
   