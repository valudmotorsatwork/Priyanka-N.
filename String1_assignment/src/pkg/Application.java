package pkg;

public class Application 
{

	// 1. Write an application that reads a series of strings and outputs only
	// those strings beginning with the letter "b." The results should be output
	// to a text area.

	public static void main(String[] args) 
	{

		try {
			BLogic bl = new BLogic();
			bl.Take();
			bl.Read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
