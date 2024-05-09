package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "#country")
	WebElement countryDropdown;
	
	@FindBy(xpath = "(//label[@for='checkbox2'])[1]" )
	WebElement iAgreeCheckbox;
	
	@FindBy(className = "btn-success")
	WebElement purchaseBtn;
	
	@FindBy(xpath = "//div[@class='suggestions']/ul/li/a")
	List<WebElement> suggestion;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement confirm;
	
	By country = (By.xpath("//div[@class='suggestions']/ul/li"));
	
	public void clickOnCheckbox() {
		iAgreeCheckbox.click();
	}
	
	public void clickOnPurchase() {
		purchaseBtn.click();
	}
	
	public String confirmMsg() {
		return confirm.getText();
	}
	
	public void selectCountry(String countryInitials) throws InterruptedException {
		countryDropdown.sendKeys(countryInitials);
		waitForVisibilityOfElement(country);
		for(int i=0; i<=suggestion.size(); i++) {
			if(suggestion.get(i).getText().equalsIgnoreCase("India")) {
				suggestion.get(i).click();
			}
		}
		
	}

}
