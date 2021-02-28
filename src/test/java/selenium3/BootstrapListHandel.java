package selenium3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapListHandel {
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
		driver.get("https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html");

	}

	@Test
	public void bootStrapListSelect() {
		selectBoot("Vestibulum at eros");
	}
	
	public void selectBoot(String listItem){

		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='dual-list list-left col-md-5']//ul[@class='list-group']/li"));
		for (int i = 0; i <= list.size() - 1; i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals(listItem)) {
				list.get(i).click();
				driver.findElement(By.xpath("//button[contains(@class,'btn btn-default btn-sm move-right')]")).click();
			}
		}
	}

}
