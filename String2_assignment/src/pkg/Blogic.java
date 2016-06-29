package pkg;

import java.util.Scanner;

public class Blogic 
{
	String s = null, sub = null;
	Scanner sc = new Scanner(System.in);
	int len, i, c;
	

	public void GetData() 
	{
		System.out.println(" Enter only 5 letter string you want ");
		s = sc.nextLine();
		len = s.length();

	}

	public void Combination() 
	{
		for (int i = 0; i < len; i++) 
		{ 															// position of 1st letter
			for (int j = 0; j < len; j++) 
			{ 														// position of 2nd letter
				for (int k = 0; k < len; k++) 
				{ 													// position of 3rd letter
					if (i == j || i == k || j == k)
					continue; 										// any letter taken twice? -> skip
					System.out.printf("%c%c%c\n", s.charAt(i), s.charAt(j), s.charAt(k));
				}
			}
		}
	}

	
}
