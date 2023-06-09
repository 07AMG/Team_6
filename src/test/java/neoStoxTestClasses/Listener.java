package neoStoxTestClasses;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import neostoxPOMclasses.Utility;


public class Listener extends Base implements ITestListener
{
	
public void onTestFailure(ITestResult result) 
{
	try {
		Utility.takescreenshot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	public void onTestSuccess(ITestResult result)
  {
		Reporter.log("tc "+ result.getName()+" passed ",true);
	}

}
