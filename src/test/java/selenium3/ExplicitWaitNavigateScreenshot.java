package selenium3;

import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class ExplicitWaitNavigateScreenshot {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
		driver.get("https://freecrm.com/");
		/*driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.navigate().to("https://www.youtube.com/");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		takeScreenshot();
		driver.navigate().to("https://www.google.com");*/
		WebElement login = driver.findElement(By.xpath("//span[text()='Log In']"));
		clickOn(driver,20,login);
		//WebElement  search = driver.findElement(By.xpath("//div/input[@placeholder='Search']"));
		WebElement  search = driver.findElement(By.name("email"));
		
		sendKeys(driver, 20, search, "Sanyam Testing");
		
		takeScreenshot();

	}
	public static void takeScreenshot() throws IOException{
		Date date = new Date();
		String str = date.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fileSc = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileSc,new File("C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\screenshot\\screenshotTest_"+ str +".png"));
		
	}
	public static void sendKeys(WebDriver drive,int timeOutInSeconds, WebElement element, String text){
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	public static void clickOn(WebDriver driver,int timeOutInSeconds,WebElement element){
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
