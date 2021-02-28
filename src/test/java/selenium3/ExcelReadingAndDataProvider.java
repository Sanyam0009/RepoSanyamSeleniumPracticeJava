package selenium3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ExcelReadingAndDataProvider {
	@Test(priority=1,dataProvider="getDatafromExcel")
	public void useDataProviderTesting(String title,String firstname, String lastname, String company){
		System.out.println(title + "--" + firstname + "--" + lastname + "--" + company);
	}

	@DataProvider
	public Object[][] readData() throws FileNotFoundException{
		Object[][] data = ExcelReadingAndDataProvider.getDatafromExcel();
		return data;
		
	}
	private static HSSFWorkbook workbook;
	private static HSSFSheet sheet;
	//private static Workbook workbook;
	//private static Sheet sheet;
	@DataProvider
	public static Object[][] getDatafromExcel() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/testdata/PracticeTestData.xls");
		//or
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\PracticeTestData.xls");
		try {
			workbook = new HSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = workbook.getSheet("contacts");
		Object[][] obj = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() +"--"+ sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				obj[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return obj;
	}

}
