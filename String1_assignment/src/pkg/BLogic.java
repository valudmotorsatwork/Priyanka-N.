package pkg;

import java.util.Scanner;

public class BLogic 
{

	Scanner sc = new Scanner(System.in);
	String s = null;
	int n = 0;
	
	public void Take() 
	{
		System.out.println(" Enter a sentence or paragraph without breaking it and without punctuations (having some string of b/B)");
		s = sc.nextLine();
		System.out.println("You entered :: " + s);
	}

	public void Read() 
	{

		try 
		{
			System.out.println("String you have entered having substrings starting from 'b' or 'B' are :: ");
			String[] tk = s.split(" ");
			for (int i = 0; i <= tk.length; i++) 
			{
				if (tk[i].startsWith("b") || tk[i].startsWith("B")) 
				{
					System.out.println(tk[i]);
				}
			}
			
		} 
		catch (Exception e) 
		{

		}
	}

}
