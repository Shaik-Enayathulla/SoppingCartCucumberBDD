package stepDefinations;

import org.junit.Assert;
import factory.Baseclass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilites.dataReaderUtil;

public class LoginTest {
	
	HomePage hp;
	LoginPage lp;
	MyAccountPage myp;
	List<HashMap<String, String>> datamap;

	@Given("the user navigates to login page")
	public void navigates_to_login_page() {
		Baseclass.getlogger().info("Goto my account-->Click on Login.. ");
    	hp=new HomePage(Baseclass.getDriver());
	    hp.clickdrpMyaccount();
	    hp.clickLogin();
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String user, String psd) {
		Baseclass.getlogger().info("Login page action");
		lp=new LoginPage(Baseclass.getDriver());
	    lp.setEmail(user);
	    lp.setPassword(psd);
	}

	@When("the user clicks on the Login button")
	public void login_button() {
		Baseclass.getlogger().info("Click login button action");
		lp.clickbtnLogin();
	}

	/*@Then("the user should be redirected to the MyAccount Page")
	public void my_account_page() {
		//Baseclass.getlogger().info("********My Account Page validation");
		myp=new MyAccountPage(Baseclass.getDriver());
	    boolean targetpage =  myp.ValitationofAccount();
	    Assert.assertEquals(targetpage, true);
	}	*/
	
	@Then("user should successfull loged in with excel data {string}")
	public void Input_excel_data(String rows) {
		datamap=dataReaderUtil.Data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");
	        int index=Integer.parseInt(rows)-1;
	        String email= datamap.get(index).get("username");
	        String pwd= datamap.get(index).get("password");
	        String exp_res= datamap.get(index).get("result");

	        lp=new LoginPage(Baseclass.getDriver());
	        lp.setEmail(email);
	        lp.setPassword(pwd);

	        lp.clickbtnLogin();
	        myp=new MyAccountPage(Baseclass.getDriver());
	        try
	        {
	            boolean targetpage=myp.ValitationofAccount();
	            System.out.println("target page: "+ targetpage);
	            if(exp_res.equals("Valid"))
	            {
	                if(targetpage==true)
	                {
	                    MyAccountPage myaccpage=new MyAccountPage(Baseclass.getDriver());
	                    myaccpage.clickLogout();
	                    Assert.assertTrue(true);
	                }
	                else
	                {
	                    Assert.assertTrue(false);
	                }
	            }

	            if(exp_res.equals("Invalid"))
	            {
	                if(targetpage==true)
	                {
	                    myp.clickLogout();
	                    Assert.assertTrue(false);
	                }
	                else
	                {
	                    Assert.assertTrue(true);
	                }
	            }


	        }
	        catch(Exception e)
	        {

	            System.out.println("Occured Exception meassag"+e.getMessage());
	        }
	   }
}