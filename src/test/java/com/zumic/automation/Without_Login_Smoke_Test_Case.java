
package com.zumic.automation;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Without_Login_Smoke_Test_Case extends TestBase {

	public Without_Login_Smoke_Test_Case() {
		super();
	}

	@BeforeClass
	public void doSkip() {

		initialize();

	}

	/**
	 * @param testID
	 * @param url
	 * @throws InterruptedException
	 */

	@Test(dataProvider = "getTestData")
	public void SmokeTestCase(String testID, String url, String validSearch1, String validSearch2,
			String invalidSearch1, String invalidSearch2, String Password_Reg, String Username, String GmailID, String GmailPassword, String ConcertLocation)
			throws InterruptedException {

		System.out.println("Starting Test:" + testID);
		if (WebUIAutomation.checkTestCaseRunmode(testID)) {
			System.out.println("RunMode is Yes");
			launchBrowser();
			Thread.sleep(3000);

			
 //1.Pre-login Verification to reach the site 
			
			Reporter.log("1.Pre-login Verification to reach the site : " + url);
			// Open Page URL: // https://zumic.com/
			Reporter.log("Opening the Zumic page URL : " + url);
			driver.navigate().to(url);
			System.out.println(" The Zumic page URL is opened : " + url);
			Thread.sleep(3000);
			driver.manage().window().maximize();
			Thread.sleep(3000);

					
 //2.Link testing of the Zumic headers
             
			Reporter.log("2.Link testing of the Zumic headers");
			// Click on Explore Tab Reporter.log("Click on Explore Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Explore"),
					"Clicking on the [Explore] Tab isn't successful.");
			System.out.println("Clicked on Explore Tab");
			Thread.sleep(3000);
			
			// Click on Choose location link
			Reporter.log("Click on Choose location link");
			Assert.assertTrue(WebUIAutomation.clickObj("LINK_Choose_Location"),
					"Clicking on the Choose location link isn't successful.");
			System.out.println("Clicked on Choose location link");
			Thread.sleep(3000);

			// Choose the Concert location 
			 Reporter.log("Choose the Concert location");
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Concert_Location", ConcertLocation),
					"Entering the Concert Location isn't successful.");
			System.out.println("Entered the Concert Location" + ConcertLocation);
			Thread.sleep(2000);
			Assert.assertTrue(WebUIAutomation.clickObj("OPTION_Concert_Location"), "Unbale to click on the 1st option");
			Thread.sleep(3000);

			// Click on Local Concerts Tab 
			
			Reporter.log("Click on Local Concerts Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Local_Concerts"),
					"Clicking on the [Local_Cocerts] Tab isn't successful.");
			System.out.println("Clicked on Local Concerts Tab");
			Thread.sleep(3000);

			// Click on New Music Tab 
			
			Reporter.log("Click on New Music Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_New_Music"),
					"Clicking on the [New Music] Tab isn't successful.");
			System.out.println("Clicked on New Music Tab");
			Thread.sleep(3000);
	
			
			
			
 //3.Verification of Global search functionality
			
			Reporter.log("3.Verification of Global search functionality");
			// Enter the first valid value in the search box and click on search button
			Reporter.log("Enter the first valid value in the search box");
			Assert.assertTrue(WebUIAutomation.setText("BOX_Search", validSearch1),
					"Entering the the first valid value in the search box isn't successful.");
			System.out.println("Entered the first valid value in the search box:" + validSearch1);

			Reporter.log("Click on the [Search] button");
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Search"),
					"Clicking on the [Search] button isn't successful.");
			System.out.println("Clicked on the Search button");
			Thread.sleep(3000);

			// Enter the second valid value in the search box and click on search button
			Reporter.log("Enter the second valid value in the search box");
			Assert.assertTrue(WebUIAutomation.setText("BOX_Search", validSearch2),
					"Entering the the second valid value in the search box isn't successful.");
			System.out.println("Entered the second valid value in the search box:" + validSearch2);

			Reporter.log("Click on the [Search] button");
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Search"),
					"Clicking on the [Search] button isn't successful.");
			System.out.println("Clicked on the Search button");
			Thread.sleep(3000);

			// Enter the first invalid value in the search box and click on search button
			Reporter.log("Enter the first invalid value in the search box");
			Assert.assertTrue(WebUIAutomation.setText("BOX_Search", invalidSearch1),
					"Entering the the first invalid value in the search box isn't successful.");
			System.out.println("Entered the first invalid value in the search box:" + invalidSearch1);

			Reporter.log("Click on the [Search] button");
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Search"),
					"Clicking on the [Search] button isn't successful.");
			System.out.println("Clicked on the Search button");
			Thread.sleep(3000);

			// Enter the second invalid value in the search box and click on search button
			Reporter.log("Enter the second invalid value in the search box");
			Assert.assertTrue(WebUIAutomation.setText("BOX_Search", invalidSearch2),
					"Entering the the second invalid value in the search box isn't successful.");
			System.out.println("Entered the second invalid value in the search box:" + invalidSearch2);

			Reporter.log("Click on the [Search] button");
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Search"),
					"Clicking on the [Search] button isn't successful.");
			System.out.println("Clicked on the Search button");
			Thread.sleep(3000);
			
			
 //4.Link testing of Trending Concert(s)
			
              Reporter.log("4.Link testing of Trending Concert(s)");
			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on the the Trending option
			Reporter.log("Click on the Trending option in the zumic Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Trending"),
					"Clicking on the Trending option in the zumic Home page isn't successful.");
			System.out.println("Clicked on the Trending option in the zumic Home page");
			Thread.sleep(3000);

			// Click on any concert link
			Reporter.log("Click on the any concert link displayed under Trending option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Randomly_chosen_Concert"),
					"Clicking on the concert link displayed under Trending option isn't successful.");
			System.out.println("Clicked on the concert link displayed under Trending option");
			Thread.sleep(3000);
			
			
 //5.Link testing of Popular Concerts
			
			Reporter.log("5.Link testing of Popular Concert(s)");
			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on the the Popular option
			Reporter.log("Click on the popular option in the zumic Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Popular"),
					"Clicking on the popular option in the zumic Home page isn't successful.");
			System.out.println("Clicked on the popular option in the zumic Home page");
			Thread.sleep(3000);

			// Click on any Concert/Music link
			Reporter.log("Click on the any Concert/Music link displayed under Popular option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Randomly_chosen_Music"),
					"Clicking on the concert/Music link displayed under Popular option isn't successful.");
			System.out.println("Clicked on the concert/Music link displayed under Popula option");
			Thread.sleep(3000);
			
			
 //6.Link testing of Latest Concerts
			
			Reporter.log("6.Link testing of Latest Concert(s)");
			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on the the Latest option
			Reporter.log("Click on the Latest option in the zumic Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Latest"),
					"Clicking on the Latest option in the zumic Home page isn't successful.");
			System.out.println("Clicked on the Latest option in the zumic Home page");
			Thread.sleep(3000);

			// Click on any concert link
			Reporter.log("Click on the any concert link displayed under Latest option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Randomly_chosen_Concert1"),
					"Clicking on the concert link displayed under Latest option isn't successful.");
			System.out.println("Clicked on the concert link displayed under Latest option");
			Thread.sleep(3000);



  //7.Link testing of Top Rated Concerts

             Reporter.log("7.Link testing of Top Rated Concert(s)");
			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on the the Top Rated option
			Reporter.log("Click on the Top Rated option in the zumic Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Top_Rated"),
					"Clicking on the Top Rated option in the zumic Home page isn't successful.");
			System.out.println("Clicked on the Top Rated option in the zumic Home page");
			Thread.sleep(3000);

			// Click on any concert link
			Reporter.log("Click on the any concert link displayed under Top Rated option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Randomly_chosen_Concert2"),
					"Clicking on the concert link displayed under Top Rated option isn't successful.");
			System.out.println("Clicked on the concert link displayed under Top Rated option");
			Thread.sleep(3000);
			
			
			
 //8.Link testing of "Explore Genres"
			
			Reporter.log("8.Link testing of \"Explore Genres\"");
			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on "Jazz" genre under explore genres section
			Reporter.log("Click on \"Jazz\" genre under explore genres section");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Explore_Genre_Jazz"),
					"Clicking on \"Jazz\" genre under explore genres sectionisn't successful.");
			System.out.println("Clicked on \"Jazz\" genre under explore genres section");
			Thread.sleep(3000);
			
			
 //9.Verifying "Follow - feature artist" button
			
			Reporter.log("9.Verifying \"Follow - feature artist\" button");
			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on "follow" button displayed under featured artists section
			Reporter.log("Click on \"follow\" button displayed under featured artists section");
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Artist_Follow"),
					"Clicking on \"follow\" button under featured artists section isn't successful.");
			System.out.println("Clicked on \"follow\" button displayed under featured artists section");
			Thread.sleep(3000);

			// Extracting the the message "You must be logged in to follow artists"
			String text = WebUIAutomation.getObject("TXT_POP_UP_Message").getText();
			System.out.println(text);

			Thread.sleep(3000); // Closing the Login Pop-up
			WebUIAutomation.clickObj("ICON_Close_POP_UP");
			Thread.sleep(3000);
			WebUIAutomation.scrollDownOnScreen();
			Thread.sleep(3000);



 //10.Verify "Join Us" button

			Reporter.log("10.Verify \"Join Us\" button");
			// Click on Join Us button displayed at the bottom of home page
			Reporter.log("Click on Join Us button displayed at the bottom of home page");
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Join_Us"),
					"Clicking on Join Us button displayed at the bottom of home page isn't successful.");
			System.out.println("Clicked on Join Us button displayed at the bottom of home page");
			Thread.sleep(3000);

			String text1 = WebUIAutomation.getObject("PAGE_Login").getText();
			System.out.println(text1);
			Thread.sleep(3000);
			
			
			
 //11.Link Testing of Social Media Icons
			
			
			Reporter.log("11.Link Testing of Social Media Icons");
			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on Facebook icon displayed at the bottom of the home page
			Reporter.log("Click on Facebook icon displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Facebook"),
					"Clicking on Facebook icon displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on Facebook icon displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on Twitter icon displayed at the bottom of the home page
			Reporter.log("Click on Twitter icon displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Twitter"),
					"Clicking on Twitter icon displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on Twitter icon displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on Instagram icon displayed at the bottom of the home page
			Reporter.log("Click on Instagram icon displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Instagram"),
					"Clicking on Instagram icon displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on Instagram icon displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on Youtube icon displayed at the bottom of the home page
			Reporter.log("Click on Youtube icon displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Youtube"),
					"Clicking Youtube icon displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on Youtube icon displayed at the bottom of the home page");
			Thread.sleep(3000);
			
		
			
 //12.Verifying News letter subscription
			
			Reporter.log("12.Verfying News letter subscription");
			// Click on Join Our Newsletter field displayed at the bottom of the home page and Enter the invalid Email
			Reporter.log("Enter the invalid Email in the Join Our Newsletter field");
			userInValidEmail = CommonFunctions.DynamicInValidEmail();
			Assert.assertTrue(WebUIAutomation.setText("LNK_Join_Our_NewsLetter", userInValidEmail),
					"Entering the invalid Email in the Join Our Newsletter field isn't successful.");
			System.out.println("Entered the invalid Email in the Join Our Newsletter field:" + userInValidEmail);

			// Click on Join Our Newsletter submit ICON
			Reporter.log("Click on Join Our Newsletter submit ICON ");
			Assert.assertTrue(WebUIAutomation.clickObj("ICON_Send"),
					"Clicking on Join Our Newsletter submit ICON  isn't successful.");
			System.out.println("Clicked on Join Our Newsletter submit ICON ");
			Thread.sleep(3000);

			// Click on Join Our Newsletter field displayed at the bottom of the home page and Enter the valid Email
			Reporter.log("Enter the valid Email in the Join Our Newsletter field");
			userValidEmail = CommonFunctions.DynamicValidEmail();
			Assert.assertTrue(WebUIAutomation.setText("LNK_Join_Our_NewsLetter", userValidEmail),
					"Entering the valid Email in the Join Our Newsletter field isn't successful.");
			System.out.println("Entered the valid Email in the Join Our Newsletter field:" + userValidEmail);

			// Click on Join Our Newsletter submit ICON
			Reporter.log("Click on Join Our Newsletter submit ICON ");
			Assert.assertTrue(WebUIAutomation.clickObj("ICON_Send"),
					"Clicking on Join Our Newsletter submit ICON  isn't successful.");
			System.out.println("Clicked on Join Our Newsletter submit ICON ");
			Thread.sleep(3000);

			String text2 = WebUIAutomation.getObject("TXT_Newsletter_Joining_Confirmation").getText();
			System.out.println(text2);
			Thread.sleep(3000);



 //13. Link testing of Footer 

            
			Reporter.log("13. Link testing of Footer ");
			// Click on "Who We Are" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"Who We Are\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Who_We_are"),
					"Clicking \"Who We Are\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"Who We Are\" footer link displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on "Explore" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"Explore\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Explore"),
					"Clicking \"Explore\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"Explore\" footer link displayed at the bottom of the home page");
			Thread.sleep(4000);

			// Click on "Jobs" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"Jobs\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Jobs"),
					"Clicking \"Jobs\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"Jobs\" footer link displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on "FAQ" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"FAQ\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_FAQ"),
					"Clicking \"FAQ\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"FAQ\" footer link displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on "Local Concerts" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"Local Concerts\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Local_Concert"),
					"Clicking \"Local Concerts\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"Local Concerts\" footer link displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on "Contact Us" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"Contact Us\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Contact_Us"),
					"Clicking \"Contact Us\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"Contact Us\" footer link displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on "New Music" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"New Music\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_New_Music"),
					"Clicking \"New Music\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"New Music\" footer link displayed at the bottom of the home page");
			Thread.sleep(4000);
		
			
 // 14.Verifying Login/Registration functionality
     
			Reporter.log("14.Verifying Login/Registration functionality");
			// Click on Login/Register button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Login/Register"),
					"Clicking on the [Login/Register] button isn't successful.");
			System.out.println("Clicked on Login/Register button");

			// Click on Register Tab
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Register"),
					"Clicking on the [Register] Tab isn't successful.");
			System.out.println("Clicked on Register Tab");

			// Enter "Your Email" 
			Reporter.log("Enter \"Your Email\"");
			userValidEmail = CommonFunctions.DynamicValidEmail();
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Your_Email_Reg", userValidEmail),
					"Entering \"Your Email\"isn't successful.");
			System.out.println("Entered \"Your Email\":" + userValidEmail);

			// Enter "Your Password" 
			Reporter.log("Enter \"Your Password\"");
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Your_Password_Reg", Password_Reg),
					"Entering \"Your Password\"isn't successful.");
			System.out.println("Entered \"Your Password\":" + Password_Reg);

			// Click on Register button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Register"),
					"Clicking on the [Register] button isn't successful.");
			System.out.println("Clicked on Register button");

			String text3 = WebUIAutomation.getObject("MSG_Email_Already_Taken").getText();
			System.out.println(text3);
			Thread.sleep(3000);
			
			
