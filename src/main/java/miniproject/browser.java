package miniproject;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.openqa.selenium.edge.EdgeDriver;
 
 
public class browser 
{
	public static WebDriver driver;

 
	public static WebDriver setDriver()
	{
		try
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Dropdown\n");
			System.out.println("Which browser would you like to execute the script on? \n" 
				+"1.Google Chrome \n"
				+"2.Microsoft Edge");
			int browserChoice = scan.nextInt();
			scan.close();
 
			if (browserChoice == 1) 
			{
				driver = setChromeDriver();
			} 
			else if(browserChoice == 2)
			{
				driver=setEdgeDriver();			
			} 
			
			else 
			{
				System.out.println("Invalid data...");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}
 
	
	public static WebDriver setChromeDriver() 
	{
		try
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}

 

	// Setting up Microsoft Edge Driver
	public static WebDriver setEdgeDriver() 
	{
		try
		{
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}
 
	/*
	 * getUrl - > get the URL for automation testing from a Configure.properties file located 
	 * inside of Properties folder inside project root
	 */
	
	public static void getUrl() throws Exception
	{
		try
		{
			String filelocation = System.getProperty("user.dir") + "\\Properties\\Configure.properties";
			File file = new File(filelocation);
			FileInputStream fileinput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileinput);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
 
	/*
	 *  Close the Browser 
	 */
	
	public static void closeBrowser() 
	{
		//driver.quit();
	}
}
