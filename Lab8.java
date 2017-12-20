import java.util.*;
import java.io.*;

public class Lab8
{
	public static void main( String[] args)
	{
		if ( args.length<1) { System.out.println("FATAL ERROR: Missing expression on command line\nexample: java Lab8 3+13/5-16*3\n"); System.exit(0); }
		
		// Stolen directly from stackoverflow with just a few mods :)
		String expr= args[0];  // i.e. somethinig like "4+5-12/3.5-5.4*3.14"; 
		System.out.println( "expr: " + expr );
		ArrayList<String> operatorList = new ArrayList<String>();
		ArrayList<String> operandList = new ArrayList<String>();
		// StringTokenizer is like an infile and calling .hasNext() that splits on + - / or *
		StringTokenizer st = new StringTokenizer( expr,"+-*/", true );
		while (st.hasMoreTokens())
		{
			String token = st.nextToken();
			if ("+-/*".contains(token))
				operatorList.add(token);
			else
				operandList.add(token);
    		}
 		System.out.println("Operators:" + operatorList);
		System.out.println("Operands:" + operandList);
		
		double result = evaluate( operatorList, operandList );
		System.out.println("The expression: " + expr + " evalutes to " + result + "\n");
	} // END MAIN
	
	
	// ............................................................................................
	// Y O U  W R I T E  T H I S  M E T H O D  (WHCIH YOU MAY TRANSPLANT INTO SIMPLE CALC)
	// ............................................................................................
	
	// TAKES THE LIST Of OPERATORS ANd OPERANDS RETURNS RESULT AS A DOUBLE
	static double evaluate( ArrayList<String> operatorList, ArrayList<String> operandList)
	{
		ArrayList <Double> operand = new ArrayList<Double>();
		
		for( String op: operandList)
		{
			operand.add(Double.parseDouble(op));
		}
			
			while( operatorList.contains("*") || operatorList.contains("/"))
			
			{
				int indexMult = operatorList.indexOf("*");
				int indexDiv = operatorList.indexOf("/");
				int minIndex = 0;
				
				if ( (indexMult < indexDiv))
					minIndex= indexMult;
				
				else if ( (indexMult > indexDiv))
					minIndex= indexDiv;
				
				if (indexMult < 0)
					minIndex = indexDiv;
					
				else if (indexDiv < 0)
					minIndex = indexMult;
					
					if ((operatorList.get(minIndex)).equals("*"))
					{
						double result = operand.get(minIndex) * operand.get(minIndex +1);
						operand.set(minIndex, result);
						operand.remove(minIndex + 1);
						operatorList.remove(minIndex);
					}
					else if ((operatorList.get(minIndex)).equals("/"))
					{
						double result = (operand.get(minIndex)) / (operand.get(minIndex +1));
						operand.set(minIndex, result);
						operand.remove(minIndex + 1);
						operatorList.remove(minIndex);
					}
					
			}	
		
			while( operatorList.contains("+") || operatorList.contains("-"))
			{	
				int indexAdd = operatorList.indexOf("+");
				int indexSub = operatorList.indexOf("-");
				int minIndex = 0;
				
				if ( (indexAdd < indexSub))
					minIndex= indexAdd;
				
				else if ( (indexAdd > indexSub))
					minIndex= indexSub;
				
				if (indexAdd < 0)
					minIndex = indexSub;
					
				else if (indexSub < 0)
					minIndex = indexAdd;
					
					if ( (operatorList.get(minIndex)).equals("+"))
					{
						double result = (operand.get(minIndex)) + (operand.get(minIndex +1));
						operand.set(minIndex, result);
						operand.remove(minIndex + 1);
						operatorList.remove(minIndex);
					}
					else if ((operatorList.get(minIndex)).equals("-"))
					{
						double result = operand.get(minIndex) - operand.get(minIndex +1);
						operand.set(minIndex, result);
						operand.remove(minIndex + 1);
						operatorList.remove(minIndex);
					}
			}		
			
		
		 return operand.get(0); 
		
		
	}
} // END LAB8