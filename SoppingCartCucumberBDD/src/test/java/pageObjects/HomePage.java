package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement drpMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement optRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement optLogin;
	
	public void clickdrpMyaccount()
	{
		drpMyaccount.click();
	}
	
	public void clickRegister()
	{
		optRegister.click();
	}
	
	public void clickLogin()
	{
		optLogin.click();
	}//input[@value='Login']
}
