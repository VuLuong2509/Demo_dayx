package CommonService;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonServicePage {
	public WebDriver RunDriver(String browser, String url) {
		
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")){
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(option);
		}



		driver.get(url);
		//Mazimize current window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45)); 

		return driver;

	}

}
