package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHandle {
	static WebDriver driver;
	static String browserName = "chrome";

	public static void main(String[] args) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			// Chode to Invoke URL with chrome
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://ui.cogmento.com/");// to statrt the URL in
													// browser
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			driver.quit();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://ui.cogmento.com/");// to statrt the URL in
													// browser
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			driver.quit();
		}

	}

}
