package selenium3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicXpathAndFindElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Sanyam");
		driver.findElement(By.xpath("//input[contains(@name,'last_n')]")).sendKeys("Choudhary");
		driver.findElement(By.xpath("//input[starts-with(@name,'ema')]")).sendKeys("scsanyam52@gmail.com");
		;
		driver.findElement(By.xpath("//input[contains(@name,'hone')]")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@name='address' and contains(@class,'form-control')]"))
				.sendKeys("My Home");
		System.out.print(driver.findElement(By.xpath("//label[text()='City']")).isDisplayed());
		
		driver.findElement(By.xpath("//input[contains(@name, 'city' )]")).sendKeys("Pune");
		Select select = new Select(driver.findElement(By.xpath("//select[@name = 'state']")));
		select.selectByVisibleText("Alaska");
		
		driver.findElement(By.xpath("//input[@name='hosting' and @value='no']")).click();
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Testing Selenium");
		
		//driver.findElement(By.xpath("//button[text()='Send ']")).click();
		// To Get Number of Links and there Name
		List<WebElement> listLink = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links = " + listLink.size());
		for(int i=0;i<listLink.size();i++){
			if(!(listLink.get(i).getText().equalsIgnoreCase(""))){
				System.out.println(listLink.get(i).getText());
			}
			
		}
	}

}
