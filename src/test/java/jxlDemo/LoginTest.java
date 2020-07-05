package jxlDemo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;

public class LoginTest {

	public static void main(String[] args) throws Exception {


		//Open excel file for reading
		File excelFile=new File("D:\\DataDrivenFile\\ExcelData.xls");
		Workbook rwb=Workbook.getWorkbook(excelFile);
		Sheet rsh=rwb.getSheet(2);
		int nour=rsh.getRows();
		
		for(int i=1;i<nour;i++)
		{
			String userName=rsh.getCell(0,i).getContents();
			String password=rsh.getCell(1, i).getContents();
		
		
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","D:\\DataDrivenFile\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Login to the application
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.name("SubmitLogin")).click();

	}
	}

}
