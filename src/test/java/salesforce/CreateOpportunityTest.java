package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOpportunityTest extends SalesForceBaseTest 
{

	@Test
	public void case15_OpportunitiesDropDown() throws InterruptedException
	{
		loginSalesforce();
		WebElement Opportunities = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));

		ExplicitWaitElement(Opportunities);

		click(Opportunities, "Opportunities");
		
		Thread.sleep(2000);
		switchToLightningPopup();
//		
//		WebElement OpportunitiesDropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
//
//		waitElement(OpportunitiesDropDown);
//
//		clickButton(OpportunitiesDropDown, "Opportunities DropDown");
		
		WebElement OpportunitiesDropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
		//waitElement(userMenuDropdown);
		
		actionElement(OpportunitiesDropDown);
		
		click(OpportunitiesDropDown, "Opportunities DropDown");
		
		String viewDropdownExpectedItems[] = {"All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private","Recently Viewed Opportunities", "Won"};
		
		WebElement viewDropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
		
		String[] viewDropdownItems = viewDropdown.getText().split("\n");
		
		for(int i=0; i<viewDropdownExpectedItems.length; i++)
		{
			Assert.assertEquals(viewDropdownItems[i], viewDropdownExpectedItems[i]);
		}	
	}
	
	@Test
	public void case16_CreateNewOpty() throws InterruptedException
	{
		loginSalesforce();
		WebElement Opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));

		ExplicitWaitElement(Opportunities);

		click(Opportunities, "Opportunities");
		
		Thread.sleep(3000);
		
		switchToLightningPopup();
		
		WebElement NewOpportunities = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));

		ExplicitWaitElement(NewOpportunities);

		click(NewOpportunities, "New Opportunities");
		Thread.sleep(3000);
		
		WebElement OpportunitiesName = driver.findElement(By.id("opp3"));
		ExplicitWaitElement(OpportunitiesName);
		OpportunitiesName.sendKeys("All opportunities");
		
		WebElement AccountName = driver.findElement(By.id("opp4"));
		ExplicitWaitElement(AccountName);
		AccountName.sendKeys("VJ");
		
		WebElement stage = driver.findElement(By.id("opp11"));
		ExplicitWaitElement(stage);
		click(stage, "stage");
		
		WebElement stageUserdropdown = driver.findElement(By.xpath("//select[@id='opp11']/option[3]"));
		ExplicitWaitElement(stageUserdropdown);
		click(stageUserdropdown, "stageUserdropdown");
		
		WebElement Probability = driver.findElement(By.id("opp12"));
		ExplicitWaitElement(Probability);
		Probability.clear();
		//clickButton(Probability, "Probability");
		Probability.sendKeys("50");
		
		WebElement LeadSource = driver.findElement(By.id("opp6"));
		ExplicitWaitElement(LeadSource);
		click(LeadSource, "LeadSource");
		
		WebElement leadSourceUserdropdown = driver.findElement(By.xpath("//select[@id='opp6']/option[2]"));
		ExplicitWaitElement(leadSourceUserdropdown);
		click(leadSourceUserdropdown, "leadSourceUserdropdown");
		
		WebElement PrimaryCampaignsource = driver.findElement(By.id("opp17"));
		ExplicitWaitElement(PrimaryCampaignsource);
		click(PrimaryCampaignsource, "PrimaryCampaignsource");
		
		PrimaryCampaignsource.sendKeys("DM Campaign to Top Customers");
		
		WebElement closeDate = driver.findElement(By.id("opp9"));
		ExplicitWaitElement(closeDate);
		click(closeDate, "closeDate");
		
		WebElement selectDate = driver.findElement(By.xpath("//*[@id=\"datePicker\"]/div[2]/div/a"));
		ExplicitWaitElement(selectDate);
		actionElement(selectDate);
		//clickButton(selectDate, "selectDate");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectDate);
		
		WebElement saveOpportunity = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		ExplicitWaitElement(saveOpportunity);
		click(saveOpportunity, "saveOpportunity");	
		
		String expectedTitle="Opportunity: All opportunities ~ Salesforce - Developer Edition";
		assertPageTitle(expectedTitle);
		
	}
	
	@Test
	public void case17_TestOpportunityFileReport() throws InterruptedException
	{
	
		loginSalesforce();
		WebElement Opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));

		ExplicitWaitElement(Opportunities);

		click(Opportunities, "Opportunities");
		Thread.sleep(2000);
		switchToLightningPopup();
		
		WebElement OpportunityPipeline = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));

		ExplicitWaitElement(OpportunityPipeline);

		click(OpportunityPipeline, "OpportunityPipeline");	
		
		String expectedTitle = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		assertPageTitle(expectedTitle);
	}
	
	@Test
	public void case18_TestStuckOpportunityReport() throws InterruptedException
	{
		loginSalesforce();
		WebElement Opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));

		ExplicitWaitElement(Opportunities);

		click(Opportunities, "Opportunities");
		Thread.sleep(2000);
		switchToLightningPopup();
		
		WebElement stuckOpportunities = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));

		ExplicitWaitElement(stuckOpportunities);

		click(stuckOpportunities, "stuckOpportunities");
		
		String expectedTitle = "Stuck Opportunities ~ Salesforce - Developer Edition";
		assertPageTitle(expectedTitle);
	}
	
	@Test
	public void case19_TestQuarterlySummaryReport() throws InterruptedException
	{
	
		loginSalesforce();
		WebElement Opportunities = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));

		ExplicitWaitElement(Opportunities);

		click(Opportunities, "Opportunities");
		Thread.sleep(2000);
		switchToLightningPopup();
		
		WebElement Interval = driver.findElement(By.id("quarter_q"));
		ExplicitWaitElement(Interval);
		click(Interval, "Interval");
		
		WebElement selectInterval = driver.findElement(By.xpath("//select[@id=\"quarter_q\"]/option[3]"));
		ExplicitWaitElement(selectInterval);
		click(selectInterval, "selectInterval");
		
		WebElement Include = driver.findElement(By.id("open"));
		ExplicitWaitElement(Include);
		click(Include, "Include");
		
		WebElement selectIncludeOpportunities = driver.findElement(By.xpath("//select[@id=\"open\"]/option[2]"));
		ExplicitWaitElement(selectIncludeOpportunities);
		click(selectIncludeOpportunities, "selectIncludeOpportunities");
		
		WebElement RunReport = driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
		ExplicitWaitElement(RunReport);
		click(RunReport, "RunReport");
		
		String expectedTitle = "Opportunity Report ~ Salesforce - Developer Edition";
		assertPageTitle(expectedTitle);
		
	}
}
