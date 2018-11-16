package Automation.Tisting.OnlineBankingTest;

import java.io.IOException;
import java.util.Properties;

import Automation.DataDrivenTesting.BaseDriver;
import Automation.Testing.OnilineBankingtest.POM.HomePage;
import Automation.Testing.OnilineBankingtest.POM.LoginPage;

public class OnlineBankingJUnit extends BaseDriver{
	//private static final String HomePageTittle = ;
	static String username;
	static String password;
	static String invalidusername;
	static String invalidpassword;
	static String savingAccountNumber;
	static String chekingAccountNumber;
	static String loginpage_errormessag="Login Failed: Your password appears to be invalid. Please re-enter your password carefully.";
	static String ExpectedTittle;
	public static void main(String[] args) throws IOException {
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
		
		//lanch browser
		BaseDriver bdriver=new BaseDriver();
		bdriver.getDriver();
        driver.get("http://demo.testfire.net/bank/login.aspx");
		//verify all login page links
		verifyLoginPageLinks();
		//verify invalid login
		verifyInvalidLogin();
		//verify valid login 
	verifyValidLogin();
	}	
		public static void verifyLoginPageLinks() {
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
	//CaptureScreenshot.takescreenshot("verifyLoginPageLinks");
		}
		
		public static void verifyInvalidLogin() {
			LoginPage lp=new LoginPage();
			lp.Login(invalidusername, invalidpassword);
			String actualerrormsg=lp.getErrorMessage();
			
			
			if(actualerrormsg.contains(loginpage_errormessag)) {
				System.out.println("pass:error message is matching");
			}else {
				System.out.println("fail:error message is not matching");
			}
		
			//CaptureScreenshot.takescreenshot("verifyInvalidLogin");
	}
		public static void verifyValidLogin() {
			LoginPage lp=new LoginPage();
			lp.Login(username, password);
			HomePage hp=new HomePage();
			String actualTittle=hp.getTittle();
			
			
			if(actualTittle.equals(ExpectedTittle)) {
				System.out.println("pass:home page is displayed");
			}else {
				System.out.println("fail:home page is not displayed");
			}
			//CaptureScreenshot.takescreenshot("verifyValidLogin");

	}

}
