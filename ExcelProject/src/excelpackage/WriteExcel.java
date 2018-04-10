package excelpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel
{
	
	public static void WriteXlData(String File_name) throws InvalidFormatException, IOException
	{
		DataFormatter dataFormatter= new DataFormatter();
		File write_file=new File(File_name);
		XSSFWorkbook write_excel=new XSSFWorkbook(write_file);
		XSSFSheet wr_sheet=write_excel.getSheet("Sheet1");
		int First_rowcount=wr_sheet.getFirstRowNum();
		int Last_rowcount=wr_sheet.getLastRowNum();
		int RowCount=Last_rowcount - First_rowcount;
		Row New_row=wr_sheet.createRow(RowCount +1);
		Cell New_cell=New_row.createCell(1);
		New_cell.setCellValue("Hi");
		FileOutputStream fos = new FileOutputStream(write_file);
		write_excel.write(fos);
		fos.close();
	
	}

}
