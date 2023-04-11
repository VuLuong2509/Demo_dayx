package Vluong_Day7;

import java.sql.Driver;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonService.CommonServicePage;
import io.netty.util.internal.logging.CommonsLoggerFactory;

public class Exercise_Day7 {
	static CommonServicePage Page;
	public static void main(String[] args) {
		Exercise_Day7 Ex = new Exercise_Day7();
		Page = new CommonServicePage();
		Ex.Process("chrome", "Products Comparison List - Magento Commerce");	
	}
	
	public void Process(String browser,String title) {
		//xpath
		String xpathhrefMobile = "//a[contains(text(),'Mobile')]";
		String xpathAtoCSS = "(//a[@class='link-compare'])[1]";
		String xpathAtoCSN = "(//a[@class='link-compare'])[2]";
		String xpathAtoCSP = "(//a[@class='link-compare'])[3]";
		String xpathBtCom = "//button[@title='Compare']";
		String xpathClosetab = "//button[@title='Close Window']";
		String Titlepage = "Mobile";
		String Titlepage2 = "Products Comparison List - Magento Commerce";
		
		String url = "http://live.guru99.com/index.php/";
		WebDriver Driver = Page.RunDriver(browser, url);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement nlinkMo = Driver.findElement(By.xpath(xpathhrefMobile));
		nlinkMo.click();
		
		WebElement AddComSS = Driver.findElement(By.xpath(xpathAtoCSS));
		AddComSS.click();
		
		WebElement AddComSN = Driver.findElement(By.xpath(xpathAtoCSN));
		AddComSN.click();
		
		WebElement CBtnCom = Driver.findElement(By.xpath(xpathBtCom));
		CBtnCom.click();

		String CntWin = Driver.getWindowHandle();
		Set<String> windows = Driver.getWindowHandles();
		
		for (String str : windows) {
			Driver.switchTo().window(str); //ma windown
			System.out.println(str);
			if (Driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement clsTab = Driver.findElement(By.xpath(xpathClosetab));
		clsTab.click();
		
		Driver.switchTo().window(CntWin);
		
//		WebElement iphone = Driver.findElement(By.xpath(xpathAtoCSP));
//		iphone.click();
		
		if (Driver.getTitle().equalsIgnoreCase(Titlepage)) {
			System.out.println("Switch to Parent Window Successfuly");
		} else {
			System.out.println("Switch to Parent Window FAIL");

		}
		
		Driver.quit();
	}
	



}
