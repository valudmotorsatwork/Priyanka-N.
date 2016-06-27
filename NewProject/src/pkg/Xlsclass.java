package pkg;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.ss.usermodel.Cell;

//import dao.GetSet;

public class Xlsclass {

	public List<String> GetData() // method
	{
		String fileName = "./res/ass1_input.txt";
		String line = null;

		
		List<String> data = new ArrayList<>();
		try {
			String[] arr = new String[6];
			FileReader fileReader = new FileReader(fileName);
			int cnt = 0;
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int i;
			while ((line = bufferedReader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				if (cnt >= 0) {
					// loop for checking if the line contains "|"
					if (line.contains("|")) {
						for (i = 0; i <= 5; i++) {
							if (st.hasMoreTokens()) {
								arr[i] = st.nextToken("|");
								
							}
							
						}
					}
					// loop for checking if the line contains ";"
					else if (line.contains(";")) {
						for (i = 0; i <= 5; i++) {
							arr[i] = st.nextToken(";");
							
						}
					}

					// loop for checking if the line contains ":"
					else if (line.contains(":")) {
						for (i = 0; i <= 5; i++) {
							arr[i] = st.nextToken(":");
							
						}
					}

					// loop for checking if the line contains " "
					else if (line.contains(" ")) {
						arr[0] = line.substring(0, 8);
						arr[1] = line.substring(9, 19);
						arr[2] = line.substring(19, 22);
						arr[3] = line.substring(22, 28);
						arr[4] = line.substring(29, 36);
						arr[5] = line.substring(40, 53);
					

					}
					for (i = 0; i < arr.length; i++) {
						data.add(arr[i]);
					}

					cnt++;
				}
			}
			
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
		return data;
	}
}
