package salesforce;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class ContactsTest extends SalesForceBaseTest 
{

	//Test25 Passed
	@Test
	public void case25_CreateNewContact() throws InterruptedException 
	{
		loginSalesforce();
		
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		click(contactTab, "Contacts Tab");

		Thread.sleep(3000);
		switchToLightningPopup();

		WebElement newBtn = driver.findElement(By.name("new"));
		click(newBtn, "New Contact");

		WebElement contactLastName = driver.findElement(By.id("name_lastcon2"));
		enterText(contactLastName, "Sara", "lastName");
		WebElement accountName = driver.findElement(By.id("con4"));
		enterText(accountName, "VJ", "AccountName");

		WebElement saveBtn = driver.findElement(By.name("save"));
		click(saveBtn, "Save Button");

		Thread.sleep(3000);
		WebElement contactName = driver.findElement(By.xpath("//div[@id='contactHeaderRow']/div/h2"));
		String topName = contactName.getText();
		String actualTitle1 = "Contact: " + topName + " ~ Salesforce - Developer Edition";

		assertPageTitle(actualTitle1);
		log.info("New Contact is created");
		//report.logTestInfo("New contact is created and displayed with details");		
	}
	
	//Test26 failed
	@Test
	public void case26_CreateNewViewInContactPage() throws InterruptedException 
	{
		loginSalesforce();
		
		WebElement contactTab = driver.findElement(By.xpath("//div[@id='tabContainer']/nav/ul/li[@id='Contact_Tab']"));
		click(contactTab, "Contact Tab");

		Thread.sleep(4000);
		switchToLightningPopup();

		WebElement createNewView = driver.findElement(By.xpath("//div[@class='bFilterView']/span/span[2]/a[2]"));
		click(createNewView, "Create New View");
		
		WebElement viewName = driver.findElement(By.id("fname"));
		enterText(viewName, "sarav", "ViewName");
		
		WebElement viewUniqName = driver.findElement(By.id("devname"));
		enterText(viewUniqName, "chand", "View Unique Name");

		WebElement saveBtn = driver.findElement(By.name("save"));
		click(saveBtn, "Save Button");

		Thread.sleep(4000);
		WebElement contactView = driver.findElement(By.xpath("//*[@id=\"00BHs00000BubLN_listSelect\"]"));
		Select selView = new Select(contactView);

		String expectedtedView = selView.getFirstSelectedOption().getText();
		String actualView = "TestView1";
		Assert.assertEquals(actualView, expectedtedView);

		log.info("Created view is selected by default");

		//report.logTestInfo("Created view is selected by default");
		
	}
	
	//Test27 passed
	@Test
	public void case27_RecentlyCreatedContactInContactPage() throws InterruptedException
	{
		
		loginSalesforce();
		
		WebElement contactTab = driver.findElement(By.xpath("//div[@id='tabContainer']/nav/ul/li[@id='Contact_Tab']"));
		click(contactTab, "Contact Tab");

		Thread.sleep(4000);
		switchToLightningPopup();

		WebElement recentContact = driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)"));
		
		String expectedtedView = recentContact.getText();

		String actualView = "SS";
		Assert.assertEquals(actualView, expectedtedView);

		log.info("Recent Contact is displayed under Recent Contacts");

		//report.logTestInfo("Recent Contact is displayed under Recent Contacts");
	}
	
	//Testcase 28 passed
	@Test
	public void case28_CheckMyContactsInContactPage() throws InterruptedException
	{
		loginSalesforce();
		
		WebElement contactTab = driver.findElement(By.xpath("//div[@id='tabContainer']/nav/ul/li[@id='Contact_Tab']"));
		click(contactTab, "Contact Tab");

		Thread.sleep(4000);
		switchToLightningPopup();

		Thread.sleep(3000);
		WebElement contactView = driver.findElement(By.id("fcf"));

		Select selView = new Select(contactView);
		selView.selectByVisibleText("My Contacts");

		WebElement goBtn = driver.findElement(By.name("go"));
		click(goBtn, "Go Button");

		String actualView = "Contacts ~ Salesforce - Developer Edition";
		assertPageTitle(actualView);

		log.info("My Contacts view is displayed.");

		//report.logTestInfo("My Contacts view is displayed.");	
	}
	
	//Test29 passed
	@Test
	public void case29_CheckMyContactsInContactPage() throws InterruptedException
	{
		
		loginSalesforce();
		
		WebElement contactTab = driver.findElement(By.xpath("//div[@id='tabContainer']/nav/ul/li[@id='Contact_Tab']"));
		click(contactTab, "Contact Tab");

		Thread.sleep(4000);
		switchToLightningPopup();

		WebElement recentContact = driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)"));
		click(recentContact, "Recent Contact");

		WebElement contactDetails = driver.findElement(By.xpath("//h2[contains(text(),'Contact Detail')]"));
		Thread.sleep(3000);

		String expectedText = contactDetails.getText();
		String actualText = "Contact Detail";

		Assert.assertEquals(actualText, expectedText);

		log.info("Selected Contact is displayed with details");

		//report.logTestInfo("Selected Contact is displayed with details");	
	}
	
	//Test30 passed
	@Test
	public void case30_CheckErrorMessageInContactPage() throws InterruptedException
	{
		loginSalesforce();
		
		WebElement contactTab = driver.findElement(By.xpath("//div[@id='tabContainer']/nav/ul/li[@id='Contact_Tab']"));
		click(contactTab, "Contact Tab");

		Thread.sleep(4000);
		switchToLightningPopup();

		WebElement createNewView = driver.findElement(By.xpath("//div[@class='bFilterView']/span/span[2]/a[2]"));
		click(createNewView, "Create New View");

		WebElement viewUniqName = driver.findElement(By.id("devname"));
		enterText(viewUniqName, "TestView1", "View unique name");

		WebElement saveBtn = driver.findElement(By.name("save"));
		click(saveBtn, "Save Button");

		WebElement errorMsg = driver.findElement(By.xpath("//div[@class='errorMsg']"));
		String expectedErrMessage = errorMsg.getText();
		String actualErrMessage = "Error: You must enter a value";

		Assert.assertEquals(actualErrMessage, expectedErrMessage);

		log.info("Error Message is displayed");

		//report.logTestInfo("Error Message is displayed");
	}
	
	//Test31 passed
	@Test
	public void case31_CheckCancelButtonInCreateNewView() throws InterruptedException
	{
		loginSalesforce();
		
		WebElement contactTab = driver.findElement(By.xpath("//div[@id='tabContainer']/nav/ul/li[@id='Contact_Tab']"));
		click(contactTab, "Contact Tab");

		Thread.sleep(4000);
		switchToLightningPopup();

		WebElement createNewView = driver.findElement(By.xpath("//div[@class='bFilterView']/span/span[2]/a[2]"));
		click(createNewView, "Create New View");

		WebElement viewName = driver.findElement(By.id("fname"));
		enterText(viewName, "View Name", "ABCD");

		WebElement viewUniqName = driver.findElement(By.id("devname"));
		enterText(viewUniqName, "View Unique Name", "EFGH");

		WebElement cancelBtn = driver.findElement(By.name("cancel"));
		click(cancelBtn, "Cancel Button");

		WebElement contactView = driver.findElement(By.name("fcf"));
		Select selView = new Select(contactView);
		String expectedtedView = selView.getFirstSelectedOption().getText();
		String actualView = "ABCD";

		Assert.assertNotEquals(actualView, expectedtedView, "Cancel Button works good, view not created");
		log.info("Cancel button works fine, view not created");

		//report.logTestInfo("Cancel button works fine, view not created");
	}
	
	//Test32 passed
	@Test
	public void case32_saveAndNewButtonInNewContactpage() throws InterruptedException
	{
		loginSalesforce();
		
		WebElement contactTab = driver.findElement(By.xpath("//div[@id='tabContainer']/nav/ul/li[@id='Contact_Tab']"));
		click(contactTab, "Contacts Tab");

		Thread.sleep(4000);
		switchToLightningPopup();

		WebElement newBtn = driver.findElement(By.name("new"));
		click(newBtn, "New Contact");
		
		WebElement contactFirstName = driver.findElement(By.id("name_firstcon2"));
		enterText(contactFirstName, "ABC", "First Name");
		
		WebElement contactLastName = driver.findElement(By.id("name_lastcon2"));
		enterText(contactLastName, "Chandru", "Last Name");
		
		WebElement accountName = driver.findElement(By.id("con4"));
		enterText(accountName, "Ramco sys", "Account Name");
		
		WebElement saveNewBtn = driver.findElement(By.name("save_new"));
		click(saveNewBtn, "Save & New Button");

		String actualTitle = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		assertPageTitle(actualTitle);
		
		log.info("Contact Edit: New Contact page is displayed");

		//report.logTestInfo("Contact Edit: New Contact page is displayed");
	}
	
	
}
