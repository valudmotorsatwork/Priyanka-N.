package pkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Blogic 
{
	
		Scanner sc=new Scanner(System.in);
		String s=null;
		String [] words;
		String h1=" Letters we have ";
		String h2= "    Its Occurrences ";
	
		public void Get()
		{
			System.out.println(" Enter lines of text you want ");
			s=sc.nextLine();
			System.out.println(" Text you entered is  " +s);
		}
		
		public void Evaluate()
		{
			try
			{
				System.out.printf( "%-15s %15s %n", h1, h2);
				String[] str = s.split( " " );
				ArrayList< String > list = new ArrayList< String >();

		           list.addAll( Arrays.asList( str ) );

		           int count = 0;

		           for( int i = 0; i < list.size(); i++ )
		           {
		              
		               for( int j = 0; j < list.size(); j++ )
		               {
		                   if( list.get( i ).equals(list.get( j ) ) )
		                       count++;
		                   if( list.get( i ).equals( list.get( j ) ) && count > 1 )
		                       list.remove( j );                      
		               }  
		               
		               System.out.printf("%-15s %15s %n",( list.get( i ).length() ), count );
		               count = 0;
		           }
		           System.out.println("\n");

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	

}

