package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By socialMediaIcons=By.xpath("//div[@class='social-btns']//a");

	By nav=By.xpath("//span[@class='navbar-toggler-icon']");
	
	By signOut=By.xpath("//button[normalize-space()='Sign out']");
	
	By loginButton=By.xpath("//button[normalize-space()='Log in']");
	
	public LoginPage clickOnLogin()
	{
		driver.findElement(nav).click();
		driver.findElement(loginButton).click();	
		LoginPage login=new LoginPage(driver);
		
		return login;
		
	}
	
	public void signOutFromApplication()
	{
		driver.findElement(nav).click();
		driver.findElement(signOut).click();
	}
	
	
	public int getSocialMediaCount()
	{
		return driver.findElements(socialMediaIcons).size();
	}
	
	
	
	
}
