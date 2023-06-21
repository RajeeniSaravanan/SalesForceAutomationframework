package salesforce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import salesforce.LoginTest; 
import org.openqa.selenium.interactions.Actions;

@Listeners(utilities.ListenersTest.class)
public class UserMenuDropDownTest extends SalesForceBaseTest
{

	@Test
	public void case5_UserMenuDropdown() throws InterruptedException
	{
		loginSalesforce();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		
		String subControlMenu[] = {"My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience", "Logout"};
		
		List<WebElement> subMenu = driver.findElements(By.xpath("//div[@id=\"userNav-menuItems\"]/a"));
		
		for(int i=0; i<subControlMenu.length; i++)
		{
			if(subMenu.get(i).getText().equalsIgnoreCase(subControlMenu[i]))
				log.info("Passed: " + subMenu.get(i).getText() + " Menu found");
			else
				log.info("Failed: " + subMenu.get(i).getText() + " Menu not found" );
		
		}	
	}
	
	
	//Testcase passed
	@Test
	public void  case6_MyProfile_userMenuOption1() throws InterruptedException, AWTException
	{
		loginSalesforce();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		
		WebElement myProfileElement = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[1]"));
		ExplicitWaitElement(myProfileElement);
		
		click(myProfileElement, "My Profile");
		

		WebElement editPenElement = driver.findElement(By.xpath("//div[@class='editPen']/a[@class='contactInfoLaunch editLink']"));
	    ExplicitWaitElement(editPenElement);
	    
	    click(editPenElement, "editPen");
	    
	    Thread.sleep(2000);
	    WebElement frameElement= driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
	    driver.switchTo().frame(frameElement);
	    log.info("Switched to frame");
	    
	    WebElement aboutTab = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
	    ExplicitWaitElement(aboutTab);
	    
	    click(aboutTab, "aboutTab");
	    
	    WebElement lastName = driver.findElement(By.id("lastName"));
	    ExplicitWaitElement(lastName);
	    lastName.clear();
	    lastName.sendKeys("Sarav");
	    log.info("Last name changed");
	    
	    WebElement saveAll = driver.findElement(By.xpath("//input[@value='Save All']"));
	    click(saveAll, "saveAll");
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		WebElement postLink = driver.findElement(By.xpath("//div[@id='profileFeed']//li[@label='TextPost']")); // .xpath("//*[@id=\"publisherAttachTextPost\"]"));

		postLink.click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		log.info("on it");
		
		WebElement post_frame = driver.findElement(By.xpath("//iframe[@class ='cke_wysiwyg_frame cke_reset']"));

		
		click(post_frame, "Post Clicking");

		Actions actions = new Actions(driver);

		actions.sendKeys("Hi everyone!").build().perform();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement shareButton = driver.findElement(By.id("publishersharebutton"));
		click(shareButton, "Message Posted");
		
		WebElement fileElement = driver.findElement(By.cssSelector("#publisherAttachContentPost > span:nth-child(2)"));
		ExplicitWaitElement(fileElement);
		click(fileElement, "File");
		
		WebElement uploadfileElement = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		ExplicitWaitElement(uploadfileElement);
		click(uploadfileElement, "Upload File");
	
		WebElement browseButton = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click();", browseButton); //javascript notation to perform click
		
		Robot robot = new Robot();
		robot.delay(2000);
		
		//copy the path of the file in clip board using StringSelection class and ToolKit class
		StringSelection ss = new StringSelection("C:\\Users\\saravanan.somu\\Desktop\\file1.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		robot.delay(2000);
		
		//CTRL-V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.delay(2000);
		
		//ENTER(open)
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("Uploaded file");
		
		WebElement uploadPhotoElement = driver.findElement(By.xpath("//div[@id='photoSection']//img[1]"));
		ExplicitWaitElement(uploadPhotoElement);
		
		actionElement(uploadPhotoElement);
		Thread.sleep(2000);
		uploadPhotoElement.click();
		
		WebElement addPhotoElement = driver.findElement(By.id("uploadLink"));
		ExplicitWaitElement(addPhotoElement);
		click(addPhotoElement, "Add Photo");
		
		driver.switchTo().frame(3);
		System.out.println("Switched to Upload profile photo frame");
		
		WebElement browsePhotoElement = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", browsePhotoElement); //javascript notation to perform click
		
		Robot robot1 = new Robot();
		robot.delay(2000);
		
		//copy the path of the file in clip board using StringSelection class and ToolKit class
		StringSelection s = new StringSelection("C:\\Users\\saravanan.somu\\Desktop\\download.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
		robot1.delay(2000);
		
		//CTRL-V
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyRelease(KeyEvent.VK_V);
		
		robot1.delay(2000);
		
		//ENTER(open)
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement savePhotoElement = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		ExplicitWaitElement(savePhotoElement);
		click(savePhotoElement, "save photo");
		
		WebElement savePhoto = driver.findElement(By.id("j_id0:j_id7:save"));
		ExplicitWaitElement(savePhoto);
		click(savePhoto, "saved photo");
			
	}
	
	@Test
	public void case7_MySettings_UserMenuDropDown() throws InterruptedException, AWTException
	{
		
		loginSalesforce();
		Thread.sleep(3000);
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		ExplicitWaitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		WebElement My_Profile = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]"));
		
		ExplicitWaitElement(My_Profile);
		click(My_Profile, "My Profile");

		Thread.sleep(5000);



		Robot robot = new Robot();

		robot.mouseWheel(2);



		WebElement personal_link = driver.findElement(By.cssSelector(".PersonalInfo_icon"));

		ExplicitWaitElement(personal_link);

		click(personal_link, "Personal");

		Thread.sleep(5000);

		// *[@id="LoginHistory_font"]


//
		WebElement login_history = driver.findElement(By.xpath("//*[@id='LoginHistory_font']/span"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", login_history);

		js.executeScript("window.scrollBy(0,350)", "");
		
		WebElement DisplayLayoutElement = driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
		//waitElement(DisplayLayoutElement);
		
		click(DisplayLayoutElement, "DisplayLayoutElement");
		
		Thread.sleep(2000);
		
		robot.mouseWheel(6);

		WebElement custTabs = driver.findElement(By.xpath("//*[@id='CustomizeTabs_font']"));

		js.executeScript("arguments[0].click();", custTabs);

		//log.info("Customize My Tabs is clicked");
		System.out.println("Customize My Tabs is clicked");


		Thread.sleep(4000);
		WebElement custApp = driver.findElement(By.xpath("//*[@id='p4']"));

		Select selectCustApp = new Select(custApp);

		selectCustApp.selectByVisibleText("Salesforce Chatter");



		WebElement availTabs = driver.findElement(By.xpath("//*[@id='duel_select_0']"));

		Select selectAvailTabs = new Select(availTabs);

		selectAvailTabs.selectByVisibleText("Reports");



		WebElement addToTab = driver.findElement(By.xpath("//*[@id='duel_select_0_right']/img"));

		click(addToTab, "Add to Selected Tabs");



		WebElement saveBtn = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));

		click(saveBtn, "Save Button");

		//log.info("Customized tab settings is saved");
		System.out.println("Customized tab settings is saved");
		

		WebElement rightDropdown = driver.findElement(By.id("tsidButton")); 	

		click(rightDropdown, "Right Drop Down");

		

		WebElement salesforceChatter = driver.findElement(By.xpath("//div[@id='tsid-menuItems']/a[7]"));

		click(salesforceChatter, "Salesforce Chatter");
		
		switchToLightningPopup();

		
		Thread.sleep(5000);
		WebElement reportsTab = driver.findElement(By.xpath("//ul[@id='tabBar']/li[7]"));
		ExplicitWaitElement(reportsTab);
		String expectedElement="Reports";
		Assert.assertEquals(reportsTab.getText(), expectedElement, "Reports tab not present");
		System.out.println("Reports tab present in tab bar");
		
		WebElement userMenu = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenu);
		
		click(userMenu, "UserMenu Dropdown");
		WebElement MyProfile = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]"));
		
