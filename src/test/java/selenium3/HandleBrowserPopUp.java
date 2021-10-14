package selenium3;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserPopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.findElement(By.partialLinkText("Follow On Twitter")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindow = it.next();
		String chieldWindow = it.next();
		System.out.println("Window URL - " + driver.getCurrentUrl());
		driver.switchTo().window(chieldWindow);
		System.out.println("Chiled Window URL - " + driver.getCurrentUrl());
		driver.switchTo().window(parentWindow);
		System.out.println("TestParent Window Title - " + driver.getTitle());
		driver.switchTo().window(chieldWindow);
		driver.close(); // To Close the current Window
		driver.switchTo().window(parentWindow);
		driver.findElement(By.partialLinkText("Like us On Facebook")).click();
		driver.quit();
		

		
		

	}

}
