package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestClass {
public static WebDriver cd;
public Logger logger;//log4j
public Properties properties;
	 
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException  {
		
		FileInputStream file=new FileInputStream("./src//test//resources//config.properties");//read file from properties file
		properties=new Properties();
		properties.load(file);//load file
		
		logger=LogManager.getLogger(this.getClass());//log4j

		switch(br) {
		case "chrome": cd=new ChromeDriver();
		break;
		case "firefox": cd=new FirefoxDriver();
		break;
		case "edge": cd=new EdgeDriver();
		break;
		default: System.out.println("Invalid Browser name"); 
		return;
		
		}
		
		cd.manage().window().maximize();
		cd.get(properties.getProperty("appURL")); //read url from properties file
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		cd.quit();
		
	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(10);
		
		
	}
	public String randomNumbers() {
		return RandomStringUtils.randomNumeric(10);
		
		
	}
	public String captureScreen (String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) cd;

		File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);

		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}
	

}
