package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement maleRb;
	
	@FindBy(xpath =  "//input[@id='gender-female']")
	WebElement femaleRb;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement fname;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lname;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement confirmPass;
	
	@FindBy(xpath = "//input[@id='register-button']")
	WebElement registerBtn;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement regConfirm;
	
	public void clickOnMaleRb() {
		maleRb.click();
	}
	
	public void clickOnFemaleRb() {
		femaleRb.click();
	}
	
	public void inputFirstName() {
		fname.click();
	}
	
	public void inputLastName() {
		lname.click();
	}
	
	public void inputEmail() {
		email.click();
	}
	
	public void inputPassword() {
		password.click();
	}
	
	public void inputConfirmPass() {
		confirmPass.click();
	}
	
	public void clickOnRegisterBtn() {
		registerBtn.click();
	}
	
	public String getConfirmmsg() {
		return regConfirm.getText();
	}
	
	
	

}
