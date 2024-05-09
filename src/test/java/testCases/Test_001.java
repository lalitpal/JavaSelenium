package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.RegistrationPage;
import pageObjects.ShopPage;
import testComponents.BaseTest;

public class Test_001 extends BaseTest {

	@Test
	public void testRegistration() throws IOException {

		System.out.println("Test Start");
		RegistrationPage register = new RegistrationPage(driver);

		register.inputName("lucky");
		register.inputEmail("xyz@gmail.com");
		register.inputPassword("123456");
		register.clickOnCheckme();
		register.clickOnStudentRB();
		register.inputGender("Male");
		register.inputBirthDate("01012000");
		register.ClickOnSubmit();

		// Success! The Form has been submitted successfully!.
		AssertJUnit.assertTrue(register.confirmMsg().contains("Success! The Form has been submitted successfully!."));
		System.out.println(register.confirmMsg());
		getScreenshot("testRegistration");

	}

	@Test(dependsOnMethods= {"testRegistration"})
	public void testAddItems() throws IOException, InterruptedException {

		String[] itemsNeeded = { "iphone X", "Nokia Edge", "Blackberry" };
		ShopPage shop = new ShopPage(driver);
		shop.clickOnShop();
		shop.addProductToCart(itemsNeeded);
		shop.clickOnCheckout();

		CartPage cart = new CartPage(driver);

		boolean pass = cart.productInsideCart(itemsNeeded);
		Assert.assertEquals(pass, false);

		cart.clickOnCheckout();

		CheckOutPage checkout = new CheckOutPage(driver);
		checkout.selectCountry("ind");
		checkout.clickOnCheckbox();
		checkout.clickOnPurchase();

		// Thank you! Your order will be delivered in next few weeks :-).
		AssertJUnit.assertTrue(checkout.confirmMsg().contains("Success!"));
		Assert.assertEquals("Thank you! Your order will be delivered in next few weeks :-", checkout.confirmMsg());
		System.out.println(checkout.confirmMsg());
		getScreenshot("e2e");

	}
	
	public void brokenLinks() {
		
	}

}
