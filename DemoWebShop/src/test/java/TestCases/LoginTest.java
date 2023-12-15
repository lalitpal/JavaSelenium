package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.BaseClass;

@Test
public class LoginTest extends BaseClass{

	public void testLogin() {
		
		HomePage hp = new HomePage(driver);
		hp.clickOnLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.inputEmail(rb.getString("email"));
		lp.inputPassword(rb.getString("password"));
		lp.clickOnLoginBtn();
		
		Assert.assertEquals(lp.checkLogin(), "Log out");
	}
	
	@Test(dependsOnMethods="testLogin")
	public void test_end2end() {
		
		HomePage hp = new HomePage(driver);
		hp.inputOnSearchBar("laptop");
		hp.clickOnSearchBtn();
		
		
		
	}

}
