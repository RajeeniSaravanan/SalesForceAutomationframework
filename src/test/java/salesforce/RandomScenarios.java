package salesforce;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.AWTException;	
import java.awt.Robot;	

public class RandomScenarios extends SalesForceBaseTest 
{

	//Test passed
	@Test
	public void case_33_UserVerification() throws InterruptedException
	{
	
		loginSalesforce();
		WebElement homeElement = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		ExplicitWaitElement(homeElement);
		click(homeElement, "Home Element");

		Thread.sleep(3000);
		switchToLightningPopup();

		String expectedTitle = "Salesforce - Developer Edition";
		assertPageTitle(expectedTitle);

		String expectedProfileName="Rajeeni Sarav";
		WebElement profileName = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		ExplicitWaitElement(profileName);

		String actualProfileName = profileName.getText();
		Assert.assertEquals(actualProfileName, expectedProfileName);

		WebElement name = driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a"));
		ExplicitWaitElement(name);
	   
		String nameType = name.getTagName();
		Assert.assertEquals(nameType, "a");
		System.out.println("Profile name is link text");

	    click(name, "Profile Name");

	    String namePageTitle = driver.getTitle();
	    System.out.println("Name Page title is :" + namePageTitle);
	   
	    WebElement userMenu = driver.findElement(By.id("userNavLabel"));
	    ExplicitWaitElement(userMenu);
	    click(userMenu, "userMenu");

	    WebElement myProfile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
	    ExplicitWaitElement(myProfile);
	    click(myProfile, "myProfile");

	    String myProfilePageTitle = driver.getTitle();
	    System.out.println("Profile page title is :" + myProfilePageTitle);

	    Assert.assertEquals(namePageTitle,myProfilePageTitle);
	    System.out.println("Pass, Both pages are same");  
	   
	}
	
	//Test passed
	@Test
	public void case_34_EditedLastNameVerification() throws InterruptedException
	{
		
	   loginSalesforce();
	   WebElement homeElement = driver.findElement(By.xpath("//li[@id='home_Tab']/a"));
	   ExplicitWaitElement(homeElement);
	   click(homeElement, "Home Element");

	   Thread.sleep(3000);
	   switchToLightningPopup();

	   String expectedTitle = "Salesforce - Developer Edition";
	   assertPageTitle(expectedTitle);

	   WebElement name = driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a"));
	   ExplicitWaitElement(name);
	   click(name, "Profile Name");
	   

	   WebElement editPenElement = driver.findElement(By.xpath("//div[@class='contactInfo profileSection']//img[@title='Edit Profile'][1]"));
	   ExplicitWaitElement(editPenElement);
	   
	   click(editPenElement, "editPen");
	   
	   driver.switchTo().frame("contactInfoContentId");
	   System.out.println("Switched to frame");
	   
	   WebElement aboutTab = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
	   ExplicitWaitElement(aboutTab);
	   click(aboutTab, "aboutTab");
	   
	   WebElement lastName = driver.findElement(By.id("lastName"));
	   ExplicitWaitElement(lastName);
	   lastName.clear();
	   lastName.sendKeys("Sarav");
	   
	   WebElement saveAll = driver.findElement(By.xpath("//input[@value='Save All']"));
	   click(saveAll, "saveAll");
	   
	   String expectedProfileName="Rajeeni Sarav ";
	   WebElement profileName = driver.findElement(By.xpath("//div[@class='chatterBreadcrumbs']/span[3]"));
	   ExplicitWaitElement(profileName);

	   String actualProfileName = profileName.getText();
	   System.out.println(actualProfileName);
	   Assert.assertEquals(actualProfileName, expectedProfileName);
	   System.out.println("Pass, Edited last name updated in the profile");
	}
	
