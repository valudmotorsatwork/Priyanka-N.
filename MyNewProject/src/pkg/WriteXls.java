package pkg;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;




public class WriteXls {
	public void writeXls(List<String> data) {
		List<String> list = data;

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Bank");
		HSSFFont font = workbook.createFont();
		font.setItalic(false);
		font.setColor(HSSFColor.BRIGHT_GREEN.index);

		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCellStyle style1 = workbook.createCellStyle();

		style1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
	
		try {

			int r = 0;
			Cell cell = null;
			int i = 0;
			for (i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
			i = 0;
			for (i = 0; i < 7; i++) {

				HSSFRow row = sheet.createRow(i);

				for (int j = 0; j < 6; j++) {
					cell = row.createCell(j);
					// Create a cell with a value and set style to it.
					cell.setCellValue(list.get(r));
					if (i == 0) {
						cell.setCellStyle(style);
					} else {
						cell.setCellStyle(style1);
					}

					r++;
				}
			}

			HSSFRow rowSummary = sheet.createRow(i);

			Cell cellRecon = null;
			cellRecon = rowSummary.createCell(3);
			cellRecon.setCellValue(data.get(42));

			Cell cellReconDiff = null;
			cellReconDiff = rowSummary.createCell(4);
			cellReconDiff.setCellValue(data.get(43));

			cellRecon.setCellStyle(style1);
			cellReconDiff.setCellStyle(style1);
			
			
			
			

			FileOutputStream out = new FileOutputStream(new File("./res/xlsfile.xls"));
			workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("xlsfile.xlsx written successfully on disk.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
