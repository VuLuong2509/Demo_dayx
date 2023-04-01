package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise_Day5 {
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
//		WebDriver EdgeDr = new EdgeDriver();
//		WebDriver FFDr = new FirefoxDriver();
		WebDriver ChromeDr = new ChromeDriver(option);				
		Process(ChromeDr);
//		Process(FFDr);
//		Process(EdgeDr);
		
	}
	
	
	public static void Process(WebDriver curDriver) {		
		String URL = "https://chandanachaitanya.github.io/selenium-practice-site/";
		String URL2 = "https://the-internet.herokuapp.com/iframe";
		//Xpath Element
		String xpathraBtn = "//input[@id='self-help-radio-btn']";
		String xpathDrdown = "//select[@id='selenium_suite']";
		String xpathtextB = "//body[@id='tinymce']";
		String xpathIframe = "//iframe[@id='mce_0_ifr']";
		
		curDriver.get(URL);
		// Click radio button and print the result
		WebElement clickraBtn = curDriver.findElement(By.xpath(xpathraBtn));
		clickraBtn.click();
		if (clickraBtn.isSelected()) {
			System.out.println("Test case radio button PASS and Selected");
		} else {
			System.out.println("Test case radio button Fail and Un-Select");
			
		}
		
		// Select dropdown and print the result
		WebElement SelectDrd = curDriver.findElement(By.xpath(xpathDrdown));
		Select seDrd = new Select(SelectDrd);
		seDrd.selectByVisibleText("Selenium RC");
		System.out.println(seDrd.getFirstSelectedOption().getText());
		
		
		curDriver.get(URL2);
		// Exercise iframe
		
		// switch to iframe
		WebElement iframe = curDriver.findElement(By.xpath(xpathIframe));
		curDriver.switchTo().frame(iframe);
		// input value in textbox
		WebElement EnTexbox = curDriver.findElement(By.xpath(xpathtextB));
		// Clear value
		EnTexbox.clear();
		EnTexbox.sendKeys("Hello");
		System.out.println(EnTexbox.getText()); 
		
		curDriver.switchTo().defaultContent();
		curDriver.quit();
	}
	
	
	
	
	
	
	
		
	


}
