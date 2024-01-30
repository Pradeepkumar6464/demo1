package miniproject;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class Dropdown extends browser{

	public static void main(String[] args) throws Exception {
		setDriver();
		getUrl();		
		closeBrowser() ;

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/form/div[2]/div/a/u")).click();
        WebElement name=driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input"));
        name.sendKeys(readexcel.ReadExcel(0, 0));
        driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys(readexcel.ReadExcel(1, 0));
        driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")).click();
        //Thread.sleep(3000);
        //implict functions 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> radios = driver.findElements(By.xpath("//*[@id=\"radio_login\"]"));
        for(WebElement radio : radios)
        {
        	radio.click();
        	if(radio.isSelected()) {
        		System.out.println("Radio button is Selected");
        	}
        	else {
        		System.out.println("Radio button is not Selected");
        	}
        	break;
        }
        driver.findElement(By.xpath("//*[@id=\"newpasswd\"]")).sendKeys(readexcel.ReadExcel(2, 0));
        driver.findElement(By.xpath("//*[@id=\"newpasswd1\"]")).sendKeys(readexcel.ReadExcel(3, 0));
        WebElement id=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input"));
        id.click();
        Select date=new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")));
        date.selectByVisibleText("20");
        Select month=new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")));
        month.selectByVisibleText("JUN");
        Select year=new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")));
        year.selectByVisibleText("2000");
        WebElement c=driver.findElement(By.xpath("//*[@id=\"country\"]"));
        c.click();
        
        Select sc=new Select(driver.findElement(By.xpath("//*[@id='country']")));
       List<WebElement> opt=sc.getOptions();
       for(WebElement i:opt)
       {
    	   System.out.println(i.getText());
    	   
       }
      sc.selectByVisibleText("India");
      String str=sc.getFirstSelectedOption().getText();       
      System.out.println(opt.size());
      System.out.println(str); 
      if(str.equals("India")) {
    	  System.out.println("Pass");
    	  
      }
      else {
    	  System.out.println("Fail");
      }

      
      	}

}
