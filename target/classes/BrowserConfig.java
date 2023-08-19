package Config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageFactory.GreenKart.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfig {
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		return driver;		
		
	}
	
	@BeforeMethod
	public LandingPage LandingApplication() {
		driver = LaunchBrowser();
		landingPage = new LandingPage(driver);
		landingPage.GoTo();
		return landingPage;
		
	}
	
//	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
