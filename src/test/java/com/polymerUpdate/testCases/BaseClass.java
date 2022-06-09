package com.polymerUpdate.testCases;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.polymerUpdate.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String UserName = readconfig.getUsername();
	public String Password = readconfig.getPassword();
	public String usrname = readconfig.getLoginUsrname();
	public String pswrd = readconfig.getLoginPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		logger = Logger.getLogger("PUBeta");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireforxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		try {
			 String pass = URLEncoder.encode(pswrd, "utf8");
				String URL = "https://" + usrname + ":" + pass + "@" + baseURL;
				driver.get(URL);
				
	     } catch (Exception e) {
	         System.out.println(e.getMessage());
	     }

	
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
public String randomstring() {
		
		String generatedstring = RandomStringUtils.randomAlphabetic(15);
		return(generatedstring);
	}
	
	public static String randomNum() {
		String generatedSring2 = RandomStringUtils.randomNumeric(20);
		return(generatedSring2);
	}
	
}
