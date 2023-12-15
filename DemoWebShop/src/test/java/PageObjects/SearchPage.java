package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	WebElement titles = (WebElement) (By.xpath("//div[@class = 'product-item']/div/h2/a"));
	
	
		}
	}

}
