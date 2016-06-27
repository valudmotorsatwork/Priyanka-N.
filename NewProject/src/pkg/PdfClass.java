package pkg;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;

//import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.Iterator;

public class PdfClass {

	public void ToPdf() {

		try {

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
			while (rowIt.hasNext()) {
				Row row = rowIt.next();
				

				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						pcell = new PdfPCell(new Phrase(cell.getStringCellValue()));
						
						tb.addCell(pcell);
						//pcell.setBackgroundColor(BaseColor.GREEN);
						break;

					}
				}

			}

			pdf.add(tb);

			pdf.close();
			ipdoc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// to open pdf file expand referenced libraries tab and within it right
		// click on pdffile and open with -> other -> external programs-> adobe
		// acrobat document

	}

}
