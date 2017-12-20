// Project1.java     STARTER FILE

import java.io.*; // I/O
import java.util.*; // Scanner class

public class Lab1
{
	public static void main( String args[] ) throws Exception
	{
		final double MILES_PER_MARATHON = 26.21875; 

		Scanner kbd = new Scanner (System.in);
		double aveMPH=0, aveMinsPerMile=0, aveSecsPerMile=0; 
		System.out.print("Enter marathon time in hrs minutes seconds: "); 

		double hh=0, mm=0, ss=0;
		hh = kbd.nextDouble();		
		mm = kbd.nextDouble();		
		ss = kbd.nextDouble();		

		hh = hh*3600;
		mm = mm*60;
		ss = hh+ss+mm;
		aveMPH= ((MILES_PER_MARATHON)/(ss/3600));
		aveMinsPerMile=((ss)/(MILES_PER_MARATHON)/60);
		aveMinsPerMile = (int)aveMinsPerMile;
		aveSecsPerMile =((ss)/(MILES_PER_MARATHON)%60);
			

		
		System.out.println();
		System.out.format("Average MPH was: %.2f mph\n", aveMPH  );
		System.out.format("Average mile split was %.0f mins %.1f seconds per mile", aveMinsPerMile, aveSecsPerMile );
		System.out.println();

	} 
} 