	//Test failed
	@Test
	public void case_35_CustomizeTabVerification() throws InterruptedException
	{
		loginSalesforce();
		ArrayList<String> tabsBeforeCustomizationExpectedItems = new ArrayList<String>();
		tabsBeforeCustomizationExpectedItems.add("Home");
		tabsBeforeCustomizationExpectedItems.add("Chatter");
		tabsBeforeCustomizationExpectedItems.add("Profile");
		tabsBeforeCustomizationExpectedItems.add("People");
		tabsBeforeCustomizationExpectedItems.add("Groups");
		tabsBeforeCustomizationExpectedItems.add("Files");
		tabsBeforeCustomizationExpectedItems.add("Accounts");
		tabsBeforeCustomizationExpectedItems.add("Opportunities");
		tabsBeforeCustomizationExpectedItems.add("Cases");
		tabsBeforeCustomizationExpectedItems.add("Contacts");
		tabsBeforeCustomizationExpectedItems.add("");
		tabsBeforeCustomizationExpectedItems.add("");

		Collection<WebElement> tabBarMenus = driver.findElements(By.xpath("//ul[@id='tabBar']/li"));
		int i=0;

		for(WebElement list:tabBarMenus)
		{
			Assert.assertEquals(list.getText().trim(), tabsBeforeCustomizationExpectedItems.get(i), "Tabs not matched");
			i++;
		}
		System.out.println("Tabs matched before customization");

		WebElement showAllTabs = driver.findElement(By.xpath("//li[@id=\"AllTab_Tab\"]//a"));
		ExplicitWaitElement(showAllTabs);
	   
		click(showAllTabs, "Show All Tabs");

		Thread.sleep(3000);

		WebElement customizeMyTabs = driver.findElement(By.xpath("//td[@class='bCustomize']/input"));
		ExplicitWaitElement(customizeMyTabs);
	   
		click(customizeMyTabs, "Customize My Tabs");
		Thread.sleep(2000);

		WebElement selectedTabs = driver.findElement(By.xpath("//select[@id='duel_select_1']/option[9]"));
		actionElement(selectedTabs);
		click(selectedTabs, "Selected Tabs");


		WebElement removeTab = driver.findElement(By.xpath("//img[@title='Remove']"));
		actionElement(removeTab);

		click(removeTab, "Remove Tab");

		WebElement saveCustomizeTabs = driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[1]"));
		ExplicitWaitElement(saveCustomizeTabs);
	   
		click(saveCustomizeTabs, "Save Customize Tabs");

		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);

		actionElement(userMenuDropdown);

		click(userMenuDropdown, "UserMenu Dropdown");

		WebElement LogoutElement = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
		Thread.sleep(4000);

		click(LogoutElement, "LogoutElement");
		
		Thread.sleep(3000);
		loginSalesforce();

		Collection<WebElement> customizedTabBarMenus = driver.findElements(By.xpath("//ul[@id='tabBar']/li"));

		tabsBeforeCustomizationExpectedItems.remove("Contacts");
		i=0;

