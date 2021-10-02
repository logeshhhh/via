package project;

import java.io.FileInputStream;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Import 
{
	Workbook wb; //parent of HSSF and XSSF workbook
	public Excel_Import(String pathWithFileName)
	{
		
		try
		{
		if(pathWithFileName.endsWith(".xls"))
		{
			wb= new HSSFWorkbook(new FileInputStream(pathWithFileName));
			 
		}
		else if(pathWithFileName.endsWith(".xlsx"))
		{
			wb= new XSSFWorkbook(new FileInputStream(pathWithFileName));			
		}
		} catch (Exception E)
		{
			System.out.println("Error with file connection with message " +E.getMessage());
		}
	}
	
	
	public String getData(String sheetName, int row, int col)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return data;
	}
	

}