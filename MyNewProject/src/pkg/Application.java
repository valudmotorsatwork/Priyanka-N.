package pkg;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		
		Xlsclass xl=new Xlsclass();
		
		WriteXls xls=new WriteXls();
		
		// open xls file generated from res folder itself.
		
		xl.GetData();
		
		List<String> data=xl.GetData();
				
		xls.writeXls(data);
		
		PdfClass pdfclass=new PdfClass();
		pdfclass.ToPdf(data);
		
		
		// to open pdf file expand referenced libraries tab and within it right
				// click on pdffile and open with -> other -> external programs-> adobe
				// acrobat document
	}

}
