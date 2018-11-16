package Automation.Tisting.OnlineBankingTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseDriver {
public static WebDriver driver;
	public  WebDriver getDriver(String browser) throws IOException {
		// TODO Auto-generated method stub
		
		PropertiesReader pr=new PropertiesReader();
		Properties p=pr.getProperty();
		
		//p.load(reader);
		//String browser=p.getProperty("browser");
		System.out.println(browser);
		String path = p.getProperty("chromedriverpath");
		System.out.println(path);
		
		if(browser.equalsIgnoreCase("CHROME")) {
			// Added by Ravi for Testing
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ravisankar\\Desktop\\QA salinium\\Webdriver\\WebDriverProject\\chromedriver_win32\\chromedriver.exe");
			
			//System.setProperty("Webdriver.chrome.driver",p.getProperty("chromedriverpath"));
			//driver=new ChromeDriver();
			ChromeOptions chromeoptions=new ChromeOptions();
			chromeoptions.addArguments("--disable-notifications");
			driver=new ChromeDriver(chromeoptions);
			
		}
		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("Webdriver.ie.driver","C:\\Users\\Ravisankar\\Desktop\\QA salinium\\Webdriver\\WebDriverProject\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
			//System.setProperty("Webdriver.ie.driver",p.getProperty("IEdriverpath"));
			driver=new InternetExplorerDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")){
			System.setProperty("Webdriver.gecko.driver",p.getProperty("GeckoDriverPath"));
			System.setProperty("Webdriver.ie.driver",p.getProperty("IEdriverpath"));
			driver=new FirefoxDriver();	
		}
		else {
			System.out.println("please enter the currect browser");
	
		}
		 driver.get("https://www.google.com/");
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	
	//private static WebDriver manage() {
		// TODO Auto-generated method stub
		return driver;
	}
	
	public  WebDriver getDriver() throws IOException {
		// TODO Auto-generated method stub
		
		PropertiesReader pr=new PropertiesReader();
		Properties p=pr.getProperty();
		
		//p.load(reader);
		String browser=p.getProperty("browser");
		System.out.println(browser);
		String path = p.getProperty("chromedriverpath");
		System.out.println(path);
		
		if(browser.equalsIgnoreCase("CHROME")) {
			// Added by Ravi for Testing
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ravisankar\\Desktop\\QA salinium\\Webdriver\\WebDriverProject\\chromedriver_win32\\chromedriver.exe");
			
			//System.setProperty("Webdriver.chrome.driver",p.getProperty("chromedriverpath"));
			//driver=new ChromeDriver();
			ChromeOptions chromeoptions=new ChromeOptions();
			chromeoptions.addArguments("--disable-notifications");
			driver=new ChromeDriver(chromeoptions);
			
		}
		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("Webdriver.ie.driver","C:\\Users\\Ravisankar\\Desktop\\QA salinium\\Webdriver\\WebDriverProject\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
			//System.setProperty("Webdriver.ie.driver",p.getProperty("IEdriverpath"));
			driver=new InternetExplorerDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")){
			System.setProperty("Webdriver.gecko.driver",p.getProperty("GeckoDriverPath"));
			System.setProperty("Webdriver.ie.driver",p.getProperty("IEdriverpath"));
			driver=new FirefoxDriver();	
		}
		else {
			System.out.println("please enter the currect browser");
	
		}
		 driver.get("https://www.google.com/");
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	
	//private static WebDriver manage() {
		// TODO Auto-generated method stub
		return driver;
	}
	

}
					
		
     
     
   
     
     
     
     
     
     
     
  
	


