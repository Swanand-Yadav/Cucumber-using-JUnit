package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Cucumber_Project\\src\\test\\resources\\global.properties");
		Properties prop=new Properties();// This class have the ability to read the properties file.
		prop.load(fis);
		String url=prop.getProperty("QAurl");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		
		String browser=browser_maven!=null ? browser_maven : browser_properties; // turnery operator
		
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		    	driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				//firefox code
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;
	}
}
