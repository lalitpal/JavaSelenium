package TestCases;

import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import TestBase.BaseClass;

public class TestRegistration extends BaseClass{
	
	public void testRegistration() {
		
		HomePage hp = new HomePage(driver);
		hp.clickOnRegister();
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.clickOnMaleRb();
		rp.inputFirstName();
		rp.inputLastName();
		rp.inputEmail();
		rp.inputPassword();
		rp.inputConfirmPass();
		rp.clickOnRegisterBtn();
		Assert.assertEquals(rp.getConfirmmsg(),  "Your registration completed");
		
		
	}

}
