package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public Object[][]loginData() throws IOException {
		
	String path=".\\testData\\loginData.xlsx"; //taking xlfile
	
	ExcelUtility xlutility=new ExcelUtility(path);//create object for ExcelUtility class
	int totalRows=xlutility.getRowCount("Sheet1");
	int totalCols=xlutility.getCellCount("Sheet1", 1);
			
	Object logindata[][]=new Object[totalRows][totalCols];//create two dimensional array which stores data from excel file
	
	for(int i=1;i<=totalRows;i++) { //read data from excel sheet
		for(int j=0;j<totalCols;j++) {
			logindata[i-1][j]=xlutility.getCellData("Sheet1", i, j);
		
		}
	}
	return logindata;
	
		
	}
	//Data Provider1
	
	//Data provider2
	
	//data provider3
}
