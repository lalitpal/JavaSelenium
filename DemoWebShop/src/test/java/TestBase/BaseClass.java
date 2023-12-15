package TestBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public ResourceBundle rb;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		
		if(br.equals("chrome")) {
			
			driver = new ChromeDriver();
		}
		
		else if(br.equals("edge")) {
			
			driver = new EdgeDriver();
		}
		
		else if(br.equals("firefox")) {
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.get(rb.getString("webURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
