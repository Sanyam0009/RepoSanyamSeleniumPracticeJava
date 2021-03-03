package selenium3;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SikuliDemo {
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup(); // used boni garcia depedency
		// to replace
		// System.setProperty part
		// so it will be dynamic and
		// we will not have to give
		// driver path
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/");

	}
	@Test
	public void sikuliAction() throws FindFailed, InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("btn_basic_example")));
		Thread.sleep(5000);
		if(driver.findElement(By.id("at-cv-lightbox-close")).isDisplayed()){
			driver.findElement(By.id("at-cv-lightbox-close")).click();
			System.out.println("closed popup");
		}
		
		String sikuliImgDir = System.getProperty("user.dir") + "\\sikuliImages\\";
		Screen screen = new Screen();
		Pattern pattern =new Pattern(sikuliImgDir + "StartPractice.PNG");
		screen.wait(pattern, 20);
		screen.click();
		
	}
}
