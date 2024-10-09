package stepDefinations;

import java.util.Map;

import factory.Baseclass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

@SuppressWarnings("deprecation")
public class Registration_Test002 {
	
	//WebDriver driver;
    HomePage hp;
    RegistrationPage rp;
    
	@Given("Navigatio to Registration page")
	public void navigation() {
	    
	    hp = new HomePage(Baseclass.getDriver());
	    hp.clickdrpMyaccount();
	    hp.clickRegister();
	}

	@When("User need to fill all the mandatory filed with below values")
	public void Action(DataTable dataTable) throws InterruptedException {
	  Map<String,String> datamap = dataTable.asMap(String.class,String.class);
	  rp = new RegistrationPage(Baseclass.getDriver());
	  rp.setFirstName(datamap.get("firstName"));
	  rp.setLastName(datamap.get("lastName"));
	  rp.setEmail(Baseclass.randomalphanumaric()+"@gmail.com");
	  rp.setTelephone(datamap.get("telephone"));
	  rp.setPassword(datamap.get("password"));
	  rp.setConfirmPassword(datamap.get("password"));
	}

	@When("user should enable privacy policy")
	public void Enable_Privacy() {
	    rp.setPrivacyPolicy();
	}

	@When("user should click on continue button")
	public void continue_button() throws InterruptedException {
	   rp.clickContinue();
	}

	@Then("user account should get created successfully")
	public void user_created_successfully() {
	 String cnf_msg = rp.getConfirmationMsg();
	 String act_msg="Your Account Has Been Created!";
	 Assert.assertEquals(act_msg,cnf_msg);
	 
	}


}
