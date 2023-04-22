package CommonService;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

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
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "ImageLibraries");
			
			ChromeOptions option = new ChromeOptions();
			option.setExperimentalOption("prefs", chromePrefs);
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		} else if(browser.equalsIgnoreCase("firefox")) {
			HashMap<String, Object> firefoxPrefs = new HashMap<String, Object>();
			firefoxPrefs.put("profile.default_content_settings.popups", 0);
			firefoxPrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "ImageLibraries");
	
			driver = new FirefoxDriver();
		} else {
			HashMap<String, Object> EdgePrefs = new HashMap<String, Object>();
			EdgePrefs.put("profile.default_content_settings.popups", 0);
			EdgePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "ImageLibraries");
			EdgeOptions option = new EdgeOptions();
			option.setExperimentalOption("prefs", EdgePrefs);
			
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
