package VLuong_Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
	public static void main(String[] args) {
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--remote-allow-origins=*");
//		WebDriver ChromeDr = new ChromeDriver(option);
		WebDriver FDr = new FirefoxDriver();
		
		
		String URL = "https://demo.guru99.com/v4/";
		String xpathclickhere = "//a[@href='http://demo.guru99.com/']";
		String xpathEmail = "//input[@name='emailid']";
		String xpathID = "//input[@name='uid']";
		String xpathPass = "//input[@name='password']";
		String xpathLog = "//input[@type='submit']";
		String xpathWel = "//marquee[@class='heading3']";
		String username = "mngr487896";
		String userpass = "mypevem";
		String xpathbtnSubmitemail = "//input[@name='btnLogin']";
		String ExpectSubmit = "Please take SCREESNSHOT of this page for future reference.";
		String ExpectLogin = "Welcome To Manager's Page of Guru99 Bank";
		String xpathNotiSubmit = "//h4";
		
		FDr.get(URL);
		
		/*TC1
		 * Click in click here hyperlink
		 * Enter email
		 * Click Submit
		 * Submit successful
		 * TC PASS
		*/
		
		WebElement BtnClickhere = FDr.findElement(By.xpath(xpathclickhere));
		BtnClickhere.click();
		
		WebElement myemail = FDr.findElement(By.xpath(xpathEmail));
		myemail.sendKeys("huyvu2509@gmail.com");
		
		WebElement SubmitBtn = FDr.findElement(By.xpath(xpathbtnSubmitemail));
		SubmitBtn.click();
		
		WebElement NotiSubmit = FDr.findElement(By.xpath(xpathNotiSubmit));
		String Sub_actual = NotiSubmit.getText();
		
		if (Sub_actual.equalsIgnoreCase(ExpectSubmit)) {
			System.out.println("TC Submit Thanh Cong");
		} else {
			System.out.println("TC Submit That Bai");
		}
		
		/*TC2
		 * Access "https://demo.guru99.com/v4/
		 * Enter ID
		 * Enter Pass
		 * Click Login
		 * Login successful
		 * TC PASS
		*/
		
		FDr.get(URL);
		
		WebElement userID = FDr.findElement(By.xpath(xpathID));
		userID.sendKeys(username);
		
		WebElement userPass = FDr.findElement(By.xpath(xpathPass));
		userPass.sendKeys(userpass);
		
		WebElement Login = FDr.findElement(By.xpath(xpathLog));
		Login.click();
		
		WebElement NotiLog = FDr.findElement(By.xpath(xpathWel));
		String Wel_actual = NotiLog.getText();
		
		if (Wel_actual.equalsIgnoreCase(ExpectLogin)) {
			System.out.println("TC Login Thanh Cong");
		} else {
			System.out.println("TC Login That Bai");
		}

		
		FDr.quit();
	}

}