		ExplicitWaitElement(MyProfile);
		click(MyProfile, "My Profile");

		Thread.sleep(5000);
		
		WebElement Email = driver.findElement(By.xpath("//div[@id='EmailSetup']"));
		ExplicitWaitElement(Email);
		click(Email, "Email");
		
		WebElement myEmailSettings = driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
		ExplicitWaitElement(myEmailSettings);
		click(myEmailSettings, "My Email Settings");
		
		WebElement emailName = driver.findElement(By.xpath("//input[@id='sender_name']"));
		ExplicitWaitElement(emailName);
		emailName.clear();
		emailName.sendKeys("Rajeeni Sarav");
		
		WebElement emailAddress = driver.findElement(By.xpath("//input[@id='sender_email']"));
		ExplicitWaitElement(emailAddress);
		emailAddress.clear();
		emailAddress.sendKeys("sri.saravanan27@gmail.com");
		
		WebElement bccRadioButton = driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
		ExplicitWaitElement(bccRadioButton);
		click(bccRadioButton, "Bcc RadioButton");
		
		WebElement saveEmailSettings = driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[1]"));
		ExplicitWaitElement(saveEmailSettings);
		click(saveEmailSettings, "Save Email Settings");
		
		String expectedSuccessfulMessage ="Your settings have been successfully saved.";
		WebElement successMessage = driver.findElement(By.xpath("//div[@class='messageText']"));
		ExplicitWaitElement(successMessage);
		Assert.assertEquals(successMessage.getText(), expectedSuccessfulMessage, "Message failed");
		System.out.println("Message matched");
		
