package jxlDemo;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

public class AddTwoNumber {

	public static void main(String[] args) throws Exception {
		
		//Open Excel file for reading
		
		File excelFile=new File("D:\\DataDrivenFile\\ExcelData.xls");
		
		Workbook rwb=Workbook.getWorkbook(excelFile);
		Sheet rsh=rwb.getSheet(0);
		int nour=rsh.getRows();
		
		//Open Excel file for writing
		
		WritableWorkbook wwb=Workbook.createWorkbook(excelFile,rwb);
		WritableSheet wsh=wwb.getSheet(0);
		
		for(int i=1;i<nour;i++)
		{
			try
			{
				int number1=Integer.parseInt(rsh.getCell(0,i).getContents());
				int number2=Integer.parseInt(rsh.getCell(1,i).getContents());
				int number3=Integer.parseInt(rsh.getCell(2,i).getContents());
				int add=number1+number2+number3;
				System.out.println(add);
				Number result=new Number(3,i,add);
				wsh.addCell(result);
				
			}
			catch(Exception e)
			{
				System.out.println(e.getCause());
				e.printStackTrace();
			}
			
		}
	         //Save file
	          wwb.write();
	          wwb.close();
	          rwb.close();

	}

}
