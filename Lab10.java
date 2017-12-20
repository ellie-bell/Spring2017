import java.util.*;
import java.io.*;

public class Lab10
{
	public static void main(String args[]) throws Exception
	{
		if(args.length < 2)
		{
			System.out.println("<\nusage: C:\\> java Jumbles <dictionary.txt> <jumbles.txt>\n\n");
			System.exit(0);
		}
		TreeSet<String> dictionary = new TreeSet<String>();
		TreeSet<String> jumbles = new TreeSet<String>();
		HashMap<String,String> answerKey = new HashMap<String,String>();

		BufferedReader dict = new BufferedReader (new FileReader(args[0]));
		BufferedReader jumb = new BufferedReader (new FileReader(args[1]));

		while(dict.ready())
		{
			dictionary.add(dict.readLine());
		}
		dict.close();
		//System.out.println(dictionary);

		while(jumb.ready())
		{
			jumbles.add(jumb.readLine());
		}
		jumb.close();

		for(String dWord : dictionary)
		{
			String dCanon = toCanon(dWord);
			//answerKey.put(dCanon, answerKey.get(dCanon));
			if(!answerKey.containsKey(dCanon))
			{
				answerKey.put(dCanon, dWord);
			}
			else if(answerKey.containsKey(dCanon))
			{
				answerKey.put(dCanon, answerKey.get(dCanon) + " " + dWord);
			}	
		}
		for(String jWord : jumbles)
		{	
			System.out.print(jWord);
			String jCanon = toCanon(jWord);
			if(answerKey.containsKey(jCanon))
			{
				System.out.println(" " + answerKey.get(jCanon));
			}
			if(!answerKey.containsKey(jCanon))
			{
				System.out.println();
			}	
		} 
	}

	static String toCanon(String s)
	{
		char[] letters = s.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
}