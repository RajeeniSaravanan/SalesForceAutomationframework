package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.ListenersTest.class)

public class LoginTest extends SalesForceBaseTest
{
	@Test
	public void case1_LoginErrorMessage() throws InterruptedException
	{	
		log.info("case1_LoginErrorMessage Started"); 
		
		userId=appProp.getProperty("login.valid.userid");
		
		WebElement userNameElement = driver.findElement(By.id("username"));
		enterText(userNameElement,userId,"username");

		WebElement loginButtonElement = driver.findElement(By.name("Login"));
		
		ExplicitWaitElement(loginButtonElement);
		
		click(loginButtonElement, "login Button");
		
		assertElementTextById("error", "Please enter your password.");	
	}
	
	

	@Test
	public void case2_Successful_LoginToSalesForce() throws InterruptedException
	{
		log.info("case2_Successful_LoginToSalesForce Started");
		
		loginSalesforce();
		
		String homeExpectedTitle = "Home Page ~ Salesforce - Developer Edition";
		assertPageTitle (homeExpectedTitle);	
			
	}


	@Test
	public void case3_CheckRememberMe() throws InterruptedException
	{
		log.info("case3_CheckRememberMe Started");
		
		userId = appProp.getProperty("login.valid.userid");
		password = appProp.getProperty("login.valid.password");

		Thread.sleep(3000);
		WebElement userName_Field = driver.findElement(By.id("username"));
		ExplicitWaitElement(userName_Field);
		enterText(userName_Field,userId,"username");
		
		Thread.sleep(4000);
		
		WebElement password_Field = driver.findElement(By.id("password"));
		ExplicitWaitElement(password_Field);
		enterText(password_Field,password,"Password");
		
		Thread.sleep(4000);
		
		WebElement checkBox = driver.findElement(By.id("rememberUn"));
		ExplicitWaitElement(checkBox);
		checkBox.click();
		log.info("Remember me checkbox is clicked");
		
		Thread.sleep(2000);
		
		WebElement loginButton = driver.findElement(By.name("Login"));
		ExplicitWaitElement(loginButton);
		click(loginButton, "Login Button");
		
		Thread.sleep(3000);
		
		String expectedTitle="Home Page ~ Salesforce - Developer Edition";
		assertPageTitle(expectedTitle);
		
		WebElement myAccount = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		ExplicitWaitElement(myAccount);
		
		Thread.sleep(4000);
		actionElement(myAccount);
		Thread.sleep(4000);
		click(myAccount, "Select my account name");
		Thread.sleep(4000);
		
		WebElement LogOut = driver.findElement(By.xpath("//div[@id=\"userNav-menuItems\"]/a[5]"));
		ExplicitWaitElement(LogOut);
		click(LogOut, "LogOut");
	
		Thread.sleep(2000);
		
		WebElement actualUserName = driver.findElement(By.id("idcard"));
		ExplicitWaitElement(actualUserName);
		
		log.info("username field found with entered username");
		
		String expectedUserName =appProp.getProperty("login.valid.userid");
		Assert.assertEquals(actualUserName.getText(), expectedUserName,"Not matched");
		log.info("Matched");
			
	}
	
	@Test
	public void case4A_ForgotPassword() throws InterruptedException
	{
		log.info("case4A_ForgotPassword Started");
		
		WebElement forgotPassword = driver.findElement(By.id("forgot_password_link"));
		ExplicitWaitElement(forgotPassword);
		click(forgotPassword, "Forgot Password");
		
		WebElement username_field = driver.findElement(By.id("un"));
		ExplicitWaitElement(username_field);
		
		userId = appProp.getProperty("login.valid.userid");
		enterText(username_field,userId,"username");
		
		WebElement continueButton = driver.findElement(By.id("continue"));
		ExplicitWaitElement(continueButton);
		click(continueButton, "Continue Button");
		
		Thread.sleep(5000);
		WebElement forgotPwdConfirmation = driver.findElement(By.xpath("//div[@id='forgotPassForm']"));
		ExplicitWaitElement(forgotPwdConfirmation);
		
		if(forgotPwdConfirmation != null)
			
			log.info("Passed: Forgot password confirmation message displayed");
		else
			log.info("Failed: Forgot password confirmation message not displayed");
		
	}
	
	@Test
	public void case4B_ForgotPassword() throws InterruptedException
	{
		
		log.info("case4B_ForgotPassword Started");
		
		userId = appProp.getProperty("login.invalid.userid");
		password = appProp.getProperty("login.invalid.password");

		WebElement userName_Field = driver.findElement(By.id("username"));
		
		enterText(userName_Field,userId,"username");
		
		Thread.sleep(2000);
		
		WebElement password_Field = driver.findElement(By.id("password"));
		
		ExplicitWaitElement(password_Field);
		enterText(password_Field,password,"Password");
		
		WebElement login = driver.findElement(By.name("Login"));
		
		ExplicitWaitElement(login);

		click(login, "Login Button");
		
		String homeExpectedTitle = "Login | Salesforce";
		assertPageTitle (homeExpectedTitle);	

		String errorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		assertElementTextById("error", errorMsg);
	}
	
}
	
