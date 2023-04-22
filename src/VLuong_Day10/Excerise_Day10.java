package VLuong_Day10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonService.CommonServicePage;

public class Excerise_Day10 {
	static CommonServicePage page;
	public static void main(String[] args) {
		Excerise_Day10 EX = new Excerise_Day10();
		page = new CommonServicePage();
		EX.ProcessJavaScript();
		
	}
	
	public void ProcessJavaScript() {
		String url = "http://the-internet.herokuapp.com/dynamic_controls";
		//xpath
		String xpathbtnDis = "(//button)[2]";
		String xpathmess = "//p[@id='message']";
		String xpathfield = "//input[@type='text']";
		WebDriver driver;
		CommonServicePage cmpage = new CommonServicePage();
		driver = cmpage.RunDriver("chrome", url);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		

		WebElement clickBtn = driver.findElement(By.xpath(xpathbtnDis));
				
		js.executeScript("arguments[0].click();", clickBtn);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String checkbtn = (String) js.executeScript("return arguments[0].value", clickBtn);
//		System.out.println(checkbtn);
		
		
		
		//set value an print for field
		WebElement setText = driver.findElement(By.xpath(xpathfield));
		String setF = (String) js.executeScript("return arguments[0].value='Hello'", setText);
		String checkF = (String) js.executeScript("return arguments[0].value", setText);
		System.out.println(checkF);
		
		
//		WebElement messText = driver.findElement(By.xpath(xpathmess));
//		String test = messText.getText();
//		String checkmes= (String) js.executeScript("return arguments[0].value", messText);
//		System.out.println(test);
		

		driver.quit();
	}
	

}
