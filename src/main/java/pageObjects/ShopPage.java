package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	int j=0;

	@FindBy(xpath = "//a[normalize-space()='Shop']")
	WebElement shop;

	@FindBy(xpath = "//h4[@class='card-title']/a")
	List<WebElement> productTitles;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	List<WebElement> add;
	
	@FindBy(xpath = "//a[@class='nav-link btn btn-primary']")
	WebElement checkout;
	
	@FindBy(xpath = "//body//app-root//app-card")
	List<WebElement> productCard;

	public void clickOnShop() {
		shop.click();
	}
	
	public void clickOnCheckout() {
		checkout.click();
	}

	public void addProductToCart(String[] itemsNeeded) {
		List<String> items = Arrays.asList(itemsNeeded);
		waitForVisibilityOfAllElement(productCard);

		String product = null;
		for (int i = 0; i <= productTitles.size(); i++) {
			product = productTitles.get(i).getText();

			if (items.contains(product)) {
				add.get(i).click();
				j++;
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
