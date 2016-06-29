package pkg;



import java.util.Scanner;

public class Blogic 
{
					String s=null,inwords;
					Scanner sc=new Scanner(System.in);
					int len=0, cnt=0,i;
					char [] c;
					
				public void GetData()
				{
					System.out.println(" Please enter line of texts ");
					s=sc.nextLine();
					System.out.println(" You entered a text as :: " +s);
				}
	
				public void ProcessData()
				{
					s=s.toLowerCase();
					s=s.replaceAll("\\W", "");
					s=s.replaceAll(" ","");
					c=s.toCharArray();
					
					for( i=0;i<c.length;i++)
					{
							boolean flag=true;
							for(int k=0;k<i;k++)
							{
								if(c[i]==s.charAt(k))
								flag=false;
							}
							if(flag)
							{
								for(int j=0;j<s.length();j++)
								{
									if(c[i]==s.charAt(j))
									cnt=cnt+1;
								}
								switch(cnt)
								{
								case 1: inwords="Once";
								break;
								case 2: inwords=" Twice";
								break;
								case 3: inwords=" Thrice";
								break;
								case 4: inwords=" Four times ";
								break;
								case 5: inwords=" Five times";
								break;
								case 6: inwords=" Six times ";
								break;
								case 7: inwords=" Seven times";
								break;
								case 8: inwords=" Eight times";
								break;
								case 9: inwords=" Nine times";
								break;
								case 10: inwords=" Ten times";
								break;
								default: inwords= " More than ten times ";
								break;
								
								}
								System.out.println( " Occurrence of " + c[i] + " letter " + "is " + inwords);
								cnt=0;
								len++;
							}
							
							
							
							
					}
					
				

							
				}
					
}

	