		for(WebElement list:customizedTabBarMenus)
		{
			Assert.assertEquals(list.getText().trim(), tabsBeforeCustomizationExpectedItems.get(i), "Tabs not matched");
			i++;
		}
		System.out.println("Tabs matched after customization");
	}
	
	
	//Test passed
	@Test
	public void case36_BlockingEventInCalendar() throws InterruptedException
	{
		
		loginSalesforce();
		
		WebElement homeTab = driver.findElement(By.xpath("//ul[@id='tabBar']/li[1]/a"));

		click(homeTab, "Home Tab");

		Thread.sleep(3000);

		 switchToLightningPopup();

		WebElement currUserName = driver.findElement(By.xpath("//span[@class='pageType']/h1/a"));

		String actUserName = "Rajeeni Sarav";

		String expUserName = currUserName.getText();



		Assert.assertEquals(actUserName, expUserName);

		log.info("User Name is displayed with First and Last name.");

		//report.logTestInfo("User Name is displayed with First and Last name.");



		WebElement currDateLink = driver.findElement(By.xpath("//span[@class='pageDescription']/a"));



		String expDateLink = currDateLink.getText();

		SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM d, YYYY");

		Date date = new Date();

		String actDateLink = sdf.format(date);



		Assert.assertEquals(actDateLink, expDateLink);

		log.info("Date format is displayed as expected.");

		//report.logTestInfo("Date format is displayed as expected.");



		click(currDateLink, "Current Date Link");



		String actTitle = "Calendar for " + actUserName + " ~ Salesforce - Developer Edition";

		//String expTitle = getPageTitle(driver);
		assertPageTitle(actTitle);


		//Assert.assertEquals(actTitle, expTitle);

		log.info("Calender for FirstName and LastName page is displayed");

		//report.logTestInfo("Calender for FirstName and LastName page is displayed");

		

		WebElement startTime = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"));

		click(startTime, "Click on 8PM");

		Thread.sleep(3000);

		String actEventTitle = "Calendar: New Event ~ Salesforce - Developer Edition";

		//String expEventTitle = getPageTitle(driver);
		assertPageTitle(actEventTitle);


		//Assert.assertEquals(actEventTitle, expEventTitle);

		log.info("New Event page is displayed");

		//report.logTestInfo("New Event page is displayed");

		WebElement subject = driver.findElement(By.xpath("//input[@id='evt5']"));

		//Verify_ElementDisplay(subject, "Subject Field");

		WebElement subCombo = driver.findElement(By.xpath("//div[@class='requiredInput']/a"));

		click(subCombo, "Clicking on Subject Combo");



		String parent_window = driver.getWindowHandle();

		Set<String> all_windows = driver.getWindowHandles();



		for (String s : all_windows) {

			if (!s.equals(parent_window)) {

				driver.switchTo().window(s);

				WebElement eventOther = driver.findElement(By.xpath("//div[2]/ul/li[5]/a"));

				click(eventOther, "Selecting Other Event Type");

				driver.switchTo().window(parent_window);

			}

		}

		driver.switchTo().activeElement();



		WebElement endTime = driver.findElement(By.id("EndDateTime_time"));



		enterText(endTime, "Start Time", "9:00 PM");

		

		WebElement saveBtn = driver.findElement(By.name("save"));

		click(saveBtn, "Save Button");

	}
	
	//Test failed
	@Test
	public void case37_BlockingEventRecurrence() throws InterruptedException, AWTException
	{
		
		loginSalesforce();
		
		WebElement homeTab = driver.findElement(By.xpath("//ul[@id='tabBar']/li[1]/a"));

		click(homeTab, "Home Tab");

		Thread.sleep(3000);

		switchToLightningPopup();

		WebElement currUserName = driver.findElement(By.xpath("//span[@class='pageType']/h1/a"));

		String actUserName = "Rajeeni Sarav";

		String expUserName = currUserName.getText();



		Assert.assertEquals(actUserName, expUserName);

		log.info("User Name is displayed with First and Last name.");

		//report.logTestInfo("User Name is displayed with First and Last name.");



		WebElement currDateLink = driver.findElement(By.xpath("//span[@class='pageDescription']/a"));



		String expDateLink = currDateLink.getText();

		SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM d, YYYY");

		Date date = new Date();

		String actDateLink = sdf.format(date);



		Assert.assertEquals(actDateLink, expDateLink);

		log.info("Date format is displayed as expected.");

		//report.logTestInfo("Date format is displayed as expected.");



		click(currDateLink, "Current Date Link");



		String actTitle = "Calendar for " + actUserName + " ~ Salesforce - Developer Edition";

		//String expTitle = getPageTitle(driver);
		
		assertPageTitle(actTitle);

		//Assert.assertEquals(actTitle, expTitle);

		log.info("Calender for FirstName and LastName page is displayed");

		//report.logTestInfo("Calender for FirstName and LastName page is displayed");



		WebElement startTime = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]/a"));

		click(startTime, "Click on 4PM");

		Thread.sleep(3000);

		String actEventTitle = "Calendar: New Event ~ Salesforce - Developer Edition";

		//String expEventTitle = getPageTitle(driver);
		assertPageTitle(actEventTitle);


		//Assert.assertEquals(actEventTitle, expEventTitle);

		log.info("New Event page is displayed");

		//report.logTestInfo("New Event page is displayed");

		WebElement subject = driver.findElement(By.xpath("//input[@id='evt5']"));

		//Verify_ElementDisplay(subject, "Subject Field");

		WebElement subCombo = driver.findElement(By.xpath("//div[@class='requiredInput']/a"));

		click(subCombo, "Clicking on Subject Combo");



		String parent_window = driver.getWindowHandle();

		Set<String> all_windows = driver.getWindowHandles();



		for (String s : all_windows) {

			if (!s.equals(parent_window)) {

				driver.switchTo().window(s);

				WebElement eventOther = driver.findElement(By.xpath("//div[2]/ul/li[5]/a"));

				click(eventOther, "Selecting Other Event Type");

				driver.switchTo().window(parent_window);

			}

		}

		//driver.switchTo().activeElement();

	

		String expSubjectValue = subject.getText();





		WebElement endTime = driver.findElement(By.id("EndDateTime_time"));

//		Select selEndTime = new Select(endTime);

//		String expDispTime = selEndTime.getFirstSelectedOption().getText();

		enterText(endTime, "7:00 PM", "Start time");

//		String expDispTime = get_Text(endTime);

//		

//		String actDispTime = "7:00 PM";

//

//		Assert.assertEquals(actDispTime, expDispTime);

