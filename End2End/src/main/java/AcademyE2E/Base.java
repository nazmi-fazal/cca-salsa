package AcademyE2E;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;

	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		 prop =new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\muham\\eclipse-workspace\\End2End\\src\\main\\java\\AcademyE2E\\Global.properties");
		
		prop.load(fis);
		String BrowserName=prop.getProperty("Browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			 driver=new ChromeDriver();
			 
		}
		
		else if(BrowserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BrowserName.equals("ie"))
		{
			//driver=new In
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//declare implicit wait
		return driver;
		
	}
	
	public void  getScreenshot(String testMethodName ,WebDriver driver) throws IOException
	{
		
		TakesScreenshot sr=((TakesScreenshot)driver);
		File src= sr.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\Reports\\"+testMethodName+ ".png";
		//copying the screenshot image with testcase name under the project path under the report folder
		FileUtils.copyFile(src, new File(destFile));
	
		}
	}
		
		
	
	
	