		WebElement calendarRemainder = driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
		ExplicitWaitElement(calendarRemainder);
		click(calendarRemainder, "Calendar and Remainder");
		
		WebElement activityRemainders = driver.findElement(By.xpath("//span[@id='Reminders_font']"));
		ExplicitWaitElement(activityRemainders);
		click(activityRemainders, "ActivityRemainders");
		
		WebElement openTestRemainder = driver.findElement(By.xpath("//input[@id='testbtn']"));
		ExplicitWaitElement(openTestRemainder);
		click(openTestRemainder, "Open Test Remainder");
		
		String parent_Id = driver.getWindowHandle();
		Set<String> child_Id = driver.getWindowHandles();
			
		for(String a: child_Id)
		
			//System.out.println(a);
			if(!parent_Id.equals(a)) 
			{
				driver.switchTo().window(a);
				Thread.sleep(5000);
				driver.close();	
			}
			
			driver.switchTo().window(parent_Id);
	}
	
	@Test
	public void case8_DeveloperConsole() throws InterruptedException
	{
		loginSalesforce();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		
		WebElement DeveloperConsole = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[3]"));
		ExplicitWaitElement(DeveloperConsole);
		//String parent_Id = driver.getWindowHandle();
		click(DeveloperConsole, "DeveloperConsole");
		
	
		String parent_Id = driver.getWindowHandle();
		Set<String> child_Id = driver.getWindowHandles();
			
		for(String a: child_Id)
		
			//System.out.println(a);
			if(!parent_Id.equals(a)) 
			{
				driver.switchTo().window(a);
				Thread.sleep(5000);
				driver.close();	
				log.info("Developer console closed");
			}
			
			driver.switchTo().window(parent_Id);
			log.info("Passed: Switched to Previous window");
		}
	
	@Test
	public void case9_LogOutUserMenuDropDOwn() throws InterruptedException
	{
		loginSalesforce();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		WebElement LogoutElement = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
		Thread.sleep(4000);
		
		click(LogoutElement, "LogoutElement");
		
	}
}
