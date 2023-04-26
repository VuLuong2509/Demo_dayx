package Vluong_Day11;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Excercise_Day11 {
	
	
	@Test 
	public void Userregister(){
		String url = "https://www.demoblaze.com/index.html";
		Random ran = new Random();
		Integer Ranuser = ran.nextInt(1000);

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver Driver = new ChromeDriver(option);	
		Driver.get(url);
		Driver.manage().window().maximize();
		
	
		
		WebElement clickbtnSignUp = Driver.findElement(By.xpath("//a[@id='signin2']"));
		clickbtnSignUp.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement EntUser = Driver.findElement(By.xpath("//input[@id='sign-username']"));
		EntUser.sendKeys("toivaot" + Ranuser);
		
		WebElement EntPass = Driver.findElement(By.xpath("//input[@id='sign-password']"));
		EntPass.sendKeys("auto1047");
		
		WebElement ClickbtnRegister = Driver.findElement(By.xpath("//button[@onclick='register()']"));
		ClickbtnRegister.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alertDialog = Driver.switchTo().alert();		
		String alertText = alertDialog.getText();		
		String Alert = "Sign up successful.";

		org.testng.Assert.assertEquals(alertText, Alert);

		
		Driver.quit();
	}

}