/*			
 //Automating Gmail is getting hampered due to google security
			TestBase.closeBrowser();
			Thread.sleep(3000);
			// launching the browser to open the mail 
			launchBrowser();
			Thread.sleep(3000);

			// Click on Gmail link
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Gmail"), "Clicking on the Gmail link isn't successful.");
			System.out.println("Clicked on Gmail link");
			Thread.sleep(3000);

			// Click on Gmail Sign In link
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Sign_in"),
					"Clicking on the Gmail Sign In link isn't successful.");
			System.out.println("Clicked on Gmail Sign In link");
			Thread.sleep(3000);

			WebUIAutomation.SwitchWindows();

			// Enter the Gmail Email ID
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Gmail_Email_ID", GmailID),
					"Entering the Gmail Email ID isn't successful.");
			System.out.println("Entered the Gmail Email ID" + GmailID);
			Thread.sleep(3000);

			// Click on the Next button below after entering the Gmail Email ID
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Next_Email"),
					"Clicking on the Next button below after entering the Gmail Email ID isn't successful.");
			System.out.println("Clicked on the Next button below after entering the Gmail Email ID");
			Thread.sleep(3000);

			// Enter the Gmail Password
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Gmail_Password", GmailPassword),
					"Entering the Gmail Password isn't successful.");
			System.out.println("Entered the Password ID" + GmailPassword);
			Thread.sleep(3000);

			// Click on the Next button below after entering the Gmail Password
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Next_Password"),
					"Clicking on the Next button below after entering the Gmail Password isn't successful.");
			System.out.println("Clicked on the Next button below after entering the Gmail Password");
			Thread.sleep(4000);

			// Open the activation Mail
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_gmailInboxPrimary_Activation_Mail"),
					"Opening the activation Mail isn't successful.");
			System.out.println("Opened the activation Mail");
			Thread.sleep(3000);

			// Click on the account activation link
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_To_Activate_Registered_Account_Inside_Mail"),
					"Clicking on the account activation link isn't successful.");
			System.out.println("Clicked on the account activation link");
			Thread.sleep(3000);

			// Enter Username 
			 Reporter.log("Enter \"Username\"");
			 
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Username", Username),
					"Entering \"Username\"isn't successful.");
			System.out.println("Entered \"Username\":" + Username);

			WebUIAutomation.scrollDownOnScreen();

			// Click on Next button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Next"), "Clicking on Next button isn't successful.");
			System.out.println("Clicked on Next button");
			Thread.sleep(3000);

			WebUIAutomation.scrollDownOnScreen(); // Click on Submit button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Submit"), "Clicking on Submit button isn't successful.");
			System.out.println("Clicked on Submit button");
			Thread.sleep(3000);

			BusinessFunctions.doLogout();
			Thread.sleep(3000);

			// Click on Login/Register button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Login/Register"),
					"Clicking on the [Login/Register] button isn't successful.");
			System.out.println("Clicked on Login/Register button");

			// Click on Register Tab
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Register"),
					"Clicking on the [Register] Tab isn't successful.");
			System.out.println("Clicked on Register Tab");

			// Enter "Your Email" 
			 * Reporter.log("Enter \"Your Email\"");
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Your_Email_Reg", Email_Reg),
					"Entering \"Your Email\"isn't successful.");
			System.out.println("Entered \"Your Email\":" + Email_Reg);
			Thread.sleep(3000);

			// Enter "Your Password" 
			 * Reporter.log("Enter \"Your Password\"");
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Your_Email_Reg", Email_Reg),
					"Entering \"Your Email\"isn't successful.");
			System.out.println("Entered \"Your Email\":" + Email_Reg);
			Thread.sleep(3000);

			// Click on Register button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Register"),
					"Clicking on the [Register] button isn't successful.");
			System.out.println("Clicked on Register button");
			Thread.sleep(3000);

			String text4 = WebUIAutomation.getObject("MSG_Email_Already_Taken").getText();
			System.out.println(text4);
			Thread.sleep(3000);

			// Click on Login Tab
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Login"), "Clicking on the [Login] Tab isn't successful.");
			System.out.println("Clicked on Login Tab");
			Thread.sleep(3000);

			BusinessFunctions.doLogin();
			Thread.sleep(3000);

			BusinessFunctions.doLogout();
			Thread.sleep(3000);

			// Click on Login/Register button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_Login/Register"),
					"Clicking on the [Login/Register] button isn't successful.");
			System.out.println("Clicked on Login/Register button");

			// Click on Forgot your password link
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Forgot_Your_Password"),
					"Clicking on Forgot your password link isn't successful.");
			System.out.println("Clicked on Forgot your password link");

			WebUIAutomation.popUpHandler();

			// Enter the E-mail 
			Reporter.log("Enter \"E-mail\"");
			Assert.assertTrue(WebUIAutomation.setText("POPUP_E_Mail_for_Forget_Password", Email_Reg),
					"Entering \"E-mail\"isn't successful.");
			System.out.println("Entered \"E-mail\":" + Email_Reg);
			Thread.sleep(3000);

			// Click on Done button
			Assert.assertTrue(WebUIAutomation.clickObj("BTN_DONE_For_Popup"),
					"Clicking on the [Done] button isn't successful.");
			System.out.println("Clicked on Done button");

			// launching the browser to open the mail 
			launchBrowser(); Thread.sleep(3000);

			// Click on Gmail link
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Gmail"), "Clicking on the Gmail link isn't successful.");
			System.out.println("Clicked on Gmail link");
			Thread.sleep(3000);

			// Open the Reset Password Mail
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_gmailInboxPrimary_Activation_Mail"),
					"Opening the Reset Password Mail isn't successful.");
			System.out.println("Opened the Reset Password Mail");
			Thread.sleep(3000);

			// Click on the Reset Password link
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Reset_Password_link"),
					"Clicking on the Reset Password link isn't successful.");
			System.out.println("Clicked on the Reset Password link");
			Thread.sleep(3000);

			// Enter the New Password Reporter.log("Enter \"New Password\"");
			Assert.assertTrue(WebUIAutomation.setText("INPUT_New_Password", Password_Reg),
					"Entering \"New Password\"isn't successful.");
			System.out.println("Entered \"New Password\":" + Password_Reg);

			// Confirm the New Password Reporter.log("Confirm the New Password");
			Assert.assertTrue(WebUIAutomation.setText("INPUT_Confirm_Password", Password_Reg),
					"Confirming the New Passwordisn't successful.");
			System.out.println("Confirmed the New Password" + Password_Reg);

			// Click on Confirm button
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Gmail"), "Clicking on Confirm button isn't successful.");
			System.out.println("Clicked on Confirm button");
			Thread.sleep(3000);

*/	
			
			
			// Navigate to the zumic Home page
						Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
						Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
								"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
						System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
						Thread.sleep(3000);				
			
			
 // 15. Link verification of Local Concerts page
			  
		     Reporter.log("15. Link verification of Local Concerts page");
			// Click on Local Concerts Tab 
			 Reporter.log("Click on Local Concerts Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Local_Concerts"),
					"Clicking on the [Local_Cocerts] Tab isn't successful.");
			System.out.println("Clicked on Local Concerts Tab");
			Thread.sleep(3000);


			// Click on Any Event Name Under Local Concert Tab
			Reporter.log("Click on Any Event Name under Local Concert Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Event_Name"),
					"Clicking on the Event Name under Local Concert Tab isn't successful.");
			System.out.println("Clicked on Event Name under Local Concert Tab");
			Thread.sleep(3000);


			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on Local Concerts Tab 
			 Reporter.log("Click on Local Concerts Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Local_Concerts"),
					"Clicking on the [Local_Cocerts] Tab isn't successful.");
			System.out.println("Clicked on Local Concerts Tab");
			Thread.sleep(3000);

			// Click on Any Venue Name Under Local Concert Tab
			Reporter.log("Click on Any Venue Name under Local Concert Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Venue_Name1"),
					"Clicking on the Venue Name under Local Concert Tab isn't successful.");
			System.out.println("Clicked on Venue Name under Local Concert Tab");
			Thread.sleep(3000);

			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on Local Concerts Tab 
			 Reporter.log("Click on Local Concerts Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Local_Concerts"),
					"Clicking on the [Local_Cocerts] Tab isn't successful.");
			System.out.println("Clicked on Local Concerts Tab");
			Thread.sleep(3000);

			// Click on Any Get Tickets Link Under Local Concert Tab
			Reporter.log("Click on Any Get Tickets Link under Local Concert Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Get_Ticket"),
					"Clicking on Get Tickets Link under Local Concert Tab isn't successful.");
			System.out.println("Clicked on Get Tickets Link under Local Concert Tab");
			Thread.sleep(3000);


