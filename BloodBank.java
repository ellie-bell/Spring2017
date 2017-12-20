

import java.io.*;
import java.util.*;

public class BloodBank
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader infile = new BufferedReader( new FileReader( "type2pres.txt" ) );
		TreeMap<String,TreeSet<String>> type2pres = new TreeMap<String,TreeSet<String>>();
		TreeMap<String,String> pres2type = new TreeMap<String,String>();

		while ( infile.ready() )
		{
			ArrayList<String> tokens = new ArrayList<String>(  Arrays.asList( infile.readLine().split(",") )  );
			String bloodType = tokens.remove(0);
			type2pres.put(bloodType, new TreeSet<String>(tokens));
		}

		for ( String type  : type2pres.keySet() ) 
        {   TreeSet<String> presidents = type2pres.get( type );
            System.out.print( type + "\t" );


            for ( String pres : presidents )
            {
                System.out.print( pres + " ");
				pres2type.put(pres, type);
            }
            System.out.println();

		
		
		
		}
		for (String pres : pres2type.keySet())
		{	
			System.out.println(pres + "\t" + pres2type.get(pres));
		}

	} // MAIN



} // BLOODBANK
