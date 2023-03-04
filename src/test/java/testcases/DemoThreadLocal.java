package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoThreadLocal {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		
		WebDriver driver1=new FirefoxDriver();
		
		ThreadLocal<Integer> th1=new ThreadLocal<Integer>();
		th1.set(200);
		
		System.out.println(th1.get());
		
		ThreadLocal<String> th2=new ThreadLocal<String>();
		th2.set("Selenium");
		
		System.out.println(th2.get());
		
		ThreadLocal<WebDriver> th3=new ThreadLocal<WebDriver>();
		th3.set(driver1);
		
		th3.get().get("http://www.google.com");
		th3.get().findElement(By.name("q")).sendKeys("ThreadLocal");
		System.out.println(th3.get().getTitle());
		th3.get().quit();
		

	}

}
