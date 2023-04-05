package neostoxPOMclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility {
	//excel
	//wait
	//screenshot
	//scrol into view
	//read data from properties file
	
	public static String ReadDataFromPropertiesFile(String Key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream("C:\\Users\\ankit_ilg3qq0\\eclipse-workspace\\20_eve_selenium_MVN\\myproperty.properties");
		prop.load(myfile);
		String value = prop.getProperty(Key);
		return value;	
	}

	public static String ReadDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		File myfile=new File("C:\\Users\\ankit_ilg3qq0\\Selenium\\20_Auj_Eve.xlsx");
		Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet6");
		String value = mysheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("reading data from excel row is "+row+"cell is "+cell,true);
		Reporter.log("data is "+value,true);
		return value;
	}

	public static void implicitwait(WebDriver driver,int time)
	{
	   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	   Reporter.log("waiting for "+time+"ms",true);
	}
	
	public static void takescreenshot(WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String s=RandomString.make(3);
		File dest=new File("C:\\Users\\ankit_ilg3qq0\\Selenium\\ScreenShot\\"+fileName+s+".jpeg");
	    FileHandler.copy(src, dest);
	    Reporter.log("taking screen shot",true);
	    Reporter.log("taken screen shot and saving it in "+dest,true);
	}
	
	public static void ScrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoview(true)",element);
		Reporter.log("scroling in "+element.getText(),true);
	}
}
