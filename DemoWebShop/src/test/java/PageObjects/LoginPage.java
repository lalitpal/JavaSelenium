package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='RememberMe']")
	WebElement rememberme;
	
	@FindBy(xpath = "//a[normalize-space()='Forgot password?']")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Log out")
	WebElement confirmLogin;
	
	public void inputEmail(String e_mail) {
		
		email.sendKeys(e_mail);
	}
	
	public void inputPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void checkOnRememberMe() {
		rememberme.clear();
	}
	
	public void clickOnForgotPassword() {
		forgotPassword.click();
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	public String checkLogin() {
		try {
		return confirmLogin.getText();
	}catch(Exception e) {
		return e.getMessage();
	}

}
	}
