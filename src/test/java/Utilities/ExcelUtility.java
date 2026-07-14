package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream in;
	public FileOutputStream out;
	
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	
	public Row row;
	public Cell cell;
	String path;
	
	ExcelUtility(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		in=new FileInputStream(path);
		wb=new XSSFWorkbook(in);
		sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		wb.close();
		in.close();
		return rowCount;
		
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		in=new FileInputStream(path);
		wb=new XSSFWorkbook(in);
		sh=wb.getSheet(sheetName);
	    row=sh.getRow(rownum);
		int cellCount=row.getLastCellNum();
		wb.close();
		in.close();
		return cellCount;
		
	}
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		in=new FileInputStream(path);
		wb=new XSSFWorkbook(in);
		sh=wb.getSheet(sheetName);
	    row=sh.getRow(rownum);
	    cell=row.getCell(colnum);
	    DataFormatter f=new DataFormatter();
	    String data;
	    try {
	    	data=f.formatCellValue(cell);
	    }
	    catch(Exception e)
	    {
	    	data="";
	    }
	    wb.close();
		in.close();
		return data;
	}

}
