package pkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SwitchPairs 
{
	ArrayList<String> strlist=new ArrayList<>();
 	Scanner sc=new Scanner(System.in);
 	
 	public void GetData()
 	{
 		System.out.println(" Enter list of lines of 12 elements ");
 		for(int i=0;i<12;i++)
 		{
 			strlist.add(sc.next());
 		}
 		
 	}
 	public void Logic()
 	{
 		for(int i=0;i<strlist.size();i+=2)
 		{
 			Collections.swap(strlist,i,(i+1));
 		}
 		System.out.println(" new list is " +strlist);
 	}
	
}
