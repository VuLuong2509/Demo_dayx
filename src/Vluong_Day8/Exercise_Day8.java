package Vluong_Day8;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CommonService.CommonServicePage;

public class Exercise_Day8 {
	static CommonServicePage page;
	public static void main(String[] args) {
		Exercise_Day8 Ex = new Exercise_Day8();
		page = new CommonServicePage();
		//lesson 1
		Ex.DragCircle();
		//lesson 2
		Ex.grid();
		//lesson 3
		Ex.sendImage();
	}
	
	//lesson 1
	public void DragCircle() {
		String url = "https://demos.telerik.com/kendo-ui/dragdrop/index";
		String messSuccess = "You did great!";
		//xpath
		String xpathMiniCr = "//div[@id='draggable']";
		String xpathLagCr = "//div[@id='droptarget']";
		
		//Action
		WebDriver driver;
		CommonServicePage cmSerive = new CommonServicePage();
		driver = cmSerive.RunDriver("chrome", url);
		
		WebElement Crsmall = driver.findElement(By.xpath(xpathMiniCr));
		WebElement CrBig = driver.findElement(By.xpath(xpathLagCr));
		
		Actions Act = new Actions(driver);
		
		Act.clickAndHold(Crsmall).pause(Duration.ofSeconds(2)).moveToElement(CrBig).pause(Duration.ofSeconds(2)).release().build().perform();
		WebElement Mess = driver.findElement(By.xpath(xpathLagCr));
		String confirmMess = Mess.getText();
		
		if (confirmMess.equalsIgnoreCase(messSuccess)) {
			System.out.println("Drag and Drop successful");
		} else {
			System.out.println("Drag and Drop Fail");
		}
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.quit();
	}
	//lesson 2
	public void grid() {
		String url = "https://jqueryui.com/resources/demos/selectable/display-grid.html";
		//xpath
		String xpathst1 = "//li[text()='%s']";
		//Action
		WebDriver driver;
		CommonServicePage cmSerive = new CommonServicePage();
 		driver = cmSerive.RunDriver("firefox", url);
		
		//Random number
		Random ran = new Random();
		Integer stRan1 = ran.nextInt(12)+1;
		Integer stRan2 = ran.nextInt(12)+1;
		if (stRan1 == stRan2) {
			stRan1 = ran.nextInt(12)+1;
		} else {
		}
		System.out.println(stRan1);
		System.out.println(stRan2);
		WebElement moveStran1 = driver.findElement(By.xpath(String.format(xpathst1, stRan1)));
		WebElement moveStran2 = driver.findElement(By.xpath(String.format(xpathst1, stRan2)));
		
		
		Actions Act2 = new Actions(driver);
		Act2.clickAndHold(moveStran1).pause(Duration.ofSeconds(2)).moveToElement(moveStran2).pause(Duration.ofSeconds(2)).release().build().perform();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
	//lesson 3
	public void sendImage() {
		String url = "https://the-internet.herokuapp.com/upload";
		String Mess = "File Uploaded!";
		//xpath
		String xpathChos = "//input[@id='file-upload']";
		String xpathUp = "//input[@id='file-submit']";
		String xpathDrop = "//div[@id='drag-drop-upload']";
		String xpathMess = "//h3[contains(text(),'File Uploaded!')]";
		//Actoion
		WebDriver driver;
		CommonServicePage cmSerive = new CommonServicePage();
 		driver = cmSerive.RunDriver("ed", url);
 		
 		WebElement btnChos = driver.findElement(By.xpath(xpathChos));
 		String currentDir = System.getProperty("user.dir");
 		btnChos.sendKeys(currentDir + "/ImageLibraries/meme.jpg");
 		
 		WebElement btnUp = driver.findElement(By.xpath(xpathUp));
 		btnUp.click();
 		
 		WebElement curMess = driver.findElement(By.xpath(xpathMess));
 		String getMess = curMess.getText();
 		if (getMess.equalsIgnoreCase(Mess)) {
			System.out.println("Upload Successful");
		} else {
			System.out.println("Upload Fail");

		}
 		
 		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		driver.quit();
	}

}
