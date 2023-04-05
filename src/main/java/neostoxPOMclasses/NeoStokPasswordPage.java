package neostoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStokPasswordPage 
{
	@FindBy(id = "txt_accesspin") private WebElement PassWordField;

	@FindBy(xpath = "//a[text()='Submit']") private WebElement SubmitButton;
		
	public NeoStokPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void SendPassword(String Pass)
	{
		PassWordField.sendKeys(Pass);
		Reporter.log("sending password",true);
	}
	public void ClickOnSubmitButton() throws InterruptedException
	{  
		Thread.sleep(500);
		SubmitButton.click();
		Thread.sleep(1000);
		Reporter.log("click on submitButton",true);
	}





















	
}
