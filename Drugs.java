import java.util.*;
import java.io.*;

public class Drugs
{
	public static void main( String[] args ) throws Exception
	{
		BufferedReader foodDrug2CategoryFile = new BufferedReader( new FileReader( "foodDrug2Category.txt" ) );
		BufferedReader patient2FoodDrugFile = new BufferedReader( new FileReader( "patient2FoodDrug.txt" ) );
		BufferedReader dontMixFile = new BufferedReader( new FileReader( "dontMix.txt" ) );
		TreeMap<String,TreeSet<String>> foodDrugs2Category = new TreeMap<String, TreeSet<String>>();
		TreeMap<String,TreeSet<String>> patient2FoodDrug = new TreeMap<String, TreeSet<String>>();
		TreeMap<String, String> dontMix = new TreeMap<String, String>();

		while(foodDrug2CategoryFile.ready())
		{
			ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(foodDrug2CategoryFile.readLine().split(",")));
			String meds = tokens.remove(0); //remove first element and save it into key
			foodDrugs2Category.put(meds, new TreeSet<String>(tokens));
		}
		for(String drug : foodDrugs2Category.keySet())
		{
			TreeSet<String> foods = foodDrugs2Category.get(drug); //when call get on a map, pass in 
			System.out.print(drug+ " ");	
			
			for(String foodType : foods)
			{
				
				System.out.print(foodType + " ");
			
			}
			System.out.println();		
		
		}
		System.out.println();
		
		while(patient2FoodDrugFile.ready())
		{
			ArrayList<String> tokens1 = new ArrayList<String>(Arrays.asList(patient2FoodDrugFile.readLine().split(",")));
			String patients = tokens1.remove(0); //remove first element and save it into key
			patient2FoodDrug.put(patients, new TreeSet<String>(tokens1));
		}
		for(String patient : patient2FoodDrug.keySet())
		{
			TreeSet<String> drugs = patient2FoodDrug.get(patient); //when call get on a map, pass in 
			System.out.print(patient+ " ");	
			
			for(String drugType : drugs)
			{
				
				System.out.print(drugType + " ");
			
			}
			System.out.println();	
		}	
		
		while(dontMixFile.ready())
		{
			ArrayList<String> tokens2 = new ArrayList<String>(Arrays.asList(dontMixFile.readLine().split(",")));
			String mix = tokens2.remove(0);
			String mix2 = tokens2.remove(1);
			dontMix.put(mix, mix2);
		}
		HashMap<String, String> combined = new HashMap <String, String> ();
		for ( String i: patient2FoodDrug.keySet())
		{
			if (!foodDrugs2Category.get(i).equals(patient2FoodDrug.get(i)))
			{
				combined.put( foodDrugs2Category.get(), foodDrugs2Category.values());
			}
		for ( String j: foodDrugs2Category.keySet())
		{
			if (!patient2FoodDrug.containsKey(j))
			{
				combined.put( patient2FoodDrug.get(), patient2FoodDrug.values());
			}
		HashMap<String, String> doNotMix = new HashMap <String, String> ();
		for ( String i: combined.keySet())
		{
			if (!dontMix.get(i).equals(combined.get(i)))
			{
				doNotMix.put( dontMix.get(), dontMix.value());
			}
		for ( String j: dontMix.keySet())
		{
			if (!combined.containsKey(j))
			{
				doNotMix.put( combined.getKey(), combined.getvalue());
			}
		}
		System.out.println(doNotMix);
	} // END MAIN
	}
	}
}
} // END CLASS


