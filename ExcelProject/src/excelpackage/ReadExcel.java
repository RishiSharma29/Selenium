package excelpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel 
{
	
	public static void ReadData(String Filename) throws InvalidFormatException, IOException
	{
		DataFormatter dataFormatter= new DataFormatter();
		File rd_file=new File(Filename);
		//FileInputStream file_stream=new FileInputStream(rd_file);
		XSSFWorkbook rd_xlsxbook=new XSSFWorkbook(rd_file);
		XSSFSheet rd_sheet = rd_xlsxbook.getSheet("Sheet1");
		Iterator<Row> rowIterator = rd_sheet.iterator();
		while (rowIterator.hasNext())
		  {
		      Row row = rowIterator.next();
     	      //For each row iterate through each columns
		      Iterator <Cell> cellIterator = row.iterator();

		      while (cellIterator.hasNext())
		      {
		    	  Cell cell = cellIterator.next();
		    	  
		    	  String value_read=dataFormatter.formatCellValue(cell);;
		    	  System.out.println(value_read);
		    			
		      }
		   }
	
	}

}
