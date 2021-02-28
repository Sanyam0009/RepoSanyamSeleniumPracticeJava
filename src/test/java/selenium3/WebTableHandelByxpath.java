package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTableHandelByxpath {
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://ui.cogmento.com/");
	}

	@Test(priority = 1)
	public void readWebTableWay1() throws InterruptedException {

		driver.findElement(By.name("email")).sendKeys("scsanyam52@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Sanyam09");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();

		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[text()='New']"))).build().perform();

		Thread.sleep(4000);
		String beforeXpath = "//*[@id='main-content']//table/tbody/tr[";
		String AfterXpath = "]/td[2]";

		for (int i = 1; i <= 5; i++) {
			String tablerow = beforeXpath + i + AfterXpath;
			System.out.println(driver.findElement(By.xpath(tablerow)).getText());
			String name = driver.findElement(By.xpath(tablerow)).getText();
			if (name.equalsIgnoreCase("Sakshi verma")) {
				driver.findElement(By.xpath("//*[@id='main-content']//table/tbody/tr[" + i + "]/td[1]")).click();

			}
		}

	}

	@Test(priority = 2)
	public void readWebTableWay2() {
		clickOnCheckBoxInTable("Sanyam");
		clickOnCheckBoxInTable("Swarnima");

	}

	public void clickOnCheckBoxInTable(String name) {
		// "//input[@name='id']"
		try {
			WebElement tableDesiredCheckbox = driver
					.findElement(By.xpath("//a[contains(text(),'" + name + "')]/parent::td/preceding-sibling::td/div"));
			tableDesiredCheckbox.click();
			WebElement tableNextColumn = driver.findElement(
					By.xpath("//a[contains(text(),'"+name+"')]/parent::td/following-sibling::td/following-sibling::td"));
			System.out.println(name + " is - " + tableNextColumn.getText());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			Assert.assertTrue(false, "Unable to Find the given contact - " + name);

		}
	}

}
