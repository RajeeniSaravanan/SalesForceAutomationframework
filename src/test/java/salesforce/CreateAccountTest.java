package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateAccountTest extends SalesForceBaseTest 
{

	@Test
	public void case10_CreateAccount() throws InterruptedException
	{
		loginSalesforce();
		WebElement CreateAccountElement = driver.findElement(By.xpath("//ul[@id='tabBar']/li[5]"));
		Thread.sleep(5000);
		
		click(CreateAccountElement, "Create Account");
		
		WebElement LightningExperiencePopup = driver.findElement(By.xpath("//input[@id='lexNoThanks']"));
		Thread.sleep(3000);
		
		click(LightningExperiencePopup, "Lightning Experience Popup");
		
		WebElement LightningExperiencePopup2 = driver.findElement(By.xpath("//input[@id='lexSubmit']"));
		Thread.sleep(3000);
		
		click(LightningExperiencePopup2, "Lightning Experience Popup");
		

		WebElement NewElement = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		Thread.sleep(3000);
		
		click(NewElement, "New Element");
		
		WebElement AccountName = driver.findElement(By.xpath("//input[@id='acc2']"));
		Thread.sleep(3000);
		
		AccountName.sendKeys("VJ");
		
		WebElement Type = driver.findElement(By.xpath("//select[@id='acc6']"));
		Thread.sleep(3000);
		
		click(Type, "Type");
		
		WebElement TechnologyPartnerElement = driver.findElement(By.xpath("//select[@id='acc6']/option[7]"));
		Thread.sleep(3000);
		
		click(TechnologyPartnerElement, "Technology Partner Element");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		WebElement CustomerPriorityElement = driver.findElement(By.xpath("//select[@id='00NHs00000DsHrp']"));
		Thread.sleep(3000);
		
		click(CustomerPriorityElement, "Customer Priority Element");
		
		WebElement SelectPriority = driver.findElement(By.xpath("//select[@id='00NHs00000DsHrp']/option[2]"));
		Thread.sleep(3000);
		
		click(SelectPriority, "Select Priority");
		
		js.executeScript("window.scrollBy(0,350)", "");
		
		WebElement SaveElement = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		Thread.sleep(3000);
		
		click(SaveElement, "Save Element");	
		
	}
	
	@Test
	public void case11_CreateNewView() throws InterruptedException
	{
		loginSalesforce();
		WebElement CreateAccountElement = driver.findElement(By.xpath("//ul[@id='tabBar']/li[5]"));
		Thread.sleep(5000);
		
		click(CreateAccountElement, "Create Account");
		
		WebElement LightningExperiencePopup = driver.findElement(By.xpath("//input[@id='lexNoThanks']"));
		Thread.sleep(3000);
		
		click(LightningExperiencePopup, "Lightning Experience Popup");
		
		WebElement LightningExperiencePopup2 = driver.findElement(By.xpath("//input[@id='lexSubmit']"));
		Thread.sleep(3000);
		
		click(LightningExperiencePopup2, "Lightning Experience Popup");
		
		WebElement CreateNewView = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		Thread.sleep(3000);
		
		click(CreateNewView, "Create New View");
		
		WebElement ViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		Thread.sleep(3000);
		
		ViewName.sendKeys("abc");
		
		WebElement ViewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		Thread.sleep(3000);
		
		ViewUniqueName.sendKeys("aaa");
		
		WebElement SaveView = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		Thread.sleep(3000);
		
		click(SaveView, "Save View");
			
	}
	
	@Test
	public void case12_EditViewView() throws InterruptedException
	{
		loginSalesforce();
		WebElement CreateAccountElement = driver.findElement(By.xpath("//ul[@id='tabBar']/li[5]"));
		Thread.sleep(5000);
		
		click(CreateAccountElement, "Create Account");
		
		WebElement LightningExperiencePopup = driver.findElement(By.xpath("//input[@id='lexNoThanks']"));
		Thread.sleep(3000);
		
		click(LightningExperiencePopup, "Lightning Experience Popup");
		
		WebElement LightningExperiencePopup2 = driver.findElement(By.xpath("//input[@id='lexSubmit']"));
		Thread.sleep(3000);
		
		click(LightningExperiencePopup2, "Lightning Experience Popup");
		
		WebElement EditElement = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		Thread.sleep(3000);
		
		click(EditElement, "Edit Element");
		
		WebElement ViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		Thread.sleep(3000);
		
		
		ViewName.sendKeys("Ven");
		
		WebElement FieldElement = driver.findElement(By.xpath("//*[@id=\"fcol1\"]"));
		Thread.sleep(3000);
		
		click(FieldElement, "Field Element");
		
		WebElement AccountName = driver.findElement(By.xpath("//*[@id=\"fcol1\"]/option[2]"));
		Thread.sleep(3000);
		
		click(AccountName, "Account Name");
		
		WebElement OperatorElement = driver.findElement(By.xpath("//*[@id=\"fop1\"]"));
		Thread.sleep(3000);
		
		click(OperatorElement, "Operator Element");
		
		WebElement ContainsElement = driver.findElement(By.xpath("//*[@id=\"fop1\"]/option[4]"));
		Thread.sleep(3000);
		
		click(ContainsElement, "Contains Element");
		
		WebElement ValueElement = driver.findElement(By.xpath("//*[@id=\"fval1\"]"));
		Thread.sleep(3000);
		
		//clickButton(ValueElement, "Value Element");
		
		ValueElement.sendKeys("a");
		
		WebElement SaveView = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		Thread.sleep(3000);
		
		click(SaveView, "Save View");
			
	}
	
	@Test
	public void case13_MergeAccounts() throws InterruptedException
	{
		loginSalesforce();
		WebElement CreateAccountElement = driver.findElement(By.xpath("//ul[@id='tabBar']/li[5]"));
		Thread.sleep(5000);
		
		click(CreateAccountElement, "Create Account");
		
		WebElement LightningExperiencePopup = driver.findElement(By.xpath("//*[@id=\"lexNoThanks\"]"));
		Thread.sleep(3000);
		
		click(LightningExperiencePopup, "Lightning Experience Popup");
		
		WebElement LightningExperiencePopup2 = driver.findElement(By.xpath("//*[@id=\"lexSubmit\"]"));
		Thread.sleep(4000);
		
		click(LightningExperiencePopup2, "Lightning Experience Popup2");
		
		WebElement MergeAccountsElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		Thread.sleep(5000);
		
		click(MergeAccountsElement, "Merge Accounts Element");
		

		WebElement SelectAccountElement = driver.findElement(By.xpath("//input[@id='srch']"));
		Thread.sleep(5000);
		
		click(SelectAccountElement, "Select Account Element");
		
		SelectAccountElement.sendKeys("VJ");
		
		WebElement FindAccountsElement = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
		Thread.sleep(5000);
		
		click(FindAccountsElement, "Find Accounts Element");
		
//		WebElement unCheck = driver.findElement(By.xpath("//*[@id=\"cid2\"]"));
//		Thread.sleep(5000);
//		
//		clickButton(unCheck, "unCheck");
		
		WebElement SelectNextElement = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[1]"));
		Thread.sleep(3000);
		
		click(SelectNextElement, "Select Next Element");
		
		WebElement MergeElement = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]"));
		Thread.sleep(3000);
		
		click(MergeElement, "Merge Element");
		
		driver.switchTo().alert().accept();
			
	}
	
	@Test
	public void case14_CreateAccountReport() throws InterruptedException
	{
		
		loginSalesforce();
		WebElement accounts = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));

		//actionElement(accounts);

		click(accounts, "accounts");

		Thread.sleep(2000);

		//Close_SwitchTo_Lightning_PopUp();

		WebElement LightningExperiencePopup = driver.findElement(By.xpath("//*[@id=\"lexNoThanks\"]"));
		Thread.sleep(3000);
		
		click(LightningExperiencePopup, "Lightning Experience Popup");
		
		WebElement LightningExperiencePopup2 = driver.findElement(By.xpath("//*[@id=\"lexSubmit\"]"));
		Thread.sleep(4000);
		
		click(LightningExperiencePopup2, "Lightning Experience Popup2");

		//WebElement click_Report = driver.findElement(By.linkText("Accounts with last activity > 30 days"));

		WebElement click_Report = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		ExplicitWaitElement(click_Report);

		click(click_Report, "Create Report");



		//WebElement from_date = driver.findElement(By.tagName("input")); // .id("ext-gen152")); //clicking on the

																		// calender icon

		WebElement from_date = driver.findElement(By.xpath("//*[@id=\"ext-gen152\"]"));
		ExplicitWaitElement(from_date);

		click(from_date, "From Field");

		//Thread.sleep(2000);

		WebElement select_Fromdate = driver.findElement(By.cssSelector("#ext-gen276")); // .xpath("//button[@id='ext-gen278']"));

		//WebElement select_Fromdate = driver.findElement(By.xpath("/html/body/div[16]/ul/li/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/em/button"));
		//waitElement(select_Fromdate);
		
		Thread.sleep(3000);
		
		click(select_Fromdate, "select_Fromdate");



		//Actions action = new Actions(driver);

		//action.moveToElement(select_Fromdate).build().perform();
		//actionElement(select_Fromdate);


		//JavascriptExecutor js = (JavascriptExecutor) driver;

		//js.executeScript("arguments[0].click();", select_Fromdate);



		WebElement to_date = driver.findElement(By.xpath("//img[@id='ext-gen154']"));

		ExplicitWaitElement(to_date);

		click(to_date, "To Field");

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript(document.getElementByID("ext-gen306").click());
		//WebElement select_Todate = driver.findElement(By.cssSelector("#ext-gen306"));

		WebElement select_Todate = driver.findElement(By.xpath("//button[@id='ext-gen292']"));
		ExplicitWaitElement(select_Todate);

		//Thread.sleep(4000);

		//js.executeScript("arguments[0].click();",select_Todate );

		click(select_Todate, "Today's Date in To field");
		
		WebElement save = driver.findElement(By.xpath("//button[@id='ext-gen49']"));

		ExplicitWaitElement(save);

		click(save, "save ");
		
		WebElement Report = driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));

		ExplicitWaitElement(Report);
	
		Report.sendKeys("Monthly Report");
	
		WebElement UniqueReport = driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));

		ExplicitWaitElement(UniqueReport);
		UniqueReport.clear();
		Thread.sleep(2000);
		UniqueReport.sendKeys("July");
		
		WebElement saveRunReport = driver.findElement(By.cssSelector("#ext-gen312"));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",saveRunReport);
		
	}
	
}
