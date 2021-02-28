package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DifferentLocatorInSelenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");

		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		//xpath
		
		WebElement uname = driver.findElement(By.xpath("//input[@name='email']"));
		//name
		WebElement password = driver.findElement(By.name("password"));

		uname.sendKeys("scsanyam52@gmail.com");
		password.sendKeys("Sanyam09");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		//linkText
		System.out.println(
				"Free Account Link Displayed - " + driver.findElement(By.linkText("Free account")).isDisplayed());
		//partialLinkText
		System.out.println("Free Account Partial Link Displayed - "
				+ driver.findElement(By.partialLinkText("Free")).isDisplayed());
		//className
		driver.findElement(By.className("menu-item-wrapper")).click();
		//cssSelector
		//driver.findElement(By.cssSelector("div.menu-item-wrapper")).click();
		driver.findElement(By.xpath("//i[@class='calendar icon']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'ui linkedin button')]")).click();
		
		//driver.quit();
		
		WebElement category = driver.findElement(By.name("category"));
		Select selectCategory = new Select(category);
		selectCategory.selectByValue("Critical");
	}

}
