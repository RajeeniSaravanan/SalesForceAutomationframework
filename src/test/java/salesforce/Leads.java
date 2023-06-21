package salesforce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Leads extends SalesForceBaseTest
{
	@Test
	public void case20_LeadsTab() throws InterruptedException
	{
		loginSalesforce();
		WebElement leads = driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
		ExplicitWaitElement(leads);
		click(leads, "leads");
		Thread.sleep(3000);
		
		switchToLightningPopup();
		
		String expectedTitle = "Leads: Home ~ Salesforce - Developer Edition";
		assertPageTitle(expectedTitle);	
		
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		
		WebElement LogoutElement = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
		Thread.sleep(5000);
		
		click(LogoutElement, "LogoutElement");
	}
	
	@Test
	public void case21_LeadsSelectView() throws InterruptedException
	{
		loginSalesforce();
		WebElement leads = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		ExplicitWaitElement(leads);
		click(leads, "leads");
		Thread.sleep(3000);
		
		switchToLightningPopup();
		

		WebElement leadsDropdownList = driver.findElement(By.id("fcf"));
		ExplicitWaitElement(leadsDropdownList);
		click(leadsDropdownList, "leadsDropdownList");
	
		String leadsDropdownList1[] = {"All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads", "View - Custom 1","View - Custom 2"};
		
		WebElement leadsDropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		String[] leadsDropdownitems = leadsDropdown.getText().split("\n");
		
		for(int i=0; i< leadsDropdownList1.length;i++)
		{
			Assert.assertEquals(leadsDropdownitems[i], leadsDropdownList1[i]);
			log.info("Leads dropdown list matched");
		}
		
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		
		WebElement LogoutElement = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
		Thread.sleep(5000);
		
		click(LogoutElement, "LogoutElement");
	}
	
	@Test
	public void case22_DefaultView() throws InterruptedException
	{
		loginSalesforce();
		WebElement leads = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		ExplicitWaitElement(leads);
		click(leads, "leads");
		Thread.sleep(3000);
		
		switchToLightningPopup();
		
		WebElement leadsDropdownList = driver.findElement(By.id("fcf"));
		ExplicitWaitElement(leadsDropdownList);
		click(leadsDropdownList, "leadsDropdownList");
		
		WebElement TodaysLeads = driver.findElement(By.xpath("//select[@id='fcf']/option[4]"));
		ExplicitWaitElement(TodaysLeads);
		click(TodaysLeads, "TodaysLeads");
		Thread.sleep(3000);
		
		WebElement myUnreadLeads = driver.findElement(By.id("hotlist_mode"));
		ExplicitWaitElement(myUnreadLeads);
		
		actionElement(myUnreadLeads);
		click(myUnreadLeads, "myUnreadLeads");
		
		WebElement leadsDropdown = driver.findElement(By.id("hotlist_mode"));
		ExplicitWaitElement(leadsDropdown);
		click(leadsDropdown, "leadsDropdown");
	
		WebElement leadsDropdownlist = driver.findElement(By.xpath("//select[@id='hotlist_mode']/option[2]"));
		ExplicitWaitElement(leadsDropdownlist);
		click(leadsDropdownlist, "leadsDropdownlist");
		
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		
		WebElement LogoutElement = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
		Thread.sleep(5000);
		
		click(LogoutElement, "LogoutElement");
		Thread.sleep(3000);
		loginSalesforce();
		
		WebElement leads2 = driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
		ExplicitWaitElement(leads2);
		click(leads2, "leads2");
		//Thread.sleep(4000);
		
		//switchToLightningPopup();
		
		WebElement goElement = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		ExplicitWaitElement(goElement);
		click(goElement, "goElement");
		
		WebElement userMenuDropdown1 = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown1);
		
		click(userMenuDropdown1, "UserMenu Dropdown");
		
		WebElement LogoutElement1 = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
		Thread.sleep(5000);
		
		click(LogoutElement1, "LogoutElement");
	}
	
	@Test
	public void case23_TodaysLeads() throws InterruptedException
	{
		loginSalesforce();
		WebElement leads = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		ExplicitWaitElement(leads);
		click(leads, "leads");
		Thread.sleep(3000);
		
		switchToLightningPopup();
		
		WebElement leadsDropdownList = driver.findElement(By.id("fcf"));
		ExplicitWaitElement(leadsDropdownList);
		click(leadsDropdownList, "leadsDropdownList");
		
		WebElement TodaysLeads = driver.findElement(By.xpath("//select[@id='fcf']/option[4]"));
		ExplicitWaitElement(TodaysLeads);
		click(TodaysLeads, "TodaysLeads");
		Thread.sleep(3000);
		
		WebElement goElement = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		ExplicitWaitElement(goElement);
		click(goElement, "goElement");
		
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		
		WebElement LogoutElement = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
		Thread.sleep(5000);
		
		click(LogoutElement, "LogoutElement");
	
	}
	
	@Test
	public void case24_CheckNewButtonOnLeadsPage() throws InterruptedException
	{
		loginSalesforce();
		WebElement leads = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		ExplicitWaitElement(leads);
		click(leads, "leads");
		Thread.sleep(3000);
		
		switchToLightningPopup();
		
		WebElement newElement = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		ExplicitWaitElement(newElement);
		click(newElement, "newElement");
		
		WebElement lastName = driver.findElement(By.id("name_lastlea2"));
		ExplicitWaitElement(lastName);
		click(lastName, "lastName");
		
		lastName.sendKeys("ABCD");
		Thread.sleep(2000);
		
		WebElement company = driver.findElement(By.id("lea3"));
		ExplicitWaitElement(company);
		click(company, "company");
		
		company.sendKeys("ABCD");
		Thread.sleep(2000);
		
		String expectedTitle = "Lead Edit: New Lead ~ Salesforce - Developer Edition";
		assertPageTitle(expectedTitle);
		
		WebElement saveElement = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		ExplicitWaitElement(saveElement);
		click(saveElement, "saveElement");
		
		WebElement userMenuDropdown = driver.findElement(By.xpath("//span[@id= 'userNavLabel']"));
		//waitElement(userMenuDropdown);
		
		actionElement(userMenuDropdown);
		
		click(userMenuDropdown, "UserMenu Dropdown");
		
		WebElement LogoutElement = driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
		Thread.sleep(5000);
		
		click(LogoutElement, "LogoutElement");
	}
	
}
