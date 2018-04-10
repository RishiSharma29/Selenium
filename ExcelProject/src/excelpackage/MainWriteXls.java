package excelpackage;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class MainWriteXls extends WriteExcel
{

	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		String FileName="C:/Users/asharma189/Desktop/Test.xlsx";
		WriteXlData(FileName);

	}

}
