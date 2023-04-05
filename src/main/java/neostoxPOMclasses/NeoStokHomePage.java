package neostoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStokHomePage {

  @FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement SignUpButton;
	
	public NeoStokHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickOnSignUpButton()
	{
		SignUpButton.click();
		Reporter.log("clicked on SignUpButton",true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
