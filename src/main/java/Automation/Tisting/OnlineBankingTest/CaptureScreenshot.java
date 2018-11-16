package Automation.Tisting.OnlineBankingTest;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenshot extends BaseDriver {

	//public static void main(String[] args) {
		//// TODO Auto-generated method stub
		
		public static void takescreenshot(String testCaseName) throws IOException{
			String strPath="Screenshot/";
			TakesScreenshot ts=(TakesScreenshot)driver;
			File screenShotFile=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile,new File(strPath+testCaseName+".png"));
			}
		
		public static void takeAlertScreenShot(String testCaseName) throws IOException, AWTException{
			String strPath="Screenshot/";
			Robot robot=new Robot();
			Rectangle rect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage image = robot.createScreenCapture(rect);
	        ImageIO.write(image, "png", new File(strPath+testCaseName+".png"));
		}
		
		public static String screenshot(String testCaseName) throws IOException{
			String strPath="C:\\Users\\Ravisankar\\Desktop\\QA salinium\\Webdriver\\OnlineBankingTest\\Screenshot\\";
			TakesScreenshot ts=(TakesScreenshot)driver;
			File screenShotFile=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile,new File(strPath+testCaseName+".png"));
			return strPath+testCaseName+".png";
			}
		
	}

