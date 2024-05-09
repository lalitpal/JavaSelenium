package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class BrokenLinks extends BaseTest{
	
	@Test
	public void checkBrokenLinks() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No. of LInks present" +  links.size());
		
		List<String> urlList = new ArrayList<String>();
		
		for(WebElement e : links) {
			String url = e.getAttribute("href");
			urlList.add(url);
			
		}
		urlList.parallelStream().forEach(s -> {
			try {
				checkBrokenLink(s);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
	}

}
