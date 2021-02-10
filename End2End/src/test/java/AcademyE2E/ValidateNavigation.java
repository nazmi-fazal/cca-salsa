package AcademyE2E;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.LandingPage;

public class ValidateNavigation extends Base {
@BeforeTest
	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("Url"));
	}
	
	
	@Test
	
	public void Validate_Navigation() throws IOException
	
	{
		
		LandingPage l=new LandingPage(driver);
		
	Assert.assertTrue(l.navigationCheck().isDisplayed());
		
	
	
	

}
@AfterTest
	
	public void Teardown()
	{
		driver.close();
	}
}
