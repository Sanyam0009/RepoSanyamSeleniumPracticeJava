package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelJavaScriptAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		System.out.println(alert.getText());
		alert.accept();

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Alert alertOkCancel = driver.switchTo().alert();
		Thread.sleep(5000);
		System.out.println(alertOkCancel.getText());
		alertOkCancel.dismiss();

		driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
		Alert alertEnter = driver.switchTo().alert();
		System.out.println(alertEnter.getText());
		alertEnter.sendKeys("SanyamJi");
		alertEnter.accept();

	}

}
