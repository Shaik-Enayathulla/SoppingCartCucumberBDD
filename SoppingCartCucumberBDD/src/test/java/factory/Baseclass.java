package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.lang3.RandomStringUtils;

public class Baseclass {
	static WebDriver driver;
	static Properties p;
	static Logger logger;
	
	public static WebDriver initilizeBrowser() throws IOException
	{
		if(getProperties().getProperty("env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if(getProperties().getProperty("platform").equalsIgnoreCase("Windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(getProperties().getProperty("platform").equalsIgnoreCase("Mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(getProperties().getProperty("platform").equalsIgnoreCase("Linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching OS..");
			}
			 switch(getProperties().getProperty("browser").toLowerCase())
			 {
				 case "chrome": cap.setBrowserName("Chrome"); break;
				 case "edge": cap.setBrowserName("MicrosoftEdge"); break;
				 case "firefox": cap.setBrowserName("FireFox"); break;
				 default: System.out.println("No matching browser");
			 }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}
		
		else if(getProperties().getProperty("env").equalsIgnoreCase("local"))
		{
			switch(getProperties().getProperty("browser").toLowerCase()) 
			{
			case "chrome":
		        driver=new ChromeDriver();
		        break;
		    case "edge":
		    	driver=new EdgeDriver();
		        break;
		    case "firefox":
		    	driver=new FirefoxDriver();
		    	break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
	 driver.manage().deleteAllCookies(); 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	 
	 return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Properties getProperties() throws IOException
	{
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getlogger()
	{
		logger=LogManager.getLogger(); 
		return logger;
	}
	
	public static String randowmstring()
	{
		String str = RandomStringUtils.randomAlphabetic(6);
		return str;
	}
	
	public static String randomnumber()
	{
		String strnum = RandomStringUtils.randomNumeric(5);
		return strnum;
	}
	
	public static String randomalphanumaric()
	{
		String rstr = RandomStringUtils.randomAlphabetic(5);
		String rnum = RandomStringUtils.randomNumeric(5);
		return rstr+rnum;
	}
}

