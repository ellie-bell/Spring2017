import java.io.*;
import java.util.*;

public class Lab9
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader infile = new BufferedReader(new FileReader(args[0]));
		HashMap<String,Integer> histogram = new HashMap<String,Integer>();
		String word;
		while ( infile.ready() )
		{
			word = infile.readLine();
			if (histogram.containsKey(word))
			{
				histogram.put(word, histogram.get(word)+1);
			}
			if (!histogram.containsKey(word))
			{
				histogram.put(word, 1);
			}
		}
		infile.close();
		printHistogram( histogram );
	} // END MAIN

	private static void printHistogram( HashMap<String,Integer> hm )
	{
		
       		ArrayList<String> wordList = new ArrayList<String>(hm.keySet());
       		Collections.sort(wordList);
			for (String key: wordList)      
			{ 		
           		System.out.println(key +"	"+hm.get(key));
           	}

	}
} // END LAB9 CLASS