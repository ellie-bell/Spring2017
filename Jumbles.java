
import java.util.*;
import java.io.*;

public class Jumbles
{

	public static void main( String args[] ) throws Exception
	{
		if (args.length < 2 )
		{
			System.out.println("<\nusage: C:\\> java Jumbles <dictionary.txt> <jumbles.txt>\n\n");
			System.exit(0);
		}

		ArrayList <String> dictionary = new ArrayList<String>();
		ArrayList <String> jumbles = new ArrayList<String>();
		ArrayList <String> answerKey = new ArrayList<String>();


		BufferedReader infileDict = new BufferedReader( new FileReader(args[0]) );
		BufferedReader infileJumb = new BufferedReader( new FileReader(args[1]) );
		
		while (infileDict.ready())
		{
   			String dict = infileDict.readLine();
   			dictionary.add(dict);
		}
		
		while (infileJumb.ready())
		{
   			String jumb = infileJumb.readLine();
   			jumbles.add(jumb);
		}
	
		Collections.sort(dictionary);
		Collections.sort(jumbles);

		
		for (int i = 0; i< dictionary.size(); i++)
		{
		

			String dCanonical = toCanon(dictionary.get(i));
			int index = bSearch( answerKey, dCanonical + " ");
			
			if (index >= 0)
			{	
				answerKey.set( index, (answerKey.get(index) + " " + dictionary.get(i)));
			}
			else if ( index < 0 )
			{
				index  = -(index +1 );
				answerKey.add(index, dCanonical + " " + dictionary.get(i));
			}
		
		}	


		for (int i = 0; i< jumbles.size(); i++)
		{
			System.out.print( jumbles.get(i) + " " );
			String jCanon = toCanon( jumbles.get(i) ); 
			int index = bSearch( answerKey, jCanon + " ");
			if (index >= 0)
			{	
				int indexSpace = answerKey.get(index).indexOf(" ");
				System.out.println(answerKey.get(index).substring(indexSpace+1));
			}
			else 
			{
				System.out.println();
			}
		}
	} 
	static int bSearch(ArrayList<String> answerKey, String dCanonical)
	{
		int lo = 0;
		int high = answerKey.size()-1;
		while( lo <= high )
		{
			int m = lo + ((high - lo)/2);
			if( answerKey.get(m).startsWith(dCanonical) )
			{
				return m;
				
			}
			else if (answerKey.get(m).compareTo(dCanonical) <0)
			{	
				lo = m + 1;
			}
			else if (answerKey.get(m).compareTo(dCanonical) > 0)
			{
				high = m - 1;
			}
		}
		return - ( lo + 1); 
	}
	
	static String toCanon( String s )
	{
		char[] letters = s.toCharArray();
		Arrays.sort( letters ); 
		return new String( letters ); 
	}


} 
