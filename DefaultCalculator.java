package AndreCalculator;

import java.util.ArrayList;
import java.util.List;

public class DefaultCalculator
{
	private static List<Integer> digits = new ArrayList<Integer>();
	private static List<Integer> digits2 = new ArrayList<Integer>();
	private static List<Integer> results = new ArrayList<Integer>();

	/**
	 *Multiplies two numbers stored as ints. Prints result as a string
	 *@param first the first integer to be multiplied
	 *@param second the second integer to be multiplied
	 */
	public static void multiply(int first, int second)
	{
		if(digits.size()>0)
		{
			digits = new ArrayList<Integer>();
			digits2 = new ArrayList<Integer>();
		}

		int f = first;
		int s = second;
		while(f/10 >= 0)
		{
			digits.add(f%10);
			f /= 10;
		}
		while(s/10 >= 0)
		{
			digits.add(s%10);
			s /= 10;
		}
		System.out.println(intMultiplication());
	}

	/**
	 * Multiplies two numbers stored as doubles. Prints result as a string
	 *@param first the first double to be multiplied
	 *@param second the second double to be multiplied
	 */
	public static void multiply(double first, double second)
	{

	}

	/**
	 * Multiplies two numbers stored as strings. Prints result as a string
	 *@param first the first number (stored as a string to bypass length limits) to be multiplied
	 *@param second the second number (stored as a string to bypass length limits) to be multiplied
	 */
	public static void multiply(String first, String second)
	{
		if(!(first.contains(".")&&second.contains(".")))
		{
			for(int i =first.length()-1; i>=0 ; i--)
			{
				digits.add(Integer.parseInt(first.substring(i, i+1)));
			}

			for(int i = second.length()-1; i>=0; i--)
			{
				digits2.add(Integer.parseInt(second.substring(i, i+1)));
			}
			System.out.println(intMultiplication());
		}
	}

	/**
	 * Multiplies and returns two ints stored in the array lists. 
	 * @return a string containing the product of the ints stored in the ArrayLists
	 */
	private static String intMultiplication()
	{

		for(int i=0; i< digits.size(); i++)
		{
			for(int j = 0; j<digits2.size(); j++)
			{
				try
				{
					results.set(i+j, results.get(i+j) + digits.get(i)*digits2.get(j));
				}catch(IndexOutOfBoundsException e)
				{
					for(int c = results.size(); c<= i+j; c++)
						results.add(0);
					results.set(i+j, results.get(i+j) + digits.get(i)*digits2.get(j));
				}
			}
		}
		for(int i =0; i < results.size(); i++)
		{
			if(results.get(i)>=10)
			{
				try
				{
					results.set(i+1, results.get(i+1)+results.get(i)/10);
				}catch(IndexOutOfBoundsException e)
				{
					results.add(results.get(i)/10);
				}
				results.set(i, results.get(i)%10);
			}
		}
		String number = "";
		for(int num=results.size()-1; num>=0; num--)
		{
			number+=results.get(num);
		}
		return number;
	}
}
