package pkg;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class RemoveBadPairs {
	Scanner sc = new Scanner(System.in);
	List<Integer> arr = new ArrayList<>();

	public void GetData() {

		System.out.println(" Enter number of elements you want to enter ");
		int n = sc.nextInt();
		if(n!=0)
		{
		System.out.println(" Enter random integers");
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		}
		if (arr.size() % 2 == 1) {
			arr.remove(arr.get(arr.size() - 1));
		}

	}
	public void comp() {
			int i=0;
			if (!arr.isEmpty()) 
			{
			System.out.println("Arraylist of int is" + arr);
			if(arr.get(i)==arr.get(i+1))
			{
				System.out.println(" List has all equal elements ");
			}
			else
			{
			for (i=0;i<arr.size()-1;i+=2) 
			{	
				
					 if(arr.get(i)>arr.get(i+1))
					 {
						 arr.remove(i);
						arr.remove(i);
						
					 }
					 
				 
			}
			System.out.println(" List is ");
			System.out.println(arr);
		}
		}
		else 
		{
			System.out.println(" You entered empty list");
		}
	}

}
