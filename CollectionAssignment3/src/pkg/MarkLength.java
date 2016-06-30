package pkg;

import java.util.ArrayList;

public class MarkLength {
	
	
	
	public ArrayList<String> markLength4 (ArrayList<String> ml)
	{
		ArrayList<String > strings=new ArrayList<>();
		for(String s: ml )
		{
			if(s.length()==4)
			
				strings.add("****");
				strings.add(s);		
		}
		
		System.out.println(strings);
		return strings;
		
	}
	

		
	}
 

