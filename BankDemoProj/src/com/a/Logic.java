package com.a;


import java.io.*;
import java.util.StringTokenizer;




public class Logic {
	
	public void logics()
	{
		 String fileName = "./res/ass1_input.txt";
         String line = null;
         double TOT_RECON_DIFF = 0.0d;
         String companyName = null;
         String reconDate = null;

         try {

                FileReader fileReader = new FileReader(fileName);

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String arr[] = new String[6];
                int i;
                int cnt = 0;
                while ((line = bufferedReader.readLine()) != null) {
                      StringTokenizer st = new StringTokenizer(line);
                      if (cnt != 0) {
                             //loop for checking if the line contains for "|"  
                             if (line.contains("|")) {

                                    for (i = 0; i <= 5; i++) {
                                           arr[i] = st.nextToken("|");
                                           companyName = arr[5];
                                           reconDate = arr[1];

                                    }

                                    TOT_RECON_DIFF = TOT_RECON_DIFF + Double.parseDouble(arr[4]);

                             }

                             else if (line.contains(";")) {
                                    for (i = 0; i <= 5; i++) {
                                           arr[i] = st.nextToken(";");
                                           companyName = arr[5];
                                           reconDate = arr[1];
                                    }

                                    TOT_RECON_DIFF = TOT_RECON_DIFF + Double.parseDouble(arr[4]);

                             }

                             else if (line.contains(":")) {
                                    for (i = 0; i <= 5; i++) {
                                           arr[i] = st.nextToken(":");

                                           companyName = arr[5];
                                           reconDate = arr[1];
                                    }

                                    TOT_RECON_DIFF = TOT_RECON_DIFF + Double.parseDouble(arr[4]);

                             }

                             else if (line.contains(" "))

                             {
                                    arr[0] = line.substring(0, 8);
                                    System.out.println(arr[1]);
                                    arr[1] = line.substring(9, 19);
                                    System.out.println(arr[2]);
                                    arr[2] = line.substring(19, 22);
                                    System.out.println(arr[3]);
                                    arr[3] = line.substring(23, 28);
                                    arr[4] = line.substring(29, 36);
                                    arr[5] = line.substring(40, 50);
                                    companyName = arr[5];

                                    TOT_RECON_DIFF = TOT_RECON_DIFF + Double.parseDouble(arr[4]);

                             }

                      }
                      cnt++;
                }
                String values = "Company Name:: " + companyName + "  " + "TOT_RECON_DIFF::" + " " + TOT_RECON_DIFF
                             + " Date:: " + reconDate + " ";
                System.out.println("Total value:::" + TOT_RECON_DIFF);
                FileWriter filewriter = new FileWriter("output.txt");

                filewriter.write(values);
                System.out.println("Success");
                filewriter.close();

               
         }

         catch (FileNotFoundException ex) {
                System.out.println("Unable to open file '" + fileName + "'");
         } catch (IOException ex) {
                System.out.println("Error reading file '" + fileName + "'");
         }
  }
	
}