//16.Link verification of New Music page

			Reporter.log("16.Link verification of New Music page");
			// Click on New Music Tab 
			 Reporter.log("Click on New Music Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_New_Music"),
					"Clicking on the [New Music] Tab isn't successful.");
			System.out.println("Clicked on New Music Tab");
			Thread.sleep(3000);

			// Click on Any Music Under New Music Tab
			Reporter.log("Click on Any Music Under New Music Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Music"),
					"Clicking on the Music Under New Music Tab isn't successful.");
			System.out.println("Clicked on Music Under New Music Tab");
			Thread.sleep(3000);

			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on New Music Tab 
			 Reporter.log("Click on New Music Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_New_Music"),
					"Clicking on the [New Music] Tab isn't successful.");
			System.out.println("Clicked on New Music Tab");
			Thread.sleep(3000);

			// Click on Any Music News Under New Music Tab
			Reporter.log("Click on Any Music News Under New Music Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_News"),
					"Clicking on the Music News Under New Music Tab isn't successful.");
			System.out.println("Clicked on Music News Under New Music Tab");
			Thread.sleep(3000);



 // 17.Link verification of Explore page
		
			Reporter.log("17.Link verification of Explore page");
			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on Explore Tab 
			 Reporter.log("Click on Explore Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Explore"),
					"Clicking on the [Explore] Tab isn't successful.");
			System.out.println("Clicked on Explore Tab");
			Thread.sleep(3000);

			// Click on Any Concert Under Explore Tab
			Reporter.log("Click on Any Concert Under Explore Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Concert"),
					"Clicking on the Concert Under Explore Tab isn't successful.");
			System.out.println("Clicked on Concert Under Explore Tab");
			Thread.sleep(3000);

			// Navigate to the zumic Home page
			Reporter.log("Click on the Zumic Header Logo to be navigated to the Home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Zumic_Header_Logo"),
					"Clicking on the Zumic Header Logo to be navigated to the Home page isn't successful.");
			System.out.println("Clicked on the Zumic Header Logo to be navigated to the Home page");
			Thread.sleep(3000);

			// Click on Explore Tab 
			 Reporter.log("Click on Explore Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Explore"),
					"Clicking on the [Explore] Tab isn't successful.");
			System.out.println("Clicked on Explore Tab");
			Thread.sleep(3000);

			// Click on Any Music Under Explore Tab
			Reporter.log("Click on Any Music Under Explore Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Music_Explore"),
					"Clicking on the Music Under Explore Tab isn't successful.");
			System.out.println("Clicked on Music Under Explore Tab");
			Thread.sleep(3000);		
			

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

		return WebUIAutomation.getData("WithoutLoginSmokeTestCase");

	}

}
