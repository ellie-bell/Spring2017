/*
	Coin.java THIS IS THE ONLY FILE YOU HAND IN
	THERE IS NO MAIN METHOD IN THIS CLASS!
*/
import java.util.Random;
public class Coin
{
	int heads, tails;
	Random RGN;
	public Coin(int seed)
	{
		heads = 0;
		tails = 0;
		RGN = new Random (seed);
	}
	public String flip()
	{
		int result = RGN.nextInt(2);
		if( result == 1)
		{	
			heads ++;
			return "H";
		}
		else 
		{
			tails++;
			return "T";
		}
	}
	public int getNumHeads()
	{
		return heads;
	}
	public int getNumTails()
	{
		return tails;
	}
	public void reset()
	{
		tails = 0;
		heads = 0;
	}


} 