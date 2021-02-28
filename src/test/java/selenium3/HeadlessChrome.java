package selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeadlessChrome {
	
	@Test
	public void headlessChromeTest(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		//options.addArguments("window-size=1400,800");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.seleniumeasy.com/test/");
		System.out.println(driver.getTitle());
				
	}

}
