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
                public void writeXls(List<String> data)
                {
                                List<String> list= data;
                                

                                HSSFWorkbook workbook=new HSSFWorkbook();
                                HSSFSheet sheet= workbook.createSheet("Bank");
                                HSSFFont font = workbook.createFont();
        font.setItalic(false);
        font.setColor(HSSFColor.BRIGHT_GREEN.index); 
        
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
        style.setFillPattern(style.ALIGN_FILL);
        style.setFont(font);
        
        HSSFFont font1 = workbook.createFont();
        HSSFCellStyle style1= workbook.createCellStyle();
       // font1.setColor(HSSFColor.GREY_50_PERCENT.index);
       // style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
        style1.setFont(font1);


                                try
                                {
                                
                                        int rownum = 0;     
                                        int r = 0;
                Cell cell = null ;
                for(int i=0;i<list.size();i++)
                                System.out.println(list.get(i));
                for (int i = 0; i < 7; i++) {
                      
                      HSSFRow row = sheet.createRow(i);
                      for (int j = 0; j < 6; j++) {
                      cell = row.createCell(j);
                      // Create a cell with a value and set style to it.
                      cell.setCellValue(list.get(r));
                      if(i==0)
                      {                             
                          cell.setCellStyle(style);
                      }
                      else
                      {                          
                      cell.setCellStyle(style1);
                      }
                      
                      r++;
                      }
                      
                     
                      
          //Row rs=sheet.createRow(8);
                      
                }
                
                            FileOutputStream out = new FileOutputStream(new File("./res/xlsfile.xls"));
                            workbook.write(out);
                            out.close();
                            System.out.println("xlsfile.xlsx written successfully on disk.");
                     
                                 
                }catch(Exception e)
                        {
                                 e.printStackTrace();
                        }
}
}
