package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	static ThreadLocal<WebDriver> threadLocal;
	
	public static WebDriver getBrowserInstance()
	{
		driver=threadLocal.get();
		return driver;
	}
	
	public static WebDriver startBrowser(String browserName, String applicationURL) 
	{

		if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("GC")
				|| browserName.equalsIgnoreCase("Google Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if(browserName.equalsIgnoreCase("Safari"))
		{
			driver=new SafariDriver();
		}
		else {
			driver = new ChromeDriver();
		}

		threadLocal=new ThreadLocal<WebDriver>();
		threadLocal.set(driver);
		
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

		driver.get(applicationURL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
