package selenium3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindBrokenLinks {
	@Test
	public void checkBrokenLinks() throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		//To  get all the Links with <a> tag
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// TO add all the links with <img> tag (ar as image)
		links.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getAttribute("href") != null) {
				activeLinks.add(links.get(i));
			}
		}
		for (int j = 0; j < activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "=====>" + response);
		}
	}
}
