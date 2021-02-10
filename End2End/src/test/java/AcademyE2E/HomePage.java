package AcademyE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.LandingPage;

public class HomePage extends Base {
	
	private static Logger log =LogManager.getLogger(HomePage.class.getName());//
	
	@BeforeTest	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		
	}
	
	@Test(dataProvider="putData")
	
	public void HomePageNavigation(String emailadd,String password) throws IOException, InterruptedException
	
	{
		driver.get(prop.getProperty("Url"));
		log.info("home page is loaded ") ;
		LandingPage l=new LandingPage(driver);
		l.getlogin().click();
		
		l.getEmail().sendKeys(emailadd);
		
		l.getpassword().sendKeys(password);
		l.clickLogin().click();
		log.info("Successfully clicked");
		
		
	}
	
	
	@DataProvider 
	
	public Object[][] putData()
	
	{
		
		Object[][] obj=new Object[2][2];
		obj[0][0]="abcd@gmail.com";
		obj[0][1]="abc@123";
		
		obj[1][0]="nazmimuhammed@gmail.com";
		obj[1][1]="abc@12345657586";
		
		return obj;
				
		
		
	}
	
@AfterTest
	
	public void Teardown()
	{
		driver.close();
	}
	
	
	
	

}
