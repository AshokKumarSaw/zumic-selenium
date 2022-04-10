package com.zumic.automation;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class Practice_Selenium extends TestBase {
	@BeforeClass
	public void doSkip() {

		initialize();

	}

	

	@Test(dataProvider = "getTestData")
	public void SmokeTestCase(String testID, String url, String validSearch1, String validSearch2,
			String invalidSearch1, String invalidSearch2, String Disqus_Email,
			String Disqus_Password, String Dis_Comment, String ConcertLocation) throws InterruptedException, IOException {

		System.out.println("Starting Test:" + testID);
		if (WebUIAutomation.checkTestCaseRunmode(testID)) {
			System.out.println("RunMode is Yes");
			launchBrowser();
			Thread.sleep(3000);

			// Open Page URL: https://zumic.com/
			Reporter.log("Opening the Zumic page URL : " + url);
			driver.navigate().to(url);
			System.out.println(" The Zumic page URL is opened : " + url);
			Thread.sleep(3000);
			driver.manage().window().maximize();
			Thread.sleep(3000);

			// Click on Login/Register button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Login/Register"),
					"Clicking on the [Login/Register] button isn't successful.");
			Thread.sleep(3000);

			Reporter.log("The User is logged-in to the Zumic : " + url);
			// Calling Login function from BusinessFunctions class to Login into zumic.com
			BusinessFunctions.doLogin();
			Thread.sleep(3000);

			Reporter.log("The User is logged-out from the Zumic : " + url);
			// Calling Logout function from BusinessFunctions class to Logout from zumic.com
			BusinessFunctions.doLogout();

			//......................................................................................
			
			
			
//			String count=driver.getWindowHandle();
//			System.out.println(count);
//			Set<String>count1=driver.getWindowHandles();
//			int count2=count1.size();
//			System.out.println(count2);
//	WebElement webElement= driver.switchTo().activeElement();
//	webElement.sendKeys(Keys.CONTROL+"a");
//	webElement.sendKeys(Keys.DELETE);
//			System.out.println(webElement);
//		webElement.sendKeys(Keys.ENTER);
//		webElement.sendKeys(Keys.F12);
//			
//			Dimension d= new Dimension(400,500);
//			driver.manage().window().setSize(d);
//			Thread.sleep(2000);
//			Point p=new Point(50,50);
//			driver.manage().window().setPosition(p);
//			Thread.sleep(2000);
//			
			
//			String pageSrc=driver.getPageSource();
//			System.out.println(pageSrc);
//			String[] s=pageSrc.split("");
//			int c=0;
//			for(String v:s)
//			{
//				if(v.equalsIgnoreCase("Zumic"))
//				{
//				c++;
//				}
//				System.out.println(c);
//				
//			}
			
//			driver.manage().deleteAllCookies();
			
			
//			Date d=new Date();
//			System.out.println(d);
//			String s=d.toString();
//			System.out.println(s);
//			String s1=s.replaceAll(":", "-");
//			System.out.println(s1);
//			
//			
//			WebDriver dr=new ChromeDriver();
//		TakesScreenshot t	=(TakesScreenshot)dr;
//		File srcFile=t.getScreenshotAs(OutputType.FILE);
//			File desFile=new File("./photo/ "+s1+".png");
//			FileUtils.copyFile(srcFile, desFile);
			
			
			
//			JavascriptExecutor js=	(JavascriptExecutor)driver;
//			js.executeScript("document.getElementById('firstName').value='testuser'");
			
			
		//	Alert alert=driver.switchTo().alert();
		//	alert.getText();
		//	alert.accept();
		//	alert.dismiss();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		}

		else {

			System.out.println("RunMode is No");
			throw new SkipException("Skipping / Ignoring - Script not Ready for Execution ");

		}
	}

	@AfterMethod
	public void preparingToShutDown() {
		try {

			closeBrowser();

		} catch (Exception e) {

		}

	}

	@DataProvider(name = "getTestData")
	public static Object[][] getData() {

		return WebUIAutomation.getData("LoginSmokeTestCase");

	}
}


		
	
