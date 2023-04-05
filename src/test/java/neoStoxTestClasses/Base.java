package neoStoxTestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import neostoxPOMclasses.Utility;



public class Base {
	
	protected static WebDriver driver;
	
	public void LaunchBrowser() throws IOException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ankit_ilg3qq0\\Selenium\\chromedriver.exe");
	
	ChromeOptions co=new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	
	driver=new ChromeDriver(co);
	//driver.get("https://neostox.com/");
	driver.get(Utility.ReadDataFromPropertiesFile("URL"));
	Reporter.log("lanuching neostox ",true);
	driver.manage().window().maximize();
	Utility.implicitwait(driver, 1000);
	
	//comment 1
	
	//comment2
	}

}
