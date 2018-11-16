package Automation.Testing.OnilineBankingtest.POM;

import org.openqa.selenium.By;

import Automation.Tisting.OnlineBankingTest.BaseDriver;

public class AccountHistory extends BaseDriver{
	
	public static final By label_AccountHistory=By.id("_ctl0__ctl0_Content_Main_accountid");
	public static final By td_EndingBalenceDate=By.xpath("//td[contains(text(),'Ending balance as of')]");
	
	
	public String getaccountHistorylable() {
		String strvalue=driver.findElement(label_AccountHistory).getText();
		return strvalue;
		}
	public String getBalenceDate() {
		String strvalue=driver.findElement(td_EndingBalenceDate).getText();
		return strvalue;
		}
	

}
