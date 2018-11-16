package testNG;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Automation.DataDrivenTesting.BaseDriver;
import Automation.Testing.OnilineBankingtest.POM.HomePage;
import Automation.Testing.OnilineBankingtest.POM.LoginPage;
import Automation.Tisting.OnlineBankingTest.CaptureScreenshot;
import Automation.Tisting.OnlineBankingTest.PropertiesReader;

public class OnlineBankingTest_testNGDetaprovider extends BaseDriver{
	//private static final String HomePageTittle = ;
	static String username;
	static String password;
	static String invalidusername;
	static String invalidpassword;
	static String savingAccountNumber;
	static String chekingAccountNumber;
	static String loginpage_errormessag="Login Failed: Your password appears to be invalid. Please re-enter your password carefully.";
	static String ExpectedTittle;
	
	static ExtentReports report;
	static ExtentTest test;
	
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
		 
		 report=new ExtentReports("Reports/OnlineBankingTest.html");
		}
	@Parameters({"browser"})
	@BeforeClass
	public void DriverSetup(String browser) throws IOException {
		//lanch browser
				BaseDriver bdriver=new BaseDriver();
				bdriver.getDriver(browser);
		        driver.get("http://demo.testfire.net/bank/login.aspx");
	}
	@DataProvider(name="Logindata")
	public Object[][] createTestData(){
		
		return new Object[][] {
			{"tc_01","Negative Testcase","jsmith","Demo123"},
			{"tc_02","Negative Testcase","jsmith1","Demo1234"},
			{"tc_03","Negative Testcase","jsmith1","Demo12345"},
			{"tc_04","Negative Testcase with alert","","Demo123"},
			{"tc_05","Negative Testcase with alert","jsmith",""},
			{"tc_06","Negative Testcase with alert","",""},
			{"tc_07","Positive Testcase","jsmith","Demo1234"},
		};
				
	
		
	}
	
		@Test(dataProvider="Logindata")
		
		public  void verifyValidLogin(String TCnumber,String TestDiscription,String username,String password) throws IOException, InterruptedException {
			test=report.startTest(TCnumber);
			LoginPage lp=new LoginPage();
			lp.Login(username, password);
			if(TestDiscription.contains("Positive Testcase")) {
				HomePage hp=new HomePage();
				String actualTittle=hp.getTittle();
				String screenshotpath=CaptureScreenshot.screenshot("verifyValidLogin");
				if(actualTittle.equals(ExpectedTittle)) {
					//System.out.println("pass:home page is displayed");
					test.log(LogStatus.PASS,ExpectedTittle );
				}else {
					//System.out.println("fail:home page is not displayed");
					test.log(LogStatus.FAIL,ExpectedTittle) ;
				}
				
				//CaptureScreenshot.takescreenshot("verifyValidLogin");	
			}
			else if(TestDiscription.contains("Negative Testcase with alert")){
				lp.HandleAlert();
				test.log(LogStatus.PASS,"Alert is displayed" );
				}else if(TestDiscription.equals("Negative Testcase")) {
					String strErrormsg=lp.getErrorMessage();
					System.out.println(strErrormsg);
					String screenshotpath=CaptureScreenshot.screenshot(TCnumber);
					test.log(LogStatus.PASS,test.addScreenCapture(strErrormsg) );
				}
			
	}
		@AfterTest
		public void closedriver() {
			report.endTest(test);
			report.flush();
			driver.close();
		
}


}
