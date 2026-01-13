package rahulshettyacademy.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTests {
	
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initialiseDriver() throws IOException {

		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")
				+ "//src//main/java//rahulshettyacademy//resources//GlobalData.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initialiseDriver();
		landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
