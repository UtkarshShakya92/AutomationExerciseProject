package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public static WebDriver driver; 
	public Logger logger; 
	public Properties p;
	
	@BeforeClass
	public void setUp() throws IOException
	{
	  logger = LogManager.getLogger(this.getClass());	
	  
      FileReader file = new FileReader(".//src//test//resources//config.properties");
	  p = new Properties();
	  p.load(file);
	  
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.get(p.getProperty("appurl"));
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  
	}
	
	//@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
