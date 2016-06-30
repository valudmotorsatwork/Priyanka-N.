package pkg;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList<String> strlist=new ArrayList<>();
		
		System.out.println(" Enter lines upto 10 ");
		for(int i=0;i<10;i++)
		{
			strlist.add(sc.next());
		}
		
		MarkLength mkl=new MarkLength();
		mkl.markLength4(strlist);
		
	}

}
