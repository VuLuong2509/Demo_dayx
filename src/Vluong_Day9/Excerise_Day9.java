package Vluong_Day9;

import java.io.File;

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
		//Ex.SendMulImage();
		Ex.downLoadimage();
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
	btnadd.sendKeys(currentDir + upload1 + "\n" + currentDir + upload2 + "\n" + currentDir + upload3);
	//btnadd.sendKeys("D:\\Automation Selenium\\Exercise_Day3\\ImageLibraries\\meme.jpg \n D:\\Automation Selenium\\Exercise_Day3\\ImageLibraries\\unnamed.png \n D:\\Automation Selenium\\Exercise_Day3\\ImageLibraries\\nani.jpg");
	//btnadd.sendKeys("C:\\Users\\VuLuong\\Desktop\\meme.jpg \n C:\\Users\\VuLuong\\Desktop\\unnamed.png \n C:\\Users\\VuLuong\\Desktop\\nani.jpg");
	
	
		
	}

public void downLoadimage() {
	String url = "https://the-internet.herokuapp.com/download";
	//xpath
	String downLoad = "//a[text()='some-file.txt']";
	
	WebDriver driver;
	CommonServicePage cmSerive = new CommonServicePage();
	driver = cmSerive.RunDriver("firefox", url);
	
	WebElement atDown = driver.findElement(By.xpath(downLoad));
	String filenamest1 = atDown.getText();
	atDown.click();
	//Load folder ImageLibraries
	File folder = new File(System.getProperty("user.dir")+ File.separator + "ImageLibraries");
	File[] listItemOffile = folder.listFiles();
	
	for (File listOfFile : listItemOffile) {
		if (listOfFile.isFile()) {
			String fileName = listOfFile.getName();
			System.out.println("File " + fileName);
			if (fileName.equalsIgnoreCase(filenamest1)) {
				System.out.println("Found....");
				listOfFile.deleteOnExit();
				break;
			}
		}
	}
	
	driver.quit();
}

}
