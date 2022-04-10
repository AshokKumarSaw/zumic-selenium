package com.zumic.automation;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_Smoke_Test_Cases extends TestBase {
	public Login_Smoke_Test_Cases() {
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
			String invalidSearch1, String invalidSearch2, String Disqus_Email,
			String Disqus_Password, String Dis_Comment, String ConcertLocation) throws InterruptedException {

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

			
			
 // 18.Link testing of header
			
			Reporter.log("18.Link testing of the Zumic headers");
			// Click on Explore Tab
			Reporter.log("Click on Explore Tab");
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
			
			
 //19.Verification of Global search functionality
			
			
			Reporter.log("19.Verification of Global search functionality");
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



			
 //20. Link testing of Trending Concerts
			
			Reporter.log("20.Link testing of Trending Concert(s)");
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

			// Click on upvote symbol for any event
			Reporter.log("Click on up vote symbol for any event");
			Assert.assertTrue(WebUIAutomation.clickObj("ICON_Upvote"),
					"Clicking on the up vote symbol for an event isn't successful.");
			System.out.println("Clicked on the up vote symbol for an event");
			Thread.sleep(3000);

			// Click on any Concert link
			Reporter.log("Click on the any concert link displayed under Trending option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Randomly_chosen_Concert"),
					"Clicking on the concert link displayed under Trending option isn't successful.");
			System.out.println("Clicked on the concert link displayed under Trending option");
			Thread.sleep(4000);
			

	/*		WebUIAutomation.scrollDownOnScreen(8850);
			Thread.sleep(5000);
			WebUIAutomation.scrollDownOnScreen(600);
			driver.switchTo().frame(WebUIAutomation.getObject("IFRAME_Comments_Section"));
			WebUIAutomation.clickObj("ICON_Discus_Login");
			System.out.println("Clicked on the Disqus Icon");
			driver.switchTo().defaultContent();
    		Thread.sleep(3000);
    		*/
    		
/*			
		//NOTE:Comment can not be automated here as Captcha can not be handled using selenium.	
			WebUIAutomation.SwitchWindows();
			Thread.sleep(3000);
			WebUIAutomation.setText("INPUT_Email", Disqus_Email);
			WebUIAutomation.setText("INPUT_Password", Disqus_Password);
			Thread.sleep(3000);
			WebUIAutomation.clickObj("BTN_Login");
			Thread.sleep(3000);
			WebUIAutomation.setText("TXT_BOX_Comment", Dis_Comment);
			Thread.sleep(3000);
			WebUIAutomation.clickObj("BTN_Post_Comment");
			Thread.sleep(3000);
*/

			// Click on any link displayed under Trending option
						Reporter.log("Click on the any music link displayed under Trending option");
						Assert.assertTrue(WebUIAutomation.clickObj("LNK_Music_To_Rate"),
								"Clicking on the Music link displayed under Trending option isn't successful.");
						System.out.println("Clicked on the Music link displayed under Trending option");
						Thread.sleep(4000);	
					
						// Click on the rating star icon to rate the Music
						Reporter.log("Click on the rating star icon to rate the Music displayed under Trending option");
						Assert.assertTrue(WebUIAutomation.clickObj("BTN_Rate"),
								"Clicking on rating star icon to rate the Music displayed under Trending option isn't successful.");
						System.out.println("Clicked on rating star icon to rate the Music displayed under Trending option");
						Thread.sleep(3000);		
			

 
  //21.Link testing of Popular Concerts
               
              
    		Reporter.log("21.Link testing of Popular Concert(s)");
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

			// Click on up vote symbol for any event
			Reporter.log("Click on up vote symbol for any event");
			Assert.assertTrue(WebUIAutomation.clickObj("ICON_Upvote1"),
					"Clicking on the up vote symbol for an event isn't successful.");
			System.out.println("Clicked on the up vote symbol for an event");
			Thread.sleep(3000);

			// Click on any Concert/Music link
			Reporter.log("Click on the any Concert/Music link displayed under Popular option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Randomly_chosen_Music"),
					"Clicking on the concert/Music link displayed under Popular option isn't successful.");
			System.out.println("Clicked on the concert/Music link displayed under Popular option");
			Thread.sleep(3000);
			
			WebUIAutomation.scrollDownOnScreen(9000);
			Thread.sleep(3000);
			driver.switchTo().frame(WebUIAutomation.getObject("IFRAME_Comments_Section"));
			WebUIAutomation.clickObj("ICON_Discus_Login");
			System.out.println("Clicked on the Disqus Icon");
			driver.switchTo().defaultContent();
			Thread.sleep(3000);

			
			
 //22.Link testing of Latest Concerts


			Reporter.log("22 .Link testing of Latest Concert(s)");
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
			
			// Click on up vote symbol for any event
						Reporter.log("Click on up vote symbol for any event");
						Assert.assertTrue(WebUIAutomation.clickObj("ICON_Upvote2"),
								"Clicking on the up vote symbol for an event isn't successful.");
						System.out.println("Clicked on the up vote symbol for an event");
						Thread.sleep(3000);

			// Click on any concert link
			Reporter.log("Click on the any concert link displayed under Latest option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Randomly_chosen_Concert1"),
					"Clicking on the concert link displayed under Latest option isn't successful.");
			System.out.println("Clicked on the concert link displayed under Latest option");
			Thread.sleep(3000);
					
			WebUIAutomation.scrollDownOnScreen(9200);
			Thread.sleep(3000);
			driver.switchTo().frame(WebUIAutomation.getObject("IFRAME_Comments_Section"));
			WebUIAutomation.clickObj("ICON_Discus_Login");
			driver.switchTo().defaultContent();
			Thread.sleep(8000);
			
			
 //23.Link testing of Top Rated Concerts
			 
			Reporter.log("23 .Link testing of Top Rated Concert(s)");
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

			
			// Click on up vote symbol for any event
			Reporter.log("Click on up vote symbol for any event");
			Assert.assertTrue(WebUIAutomation.clickObj("ICON_Upvote3"),
					"Clicking on the up vote symbol for an event isn't successful.");
			System.out.println("Clicked on the up vote symbol for an event");
			Thread.sleep(3000);
			
			// Click on any concert link
			Reporter.log("Click on the any concert link displayed under Top Rated option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Randomly_chosen_Concert2"),
					"Clicking on the concert link displayed under Top Rated option isn't successful.");
			System.out.println("Clicked on the concert link displayed under Top Rated option");
			Thread.sleep(3000);
			
			WebUIAutomation.scrollDownOnScreen(1800);
			Thread.sleep(3000);
			driver.switchTo().frame(WebUIAutomation.getObject("IFRAME_Comments_Section"));
			WebUIAutomation.clickObj("ICON_Discus_Login");
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
				
			// Click on the any link displayed under Top Rated option to Rate
			Reporter.log("Click on the any music link displayed under Top Rated option");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Music_To_Rate3"),
					"Clicking on the Music link displayed under Top Rated option isn't successful.");
			System.out.println("Clicked on the Music link displayed under Top Rated option");
			Thread.sleep(3000);	
		
		
			
			
 //24.Link testing of "Explore Genres"
			
			Reporter.log("24.Link testing of \"Explore Genres\"");
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
			
			
 //25.Verifying "Follow - feature artist" button
			 
			Reporter.log("25.Verifying \"Follow - feature artist\" button");
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

			
 //26.Link Testing of Social Media Icons
			
			Reporter.log("26.Link Testing of Social Media Icons");
			// Click on Face book icon displayed at the bottom of the home page
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
			
			
 //27.Verfying News letter subscription
			
			Reporter.log("27.Verfying News letter subscription");
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
			
			
 //28.Link testing of Footer 
			 
			Reporter.log("28. Link testing of Footer ");
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
			Thread.sleep(3000);

			// Click on "Jobs" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"Jobs\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_Jobs"),
					"Clicking \"Jobs\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"Jobs\" footer link displayed at the bottom of the home page");
			Thread.sleep(4000);

			// Click on "FAQ" footer link displayed at the bottom of the home page
			Reporter.log("Click on \"FAQ\" footer link displayed at the bottom of the home page");
			Assert.assertTrue(WebUIAutomation.clickObj("LNK_FAQ"),
					"Clicking \"FAQ\" footer link displayed at the bottom of the home page isn't successful.");
			System.out.println("Clicked on \"FAQ\" footer link displayed at the bottom of the home page");
			Thread.sleep(3000);

			// Click on "Local Concerts" footer link displayed at the bottom of the home
			// page
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
			Thread.sleep(3000);


 //29.Link verification of Local Concerts page
			
			Reporter.log("29. Link verification of Local Concerts page");
				// Click on Local Concerts Tab 
			 Reporter.log("Click on Local Concerts Tab");
			Assert.assertTrue(WebUIAutomation.clickObj("TAB_Local_Concerts"),
					"Clicking on the [Local_Cocerts] Tab isn't successful.");
			System.out.println("Clicked on Local Concerts Tab");
			Thread.sleep(4000);


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
			
			
			
 //30.Link verification of New Music page
			 
			Reporter.log("30.Link verification of  New Music page");
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


  //31.Link verification of Explore page
              
			Reporter.log("31.Link verification of Explore page");
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
               
               
 //32.Testing Avatar's functionality

			
			Reporter.log("32.Testing Avatar's functionality");
			// Click on Profile and Check Sign Out button is displayed or not
						Assert.assertTrue(WebUIAutomation.isObjPresent("DRPDWN_SignOut_Header", 30), "Profile button isn't present");

						// click on profile dropdown button
						Assert.assertTrue(WebUIAutomation.clickObj("DRPDWN_SignOut_Header"), "");
			
						// Click on Feed option from the profile dropdown
						Reporter.log("Click on Feed option from the profile dropdown");
						Assert.assertTrue(WebUIAutomation.clickObj("LNK_Feed"),
								"Clicking on the Feed option from the profile dropdown isn't successful.");
						System.out.println("Clicked on Feed option from the profile dropdown");
						Thread.sleep(3000);
						
						
						// Click on "Following" Tab option
						Reporter.log("Click on \"Following\" option from the profile");
						Assert.assertTrue(WebUIAutomation.clickObj("TAB_Following"),
								"Clicking on \"Following\" option from the profile\" isn't successful.");
						System.out.println("Clicked on \"Following\" option from the profile");
						Thread.sleep(3000);
			
			              
						// Click on "Favorite" Tab option
						Reporter.log("Click on \"Favorite\" option from the profile");
						Assert.assertTrue(WebUIAutomation.clickObj("TAB_Favorite"),
								"Clicking on \"Favorite\" option from the profile\" isn't successful.");
						System.out.println("Clicked on \"Favorite\" option from the profile");
						Thread.sleep(3000);
						
						// Click on "Settings" Tab option
						Reporter.log("Click on \"Settings\" option from the profile");
						Assert.assertTrue(WebUIAutomation.clickObj("TAB_Settings"),
								"Clicking on \"Settings\" option from the profile\" isn't successful.");
						System.out.println("Clicked on \"Settings\" option from the profile");
						Thread.sleep(3000);
					
						Reporter.log("The User is logged-out from the Zumic : " + url);
			// Calling Logout function from BusinessFunctions class to Logout from zumic.com
			BusinessFunctions.doLogout();

			
			

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
