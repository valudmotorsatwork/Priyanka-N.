package pkg;

import java.util.Scanner;

public class Blogics {

	public boolean Palindrome() {
		boolean result = true;
		String input = "";
		System.out.println("Enter the string you want to check for palindrome");
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		int l = 0;
		int r = input.length() - 1;
		char charL, charR;

		while (l < r) {
			charL = input.charAt(l);
			
			charR = input.charAt(r);
			
			if (String.valueOf(charL).equalsIgnoreCase(String.valueOf(charR))) {
				l++;
				r--;
			
			
			}

			else if (charL == ',' || charL == '.' || charL == '-' || charL == ':' || charL == ';' || charL == ' '
					|| charL == '!') {
				l++;
			
			}

			else if (charR == ',' || charR == '.' || charR == '-' || charR == ':' || charR == ';' || charR == ' '
					|| charR == '!') {
				r--;
			
			} else {
				result = false;
				break;
			}

		}
		return result;
	}
}