//		log.info("End time is selected as 7:00 PM");



		/*

		 * List<WebElement> allOptions = selEndTime.getAllSelectedOptions();

		 * 

		 * String[] timeOptions = { "5:00 PM", "5.30 PM", "6:00 PM", "6:30 PM",

		 * "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM",

		 * "10:30 PM", "11:00 PM", "11:30 PM" }; int i = 0; for (WebElement item :

		 * allOptions) { if (item.getText().equalsIgnoreCase(timeOptions[i])) {

		 * log.info(timeOptions[i] + " is displayed"); } else { log.info(timeOptions[i]

		 * + " is NOT displayed"); } i++; } selEndTime.selectByVisibleText("7:00 PM");

		 * String expectedEndTime = selEndTime.getFirstSelectedOption().getText();

		 * String actualEndTime = "7:00 PM";

		 * 

		 * Assert.assertEquals(actualEndTime, expectedEndTime);

		 * log.info("End time is selected as 7:00 PM");

		 */

		WebElement recurrEvent = driver.findElement(By.id("IsRecurrence"));

		ExplicitWaitElement(recurrEvent);

		click(recurrEvent, "Checking Recurrence of Events");



		WebElement recurrType = driver.findElement(By.xpath("//*[@id=\"recpat\"]/table/tbody/tr[1]/td[1]/label"));



		//Verify_ElementDisplay(recurrType, "Frequency is displayed");



		WebElement recurrStart = driver.findElement(By.id("RecurrenceStartDateTime"));

		//Verify_ElementDisplay(recurrStart, "Recurrence Start is displayed");



		WebElement recurrEnd = driver.findElement(By.id("RecurrenceEndDateOnly"));

		//Verify_ElementDisplay(recurrEnd, "Recurrence End is displayed");



		WebElement RecurrWeekly = driver.findElement(By.xpath("//label[contains(text(),'Weekly')]"));

		click(RecurrWeekly, "Weekly recurrence");



		WebElement recurEvery = driver.findElement(By.id("wi"));

		//Verify_ElementDisplay(recurEvery, "Recurrs every text box");



		WebElement day1 = driver.findElement(By.id("1"));

		WebElement day2 = driver.findElement(By.id("2"));

		WebElement day3 = driver.findElement(By.id("4"));

		WebElement day4 = driver.findElement(By.id("8"));

		WebElement day5 = driver.findElement(By.id("16"));

		WebElement day6 = driver.findElement(By.id("32"));

		WebElement day7 = driver.findElement(By.id("64"));



		String actualDay = null;



		if (day1.isSelected())

			actualDay = "Sunday";

		else if (day2.isSelected())

			actualDay = "Monday";

		else if (day3.isSelected())

			actualDay = "Tuesday";

		else if (day4.isSelected())

			actualDay = "Wednesday";

		else if (day5.isSelected())

			actualDay = "Thursday";

		else if (day6.isSelected())

			actualDay = "Friday";

		else if (day7.isSelected())

			actualDay = "Saturday";



		SimpleDateFormat simpleDay = new SimpleDateFormat("EEEE");

		Date day = new Date();

		String expectedDay = simpleDay.format(day);

		Assert.assertEquals(actualDay, expectedDay);

		log.info("Current Day is selected");



		Robot robot = new Robot();

		robot.mouseWheel(2);



		WebElement recurEndDate = driver.findElement(By.id("RecurrenceEndDateOnly"));



		LocalDate today = LocalDate.now();

		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM-dd-yyyy");



		LocalDate plus2Weeks = today.plusWeeks(2);

		String dateString = plus2Weeks.format(df);

		enterText(recurEndDate, dateString, "Recurrence end date");



		WebElement saveBtn = driver.findElement(By.name("save"));

		click(saveBtn, "Save Button");



		WebElement eventCreated = driver

				.findElement(By.xpath("//*[@id='p:f:j_id25:j_id69:20:j_id71:0:j_id72:calendarEvent:j_id84']/a/span"));

		//Verify_ElementDisplay(eventCreated, "Event Created");



		WebElement monthView = driver.findElement(By.xpath("//*[@id=\"bCalDiv\"]/div/div[2]/span[2]/a[3]/img"));

		click(monthView, "Clicking Month View");



		WebElement thisMonth = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[2]/span[5]/a"));

		//Verify_ElementDisplay(thisMonth, "Month view display");


		Thread.sleep(3000);
		WebElement firstOccur = driver

				.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[2]/div[1]/div[1]/table/tbody/tr[4]/td[7]"));



		WebElement secondOccur = driver

				.findElement(By.xpath("//*[@id='bodyCell']/div[2]/div[1]/div[1]/table/tbody/tr[4]/td[7]/div[2]/a"));



		WebElement thirdOccur = driver

				.findElement(By.xpath("//*[@id='bodyCell']/div[2]/div[1]/div[1]/table/tbody/tr[5]/td[7]/div[2]/a"));



		//Verify_ElementDisplay(firstOccur, "First event occurence");

		//Verify_ElementDisplay(secondOccur, "Second event occurence");

		//Verify_ElementDisplay(thirdOccur, "Third event occurence");


		Thread.sleep(3000);
		WebElement subjectType = driver.findElement(By.xpath("//*[@id='p:f:j_id25:j_id69:10:j_id71:0:j_id72:calendarEvent:j_id84']/a/span"));

		//Verify_ElementDisplay(subjectType, "Subject type 'Other'");



		log.info("Other is selected as Event subject");

		//report.logTestInfo("Other is selected as Event subject");

	}
		
}
