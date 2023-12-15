package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement login;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath = "//input[@id='small-searchterms']")
	WebElement search;
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchBtn;
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
		
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickOnRegister() {
		register.click();
	}
	
	public void inputOnSearchBar(String para) {
		search.sendKeys(para);
	}

}
