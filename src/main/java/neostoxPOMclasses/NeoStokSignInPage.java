package neostoxPOMclasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStokSignInPage {


	@FindBy(xpath = "(//input[@type='number'])[1]") private WebElement MobileNumberField;

	@FindBy(xpath = "(//a[text()='Sign In'])[2]") private WebElement SignInButton;

    public NeoStokSignInPage (WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }

    public void EnterMobileNumber(String mobNum)
    {
    	MobileNumberField.sendKeys(mobNum);
    	Reporter.log("entered mobile number",true);
    }
    
    public void ClickOnSignInButton()
    {
		SignInButton.click();
		Reporter.log("clicked on SignInButton ",true);
    }

















































}
