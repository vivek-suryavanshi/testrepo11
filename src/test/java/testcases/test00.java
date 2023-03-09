package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test00 {
WebDriver driver;
	
	@BeforeMethod
	public void browserLaunch()
	{
		
		driver = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@Test
	public void JS_prompt() throws InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();		
		
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("testmessage");
		driver.switchTo().alert().accept();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'entered')]")).getText().contains("testmessage"));
		System.out.println("prompt verification done");
		
		driver.quit();
		
	}

}
