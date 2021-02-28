package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverHeadless {

	public static void main(String[] args) {
		// not working
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		driver.findElement(By.cssSelector("a.btn btn-primary"));
		

	}

}
