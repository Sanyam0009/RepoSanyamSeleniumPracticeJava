package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

		Actions builder = new Actions(driver);
		// To Move to Dragable 1
		//builder.moveToElement(driver.findElement(By.xpath("//span[text()='Draggable 1']"))).build().perform();
		// builder.dragAndDrop(driver.findElement(By.xpath("//span[text()='Draggable
		// 1']")), driver.findElement(By.id("mydropzone"))).build().perform();
		builder.clickAndHold(driver.findElement(By.xpath("//span[text()='Draggable 2']")))
				.moveToElement(driver.findElement(By.id("mydropzone"))).release().build().perform();
	}
}
