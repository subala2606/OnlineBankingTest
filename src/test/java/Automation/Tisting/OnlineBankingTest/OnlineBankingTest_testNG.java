package Automation.Tisting.OnlineBankingTest;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation.DataDrivenTesting.BaseDriver;
import Automation.Testing.OnilineBankingtest.POM.HomePage;
import Automation.Testing.OnilineBankingtest.POM.LoginPage;

public class OnlineBankingTest_testNG extends BaseDriver{
	//private static final String HomePageTittle = ;
	static String username;
	static String password;
	static String invalidusername;
	static String invalidpassword;
	static String savingAccountNumber;
	static String chekingAccountNumber;
	static String loginpage_errormessag="Login Failed: Your password appears to be invalid. Please re-enter your password carefully.";
	static String ExpectedTittle;
	
	@BeforeSuite
	public void Setup() throws IOException {
		// TODO Auto-generated method stub
		PropertiesReader pr=new PropertiesReader();
		Properties p=pr.getProperty();
		
		 username=p.getProperty("username");
		 password=p.getProperty("password");
		 invalidusername=p.getProperty("invalidusername");
		 invalidpassword=p.getProperty("invalidpassword");
		 savingAccountNumber=p.getProperty("savingAccountNumber");
		 chekingAccountNumber=p.getProperty("chekingAccountNumber");
		 ExpectedTittle=p.getProperty("HomePageTittle");
		}
	@Parameters({"browser"})
	@BeforeClass
	public void DriverSetup(String browser) throws IOException {
		//lanch browser
				BaseDriver bdriver=new BaseDriver();
				bdriver.getDriver(browser);
		        driver.get("http://demo.testfire.net/bank/login.aspx");
	}
	@Test(groups= {"Regrestion","smoke"})
		public static void verifyLoginPageLinks() throws IOException {
			LoginPage lp=new LoginPage();
			
	boolean isOnlinebankingDisplayed=lp.isOnlinebankingDisplayed();
	boolean ispersonalDisplayed=lp.ispersonalDisplayed();
	boolean isSmallbusinessDisplayed=lp.isSmallbusinessDisplayed();
	boolean isAltoroMutualDisplayed=lp.isAltoroMutualDisplayed();
	if(isOnlinebankingDisplayed && ispersonalDisplayed && isSmallbusinessDisplayed && isAltoroMutualDisplayed) {
		System.out.println("pass:all links are displayed in login page");
	}else {
		System.out.println("fail:all links are displayed in login page");
		
	}
	CaptureScreenshot.takescreenshot("verifyLoginPageLinks");
		}
		@Test(groups= {"Regrestion","smoke"})
		public  void verifyInvalidLogin() throws IOException {
			LoginPage lp=new LoginPage();
			lp.Login(invalidusername, invalidpassword);
			String actualerrormsg=lp.getErrorMessage();
			
			
			if(actualerrormsg.contains(loginpage_errormessag)) {
				System.out.println("pass:error message is matching");
			}else {
				System.out.println("fail:error message is not matching");
			}
		
			CaptureScreenshot.takescreenshot("verifyInvalidLogin");
	}
		@Test(groups= {"Regrestion"})
		public  void verifyValidLogin() throws IOException {
			LoginPage lp=new LoginPage();
			lp.Login(username, password);
			HomePage hp=new HomePage();
			String actualTittle=hp.getTittle();
			
			
			if(actualTittle.equals(ExpectedTittle)) {
				System.out.println("pass:home page is displayed");
			}else {
				System.out.println("fail:home page is not displayed");
			}
			CaptureScreenshot.takescreenshot("verifyValidLogin");
			
	}
		@AfterTest
		public void closedriver() {
			driver.close();
		
}


}
