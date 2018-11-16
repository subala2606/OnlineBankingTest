package Automation.Testing.OnilineBankingtest.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Automation.DataDrivenTesting.BaseDriver;

public class HomePage extends BaseDriver{
	
	public static final By select_accountlist=By.id("listAccounts");
	public static final By btn_Go=By.id("btnGetAccount");
	public static final By link_AccountSummary=By.xpath("//a[text()='View Account Summary']");
	public static final By link_RecentTransactions=By.xpath("//a[text()='View Recent Transactions']");
	public static final By link_TransferFunds=By.xpath("//a[text()='Transfer Funds']");
	public static final By link_NewsArticles=By.xpath("//a[text()='Search News Articles']");
	public static final By link_CustomizeSiteLanguage=By.xpath("//a[text()='Customize Site Language']");
	
	
	public String getTittle() {
		String actualtitle=driver.getTitle();
		return actualtitle;
		}
	public void selectaccount(String Accountnumber) {
      WebElement element=driver.findElement(select_accountlist);
      Select select=new Select(element);
      select.selectByValue(Accountnumber);
      }

}