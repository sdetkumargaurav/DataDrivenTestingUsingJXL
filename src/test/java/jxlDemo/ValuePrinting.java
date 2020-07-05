package jxlDemo;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class ValuePrinting {

	public static void main(String[] args) throws Exception {


		//Open excel file for reading
		File excelFile=new File("D:\\DataDrivenFile\\ExcelData.xls");
		Workbook rwb=Workbook.getWorkbook(excelFile);
		Sheet rsh=rwb.getSheet(1);
		int nour=rsh.getRows();
		
		for(int i=1;i<nour;i++)
		{
			String name=rsh.getCell(0,i).getContents();
			String address=rsh.getCell(1,i).getContents();
			System.out.println("Employee Name is:"+name);
			System.out.println("Employee Address is:"+address);
		}
		

	}

}
