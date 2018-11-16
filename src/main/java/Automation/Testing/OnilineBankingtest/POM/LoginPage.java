package Automation.Testing.OnilineBankingtest.POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import Automation.DataDrivenTesting.BaseDriver;

public class LoginPage extends BaseDriver {
	
	public static final By link_onlineBanking=By.xpath("//a[text()='ONLINE BANKING LOGIN']");
	public static final By link_Personal=By.xpath("//a[text()='PERSONAL']");
	public static final By link_Smallbusiness=By.xpath("//a[text()='SMALL BUSINESS']");
	public static final By link_AltoroMutual=By.xpath("//a[text()='INSIDE ALTORO MUTUAL']");
	public static final By txt_username=By.id("uid");
	public static final By txt_Password=By.id("passw");
	public static final By btn_login=By.name("btnSubmit");
	public static final By label_errormessage=By.id("_ctl0__ctl0_Content_Main_message");
	
	
	
	public boolean isOnlinebankingDisplayed() {
		boolean isDisplayed=driver.findElement(link_onlineBanking).isDisplayed();
		return isDisplayed;
		}
	
	public boolean ispersonalDisplayed() {
		boolean isDisplayed=driver.findElement(link_Personal).isDisplayed();
		return isDisplayed;
		}
	public boolean isSmallbusinessDisplayed() {
		boolean isDisplayed=driver.findElement(link_Smallbusiness).isDisplayed();
		return isDisplayed;
		}
	
	public boolean isAltoroMutualDisplayed() {
		boolean isDisplayed=driver.findElement(link_AltoroMutual).isDisplayed();
		return isDisplayed;
		}


    public void Login(String username,String password) {
    	driver.findElement(txt_username).clear();
    	driver.findElement(txt_username).sendKeys(username);
    	driver.findElement(txt_Password).sendKeys(password);
    	driver.findElement(btn_login).click();
    	
    }
      public String getErrorMessage() {
    	  String value=driver.findElement(label_errormessage).getText();
		return value;
		}
      public void HandleAlert() throws InterruptedException {
    	  Alert alert=driver.switchTo().alert();
    	  String straAlerttext=alert.getText();
    	 Thread.sleep(2000);
    	  alert.accept();
    	  System.out.println(straAlerttext);
      }
     
}
