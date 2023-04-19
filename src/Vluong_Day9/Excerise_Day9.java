package Vluong_Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonService.CommonServicePage;
import Vluong_Day8.Exercise_Day8;

public class Excerise_Day9 {
	static CommonServicePage page;
	public static void main(String[] args) {
		Excerise_Day9 Ex = new Excerise_Day9();
		page = new CommonServicePage();
		Ex.SendMulImage();
		
	}
	
public void SendMulImage(){
	String url = "https://blueimp.github.io/jQuery-File-Upload//";
	
	//xpath
	String xpathAfile = "//input[@type='file']";
	String xpathStartup = "//i[@class='glyphicon glyphicon-upload']";
	
	WebDriver driver;
	CommonServicePage cmSerive = new CommonServicePage();
	driver = cmSerive.RunDriver("chrome", url);
	WebElement btnadd = driver.findElement(By.xpath(xpathAfile));
		
	String currentDir = System.getProperty("user.dir");
	String upload1 = "/ImageLibraries/meme.jpg";
	String upload2 = "/ImageLibraries/unnamed.png";
	String upload3 = "/ImageLibraries/nani.jpg";
	
	
	System.out.println(currentDir);
	
	btnadd.sendKeys("D:\\Automation Selenium\\Exercise_Day3\\ImageLibraries\\meme.jpg \n D:\\Automation Selenium\\Exercise_Day3\\ImageLibraries\\unnamed.png \n D:\\Automation Selenium\\Exercise_Day3\\ImageLibraries\\nani.jpg");
	//btnadd.sendKeys("C:\\Users\\VuLuong\\Desktop\\meme.jpg \n C:\\Users\\VuLuong\\Desktop\\unnamed.png \n C:\\Users\\VuLuong\\Desktop\\nani.jpg");
	
	
		
	}

public void downLoadimage() {
	
	
	
	
}

}
