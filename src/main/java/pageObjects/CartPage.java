package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	long total = 0;
	int j=0;

	@FindBy(css = ".btn-danger")
	WebElement remove;

	@FindBy(css = ".btn-default")
	WebElement continueShoppingBtn;

	@FindBy(css = ".btn-success")
	WebElement checkoutBtn;

	@FindBy(xpath = "//h4[@class='media-heading']/a")
	WebElement cartItems;

	@FindBy(xpath = "//td[4][@class='col-sm-1 col-md-1 text-center']")
	List<WebElement> itemPrice;

	@FindBy(xpath = "//td[5][@class='text-right']/h3")
	WebElement totalPrice;
	
	@FindBy(xpath = "//h4[@class='media-heading']")
	List<WebElement> productName;

	public long getTotalPrice() {
		for (int i = 0; i <= itemPrice.size(); i++) {
			
			String[] price = itemPrice.get(i).getText().split(".");
			long formattedPrice = Long.parseLong(price[1]);			
			total = formattedPrice + total;
		}

		return total;
	}

	public void clickOnRemove() {
		remove.click();
	}

	public void clickOnContinueShopping() {
		continueShoppingBtn.click();
	}

	public void clickOnCheckout() {
		checkoutBtn.click();
	}

	public long getGrandTotal() {
		long total = Long.parseLong(totalPrice.getText());
		return total;
	}
	
	public boolean productInsideCart(String[] itemsNeeded) {
		List<String> itemsName = Arrays.asList(itemsNeeded);
		for(int i=0; i<=productName.size(); i++) {
			if(productName.contains(itemsName)) {
				j++;
				if(j == productName.size()) {
					return true;
				}
			}
		}
		return false;
	}


}
