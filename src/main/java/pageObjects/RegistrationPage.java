package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name= "name")
	WebElement name;
	
	@FindBy(xpath= "//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath= "//input[@id='exampleInputPassword1']")
	WebElement password;
	
	@FindBy(css= "#exampleCheck1")
	WebElement checkMe;
	
	@FindBy(xpath= "//select[@id='exampleFormControlSelect1']")
	WebElement genderDropdown;
	
	@FindBy(xpath= "//input[@id='inlineRadio1']")
	WebElement studentRB;
	
	@FindBy(xpath= "//input[@id='inlineRadio2']")
	WebElement employedRB;
	
	@FindBy(xpath= "//input[@name='bday']")
	WebElement bday;
	
	@FindBy(xpath= "//input[@value='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath= "//input[@class='ng-untouched ng-pristine ng-valid']")
	WebElement dataBinding;
	
	@FindBy(css = ".alert-success")
	WebElement successMsg;

	public void inputName(String nam) {
		name.sendKeys(nam);
	}
	
	public void inputEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void inputPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnCheckme() {
		checkMe.click();
	}
	
	public void inputGender(String input) {
		
		Select gender = new Select(genderDropdown); 
		gender.selectByVisibleText(input);
	}
	
	public void clickOnStudentRB() {
		studentRB.click();
	}
	
	public void clickOnEmployedRB() {
		employedRB.click();
	}
	
	public void inputBirthDate(String date) {
		bday.sendKeys(date);
	}
	
	public void ClickOnSubmit() {
		submitBtn.click();
	}
	
	public void inputDataBinding(String data) {
		dataBinding.sendKeys(data);
	}
	
	public String confirmMsg() {
		return successMsg.getText();
	}
	




}
