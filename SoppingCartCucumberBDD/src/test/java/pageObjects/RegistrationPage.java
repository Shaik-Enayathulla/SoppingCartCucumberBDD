package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phnnum;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpasswrd;
	

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfpasswrd;
	

	@FindBy(xpath="//input[@name='agree']")
	WebElement chkbox;
	

	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) throws InterruptedException {
		Thread.sleep(3);
		txtLastName.sendKeys(lname);

	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);

	}

	public void setTelephone(String tel) throws InterruptedException {
		Thread.sleep(3);
		phnnum.sendKeys(tel);

	}

	public void setPassword(String pwd) {
		txtpasswrd.sendKeys(pwd);

	}

	public void setConfirmPassword(String pwd) {
		 txtconfpasswrd.sendKeys(pwd);

	}

	public void setPrivacyPolicy() {
		chkbox.click();

	}

	public void clickContinue() throws InterruptedException {
		Thread.sleep(3);
		//sol1 
		btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}

	
}
