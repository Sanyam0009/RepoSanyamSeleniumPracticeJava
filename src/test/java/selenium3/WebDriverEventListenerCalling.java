package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class WebDriverEventListenerCalling {
	@Test
	public void testingWebDriverEventListner(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		WebEventListnerTesting eventListener = new WebEventListnerTesting(); //Creating object of class which implemented WebDriverEventListener
		ef.register(eventListener);
		ef.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ef.get("https://freecrm.com/");
		
		System.out.println(ef.getTitle());
		System.out.println(ef.getCurrentUrl());
		ef.findElement(By.xpath("//span[text()='Log In']")).click();
	}
}
