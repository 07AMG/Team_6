package neoStoxTestClasses;

import org.testng.annotations.Test;


import neostoxPOMclasses.NeoStokHomePage;
import neostoxPOMclasses.NeoStokPasswordPage;
import neostoxPOMclasses.NeoStokSignInPage;
import neostoxPOMclasses.NeoStoxDashBoardPage;
import neostoxPOMclasses.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

@Listeners(neoStoxTestClasses.Listener.class)

public class ValidatingUserNameUsingListener extends Base{
 
	NeoStokHomePage home;
	NeoStokSignInPage sign;
	NeoStokPasswordPage pass;
	NeoStoxDashBoardPage dash;

	
	@BeforeClass
 public void launchingBROWSER() throws IOException 
 {
	 LaunchBrowser();
	 home=new NeoStokHomePage(driver);
	 sign=new NeoStokSignInPage(driver);
	 pass=new NeoStokPasswordPage(driver);
	 dash=new NeoStoxDashBoardPage(driver);
 }
 
  @BeforeMethod
  public void LogintoNEOSTOX() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  home.ClickOnSignUpButton();
	  Utility.implicitwait(driver, 1000);
	  
	  sign.EnterMobileNumber(Utility.ReadDataFromPropertiesFile("UN"));
	  Thread.sleep(1000);
	  sign.ClickOnSignInButton();
	  Utility.implicitwait(driver, 1000);
	  
	  pass.SendPassword(Utility.ReadDataFromPropertiesFile("PS"));
	  pass.ClickOnSubmitButton();
	  Utility.implicitwait(driver, 5000);
	  
	  dash.ClickOnOkPopUpButton();
	  Utility.implicitwait(driver, 1000);
  }

  @Test
  public void validateUSERNAME() throws EncryptedDocumentException, IOException 
  {
	 
	  Assert.assertEquals(dash.ActualUserName(),Utility.ReadDataFromPropertiesFile("EUN"),"ACTUAL AND EXPECTED NOT MATCHING SO FAIL");
      
      Utility.implicitwait(driver, 1000);
  }
  
  @Test
  public void validateACCOUNTBALANCE() throws IOException
  {
	  Assert.assertNotNull(dash.ValidateAcbalance(),"Ac null test case failed");
	  
  }
  @AfterMethod
  public void logotfromNEOSTOX() throws InterruptedException 
  {
	  dash.logOutFromNeoStox();
	  Utility.implicitwait(driver, 1000);
  }

  @AfterClass
  public void closingNEOSTOX() throws InterruptedException 
  {
	  driver.close();
	  Reporter.log("closing neostox",true);
	  Thread.sleep(1000);
  }

}
