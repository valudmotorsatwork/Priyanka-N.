package pkg;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;

import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.Iterator;
import java.util.List;

public class PdfClass {

	public void ToPdf(List<String> data) {

		try {

			List<String> list = data;
			FileInputStream ipdoc = new FileInputStream(new File("./res/xlsfile.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(ipdoc);
			HSSFSheet sheet = wb.getSheetAt(0);

			// HSSFCellStyle style=wb.createCellStyle();
			Iterator<Row> rowIt = sheet.iterator();

			Document pdf = new Document();

			PdfWriter.getInstance(pdf, new FileOutputStream("pdffile"));
			pdf.open();
			PdfPTable tb = new PdfPTable(6);

			PdfPCell pcell;
			int i = 0;
			while (rowIt.hasNext()) {
				Row row = rowIt.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						pcell = new PdfPCell(new Phrase(cell.getStringCellValue()));
						if (i == 0)
							pcell.setBackgroundColor(new BaseColor(0, 200, 0));
						else
							pcell.setBackgroundColor(new BaseColor(128, 128, 128));

						tb.addCell(pcell);

						break;
					}
				}
				i++;
			}
			Paragraph sumpara = new Paragraph(" Summary " + list.get(42) + "  and  " + list.get(43));
			pdf.add(tb);
			pdf.add(sumpara);
			
			
			
			pdf.close();
			ipdoc.close();
			wb.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

}
