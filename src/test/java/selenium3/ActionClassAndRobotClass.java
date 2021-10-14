package selenium3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassAndRobotClass {
	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

		Actions builder = new Actions(driver);
		WebElement button = driver.findElement(By.partialLinkText("Alerts & Modals"));
		builder.doubleClick(button).build().perform();
		// builder.keyDown(button, Keys.LEFT); // Just for practice
		
		// builder.moveToElement(driver.findElement(By.xpath("//span[text()='Draggable 1']"))).build().perform();
		
		/* builder.dragAndDrop(driver.findElement(By.xpath("//span[text()='Draggable
		 1']")), driver.findElement(By.id("mydropzone"))).build().perform(); */
		
		/*builder.clickAndHold(driver.findElement(By.xpath("//span[text()='Draggable 2']")))
				.moveToElement(driver.findElement(By.id("mydropzone"))).release().build().perform();*/

		Robot robot = new Robot();
		robot.mouseMove(20, 50);
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		//BUTTON3_DOWN_MASK - For Left Click
		//BUTTON2_DOWN_MASK - For Midddle wheel click
		//BUTTON1_DOWN_MASK - For Right click
		
		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
		robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		System.out.println("Done");
	}
}
