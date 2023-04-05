package neostoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxDashBoardPage 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement PopUpOkButton;

	@FindBy(id = "lbl_username") private WebElement UserName;

	@FindBy(xpath = "//span[text()='Logout']") private WebElement LogOutButton;
	
	@FindBy(id="lbl_curbalancetop") private WebElement ACbalance;


	public NeoStoxDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void ClickOnOkPopUpButton()throws InterruptedException 
	{
	//Utility.ScrollIntoView(driver, PopUpOkButton);
    if(PopUpOkButton.isDisplayed())
    {
	PopUpOkButton.click();
	Thread.sleep(500);
	}
    else
    {
    	Reporter.log("there is no popUP",true);
    }
	}
	
	 public String ValidateAcbalance()
	    {
	    	String acountB = ACbalance.getText();
	    	Reporter.log("getting ACbalance",true);
	    	Reporter.log("ACblance is "+acountB,true);
	    	return acountB;
	    }

	public void logOutFromNeoStox() throws InterruptedException
	{
		UserName.click();
		Thread.sleep(500);
		LogOutButton.click();
		Reporter.log("loging out from neostox",true);
		
	}


	//to get string returntype in test class
	public String ActualUserName()
	{
		String ACTUN = UserName.getText();
		Reporter.log("geting actual username ",true);
		Reporter.log("actual name is "+ACTUN,true);
		
		return ACTUN;
	}


   











}
