package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecuterWithSelenium {
	public static JavascriptExecutor js;
@Test
public void testPerform() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://freecrm.com/");
	js = (JavascriptExecutor) driver;
	WebElement button = driver.findElement(By.xpath("//span[text()='Log In']"));
	//highlight(driver,button); // To Highliht the Element
	//drawBorder(driver,button); // TO drw a border around element
	js.executeScript("alert('1st popup by Javascript')");// To show javascript alert box
	Thread.sleep(2000); 
	driver.switchTo().alert().accept();
/*	TO pass multiple lines as script (Multiple lines will be seprated by ; (Semi couln)  
	but in case of single line script it is  optoonal to put ; (semicolon) at the end of the script argument.
	In case of multiple lines also,after the last script line it is optional to put ;(semi colon).
	We can pass as many numbver of arguments we want to pass as shownn in below example and can use them in script
	as arguments[0] arguments[1] and arguments[2] and so on.
	js.executeScript(script1;script2;script3;,arg1,arg2,arg3);*/
	js.executeScript("alert('2nd Popup by Javascript');arguments[0].style.border = '3px solid blue'",button);
	driver.switchTo().alert().accept();
	js.executeScript("arguments[0].click()",button); // TO Click by js
	js.executeScript("history.go(0)"); // To referesh
	System.out.println(js.executeScript("return document.title").toString()); // To get document title by js
	js.executeScript("arguments[0].setAttribute('value','scsanyam52@gmail.com')", driver.findElement(By.name("email"))); // To set any attribue here weet value
	js.executeScript("arguments[0].setAttribute('value',arguments[1])", driver.findElement(By.name("password")),"Sanyam09"); //TO set attribute and By passing values through ardument
	js.executeScript("window.scrollTo(0,document.body.scrollHight)"); // To scroll to end of page
	driver.navigate().to("https://www.w3schools.com/");
	js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//img[@alt='Colorpicker']")));// To scroll to perticuler element given
}

public static void highlight(WebDriver driver, WebElement element){
	 js = (JavascriptExecutor) driver;
	String bgColor = element.getCssValue("backgroundColor");
	System.out.println("Color is - " + bgColor);
	for (int i = 0; i < 100; i++) {
		js.executeScript("arguments[0].style.backgroundColor = 'rgb(0,300,0)';", element);
		js.executeScript("arguments[0].style.backgroundColor = '" + bgColor + "';", element);
	}	
}

public void drawBorder(WebDriver driver, WebElement element){
	
	js.executeScript("arguments[0].style.border = '3px solid green';", element);
}
}
