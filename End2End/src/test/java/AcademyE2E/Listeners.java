package AcademyE2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends Base implements ITestListener{

	ExtentReports extent=ExtendReporterNG.getReport();
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		test= extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		
		String testMethodName=result.getMethod().getMethodName();
		//holds the name of the test method name which  is failing.
		try
		{
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			/*getting the driver instance from the testcase class 
			getfield to get the field from super class and getDeclaredField is used
			to get data from the same class
			
			*/
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		try 
		{
			getScreenshot(testMethodName,driver );//calling the method in Base class
		} 
		catch (IOException e1) {
			
			e1.printStackTrace();
		}//calls the method of base class to take screenshot
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	
	

}
