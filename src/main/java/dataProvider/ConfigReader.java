package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


	public static String getProperty(String key)
	{
		
		Properties pro=new Properties();
		
		try 
		{
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/config/config.properties")));
		} catch (FileNotFoundException e) {
			
			System.out.println("Could not find properties file "+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Could not load properties file "+e.getMessage());

		}
		
		String value=pro.getProperty(key);
		
		return value;
	}
	
	public static String getProperty(String key,String configName)
	{
		
		Properties pro=new Properties();
		
		try 
		{
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/config/"+configName+".properties")));
		} catch (FileNotFoundException e) {
			
			System.out.println("Could not find properties file "+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Could not load properties file "+e.getMessage());

		}
		
		String value=pro.getProperty(key);
		
		return value;
	}
	
}
