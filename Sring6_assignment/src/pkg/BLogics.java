package pkg;

import java.util.Scanner;

public class BLogics 
{
Scanner sc=new Scanner(System.in);
String s=null;
StringBuilder sb;
int i;
int len;

	public void Get()
	{
		System.out.println(" Enter a line possibly less than 10 characters ");
		s=sc.nextLine();
		System.out.println(" You entered a string as :: " +s);
		
		len=s.length();
		
		if(s.length()>10)
		{
			System.out.println(" You entered input line greater than 10 characters");
			s=s.substring(0,10);
			System.out.println(" String altered is  " +s);
		}
		
	}
	
	public void Process()
	{
		
		for(i=1; i<s.length(); i++)
		{
			System.out.print(addSpace(s.length()-i) + s.substring(0,i));
			
			if(i>1)
			{
				sb=new StringBuilder(s.substring(0,i-1));
				sb=sb.reverse();
				System.out.print(sb.toString());
			}
			System.out.println();
			
			
		}
		
		for(i=s.length()-1; i>0; i--)
		{
			System.out.print(addSpace(s.length()-i) + s.substring(0,i));
	        if(i>1)
	        {
	            sb = new StringBuilder(s.substring(0,i-1));
	            sb = sb.reverse();
	            System.out.print(sb.toString());
	        }
	        System.out.println();
		}
	}
	public static String addSpace(int x)
	{
		String str= "";
		for(int i=0; i<x; i++)
		{
			str += " ";
		}
		return str;
	}
	
}
