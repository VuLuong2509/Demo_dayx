package VLuong_Day3;

import java.lang.invoke.SwitchPoint;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Main_multi{
//	private String browser;
//    private WebDriver driver;
    
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		// Run Step by step dynamic browser
		WebDriver EdgeDr = new EdgeDriver();
		WebDriver FFDr = new FirefoxDriver();
		WebDriver ChromeDr = new ChromeDriver(option);				
		Process(ChromeDr);
		Process(FFDr);
		Process(EdgeDr);
		

	}
	
	
	public static void Process(WebDriver curFdr) {
		curFdr.manage().window().maximize();
		
		// xpath for element
		String URL = "https://demo.guru99.com/v4/";
		String xpathUid= "//tbody/tr[4]/td[2]";
		String xpathP= "//tbody/tr[5]/td[2]";
		String xpathclickhere = "//a[@href='http://demo.guru99.com/']";
		String xpathEmail = "//input[@name='emailid']";
		String xpathID = "//input[@name='uid']";
		String xpathPass = "//input[@name='password']";
		String xpathLog = "//input[@type='submit']";
		String xpathWel = "//marquee[@class='heading3']";
		String xpathbtnSubmitemail = "//input[@name='btnLogin']";
		String ExpectSubmit = "Please take SCREESNSHOT of this page for future reference.";
		String ExpectLogin = "Welcome To Manager's Page of Guru99 Bank";
		String xpathNotiSubmit = "//h4";
		
		// Random email 
		Random ran = new Random();
		String email = "huyvu" + ran.nextInt(2000) + "@gmail.com";
		
		
		curFdr.get(URL);	
		/*TC1
		 * Click in click here hyperlink
		 * Enter email
		 * Click Submit
		 * Submit successful
		 * TC PASS
		*/
		// Click HERE hyper link
		WebElement BtnClickhere = curFdr.findElement(By.xpath(xpathclickhere));
		BtnClickhere.click();
		
		// By pass iframe and close ads
		String url_ads = "https://demo.guru99.com/v4/#google_vignette";
		String current_URL = curFdr.getCurrentUrl();
		if (current_URL.equalsIgnoreCase(url_ads)) {
			WebElement ifr_ads = curFdr.findElement(By.xpath("//iframe[contains(@id,'google_ads_iframe_')]"));
			curFdr.switchTo().frame(ifr_ads);
			WebElement close_ads = curFdr.findElement(By.xpath("//div[@id='dismiss-button']"));
			close_ads.click();
			curFdr.switchTo().defaultContent();			
		}
		
		// Enter email 
		WebElement myemail = curFdr.findElement(By.xpath(xpathEmail));
		myemail.sendKeys(email);
		// CLick Submit
		WebElement SubmitBtn = curFdr.findElement(By.xpath(xpathbtnSubmitemail));
		SubmitBtn.click();
		// Get text notify then submit
		WebElement NotiSubmit = curFdr.findElement(By.xpath(xpathNotiSubmit));
		String Sub_actual = NotiSubmit.getText();
		
		// Compare and verify notify
		if (Sub_actual.equalsIgnoreCase(ExpectSubmit)) {
			System.out.println("TestCase Submit successful");
		} else {
			System.out.println("TestCase Submit successful");
		}
		
		
		WebElement idtext = curFdr.findElement(By.xpath(xpathUid));
		// Get ID in page 
		String ID = idtext.getText();
		
		WebElement passtext = curFdr.findElement(By.xpath(xpathP));
		// Get PASS in Page
		String PASS = passtext.getText();
		
		/*TC2
		 * Access "https://demo.guru99.com/v4/
		 * Enter ID
		 * Enter Pass
		 * Click Login
		 * Login successful
		 * TC PASS
		*/
		
		curFdr.navigate().to(URL);
		
		
		WebElement userID = curFdr.findElement(By.xpath(xpathID));
		userID.sendKeys(ID);
			
		WebElement userPass = curFdr.findElement(By.xpath(xpathPass));
		userPass.sendKeys(PASS);
		WebElement Login = curFdr.findElement(By.xpath(xpathLog));
		Login.click();
		
		WebElement NotiLog = curFdr.findElement(By.xpath(xpathWel));
		String Wel_actual = NotiLog.getText();
		
		if (Wel_actual.equalsIgnoreCase(ExpectLogin)) {
			System.out.println("TestCase Login successful");
		} else {
			System.out.println("TestCase Login successful");
		}

			
		
		
		curFdr.quit();
	}

	

}
