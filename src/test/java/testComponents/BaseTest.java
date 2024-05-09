package testComponents;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class BaseTest {
	
	private static final int HashMap = 0;
	public WebDriver driver;
	public ResourceBundle rb;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void setup(String br) {
		
		rb = ResourceBundle.getBundle("utilties.config");
		
		if (br.equals("chrome")){
			
			driver = new ChromeDriver();	
		
		else if(br.equals("edge")){
			driver = new EdgeDriver();
		}
		
		driver.get(rb.getString("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.close();
	}
	
	public String getScreenshot(String testname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+ "//reports//" + testname + ".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+ "//src//test//java//report" + testname + ".png";
		
	}
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException{
		
		//read Json to String
		
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//STring to Hashmap - Jackson Databing
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
		
	}
	
public static void checkBrokenLink(String linkUrl) throws IOException {
		
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode() >=400) {
				System.out.println(linkUrl +" --> "+ httpUrlConnection.getResponseMessage()+ "is a broken link");
			}else {
				System.out.println(linkUrl+" --> "+ httpUrlConnection.getResponseMessage());
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
