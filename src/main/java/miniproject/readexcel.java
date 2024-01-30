package miniproject;
 
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class readexcel {
	public static String ReadExcel(int r,int c)throws IOException
	{
		String filepath = System.getProperty("user.dir")+"\\Excel\\TestData.xlsx";
		FileInputStream file=new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheetAt(0);
		String testData = String.valueOf(ws.getRow(r).getCell(c));
		wb.close();
		return testData;
	}
 
}