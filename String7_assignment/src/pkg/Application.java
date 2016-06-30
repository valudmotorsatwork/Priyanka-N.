package pkg;



public class Application {

	public static void main(String[] args) 
	{
		Blogics bl=new Blogics();
		boolean result = bl.Palindrome();
		if(result==true)
			System.out.println(" The text entered is true for palindrome check ");
		else
			System.out.println("The text entered is not true for palindrome check ");	
	}

}
