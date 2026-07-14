package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;


public class DataDriven {
	@DataProvider(name="getData")
	public String[][] getData() throws IOException {
	
	String path=System.getProperty("user.dir")+"/testData/datadriven.xlsx";
	ExcelUtility e=new ExcelUtility(path);
	File f = new File(path);
	System.out.println("File exists? " + f.exists());
	int rnum=e.getRowCount("Sheet1");
	int cnum=e.getCellCount("Sheet1", rnum);
	System.out.println(rnum+" "+cnum);
	String loginDta[][]=new String[rnum][cnum];
	
	for(int i=1;i<=rnum;i++)
	{
		for(int j=0;j<cnum;j++)
		{
			loginDta[i-1][j]=e.getCellData("Sheet1", i,j);
		}
	}
	System.out.println(Arrays.deepToString(loginDta));
	return loginDta;
	}

}
