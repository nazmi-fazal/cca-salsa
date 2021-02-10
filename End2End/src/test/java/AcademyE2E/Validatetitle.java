package AcademyE2E;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import resources.LandingPage;

public class Validatetitle extends Base {
	
@BeforeTest
	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("Url"));
	}
	
	
	@Test
	
	public void validate_title() throws IOException
	
	{
		
		LandingPage l=new LandingPage(driver);
		String actualtext=l.gettext().getText();
		String Expected="FEATURED COURSES";
		
		Assert.assertEquals(actualtext, Expected);
		
	
	
	

}
@AfterTest
	
	public void Teardown()
	{
		driver.close();
	}
}
