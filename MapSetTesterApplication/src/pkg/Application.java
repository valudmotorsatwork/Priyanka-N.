package pkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		HashMap<String, TreeSet<String>> networkMap = new HashMap<String, TreeSet<String>>();
		while (true) {
			System.out.print(" Enter network ");
			String nwk = sc.nextLine();
			System.out.print(" Enter  television show ");
			String sw = sc.nextLine();
			TreeSet<String> Sset = networkMap.get(nwk);
			if (Sset == null) {
				Sset = new TreeSet<String>();
				Sset.add(sw);
				networkMap.put(nwk, Sset);
			} else {
				Sset.add(sw);
			}
			System.out.print(" Continue? Yes or No : ");
			System.out.println(" Please enter only Y or N ");
			String choice = sc.nextLine();
			if (choice.equals("N")) {
				break;
			} else {
				System.out.println(" Please enter valid choice ");
			}

		}
		System.out.println("Inserted");
		System.out.println(networkMap);
		System.out.println("Sorted Order is");
		ArrayList<String> keyList = new ArrayList<String>(networkMap.keySet());
		Collections.sort(keyList);
		for (String str : keyList) {
			System.out.println(str + "" + networkMap.get(str));
		}
	}

}
