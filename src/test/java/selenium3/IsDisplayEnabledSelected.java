package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IsDisplayEnabledSelected {
	
	@Test
	public void check(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
		System.out.println("isDisplayed - " + driver.findElement(By.name("first_name")).isDisplayed());
		System.out.println("isEnabled - " + driver.findElement(By.name("first_name")).isEnabled());
		
		System.out.println("Placeholder fatched by getAttribute - " + driver.findElement(By.name("first_name")).getAttribute("placeholder"));
		// is Selected used for only Checkbox , Radio button and Dropdown
		System.out.println("isSelected before - " + driver.findElement(By.xpath("//input[@value='no']")).isSelected());
		driver.findElement(By.xpath("//input[@value='no']")).click();
		System.out.println("isDisplayed After - " + driver.findElement(By.xpath("//input[@value='no']")).isSelected());
		
	}

}
