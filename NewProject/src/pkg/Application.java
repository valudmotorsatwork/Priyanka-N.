package pkg;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		
		Xlsclass xl=new Xlsclass();
		
		WriteXls xls=new WriteXls();
		
		xl.GetData();
		
		List<String> data=xl.GetData();
				
		xls.writeXls(data);
		
		PdfClass pdfclass=new PdfClass();
		pdfclass.ToPdf();
	}

}
