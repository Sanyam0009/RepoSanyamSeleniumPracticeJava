package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameWebElementsTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'W3Schools
		// Free Online Web Tutorials')]")));
		driver.switchTo().frame(1);
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("argument[0].click();",
		// driver.findElement(By.xpath("//div/a[contains(@title,'Search
		// W3Schools')]")));
		driver.findElement(By.xpath("//div/a[contains(@title,'Search W3Schools')]")).click();
	}

}
