package selenium3;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchDynamicHandle {
	public WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void dynamicGoogleSearch() throws InterruptedException{
		driver.findElement(By.name("q")).sendKeys("Java");
		Thread.sleep(2000);
		//List<WebElement> list = driver.findElements(By.xpath("//ul[@class='erkvQe']/li/div"));
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='erkvQe']/li/descendant::div[@class='sbtc']"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equalsIgnoreCase("Java Interview questions")){
				System.out.println(list.get(i).getText());
				list.get(i).click();
				break;
			}
			
		}
		
		
	}
}
