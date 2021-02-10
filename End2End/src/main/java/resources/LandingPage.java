package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By login=By.xpath("//span[contains(text(),'Login')]");
	By email=By.xpath("//input[@id='user_email']");
	By password=By.xpath("//input[@type='password']");
	
	By loginbutton=By.xpath("//input[@value='Log In']");
	
	By text=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigation=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		
	}//constructor for initializing with driver obj frm test class
	
	 public WebElement navigationCheck()
		{
			
			return driver.findElement(navigation);
			
		}
    public WebElement getlogin()
	{
		
		return driver.findElement(login);
		
	}
	
	public WebElement getEmail()
	{
		
		return driver.findElement(email);
	}
	public WebElement getpassword()
	{
		
		return driver.findElement(password);
	}
	
	public WebElement clickLogin()
	{
		
		return driver.findElement(loginbutton);
	}

	public WebElement gettext()
	{
		return driver.findElement(text);
	}
}
