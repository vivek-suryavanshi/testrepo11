package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.Utility;

public class ExtentManager {

	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		
		if(extent==null)
		{
			extent=createInstance();
			return extent;
		}
		else
		{
			return extent;
		}
	
	}
	
	
	
	public static ExtentReports createInstance()
	{
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/AutomationReport_"+Utility.getCurrentTimeStamp()+".html");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Automation Sprint Report");
		reporter.config().setEncoding("utf-8");
		reporter.config().setReportName("Automation Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
		
	}
	
	
}
