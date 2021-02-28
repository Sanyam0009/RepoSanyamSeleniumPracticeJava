package selenium3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	
	
	public static void main(String[] args) throws IOException {
		//File file = new File("C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\Data\\TestData.properties");
		//FileInputStream fis = new FileInputStream(file);
		//******************Above 2 lines or we can use bewlo on line by directly passing path String*********8
		FileInputStream fis =new FileInputStream("C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\Data\\TestData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		
		String url = prop.getProperty("url");
		System.out.println(url);
		
		Properties prop1 = new Properties();
		prop1.setProperty("place", "Pune");
		prop1.setProperty("Car", "BMW");
		prop1.save(new FileOutputStream("C:\\Users\\$akshi\\workspace\\SeleniumPracticeJava\\Data\\Output.properties"), "Practice");
	}

}
