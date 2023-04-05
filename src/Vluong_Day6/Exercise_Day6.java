package Vluong_Day6;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise_Day6 {
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver Chdriver = new ChromeDriver(option);				
		Process(Chdriver);
		System.out.println("Chrome Done");
		WebDriver FFdriver = new FirefoxDriver();
		Process(FFdriver);
		System.out.println("FireFox Done");
		WebDriver Eddriver = new EdgeDriver();
		Process(Eddriver);
		System.out.println("Edge Done");
		
	}
	
	public static void Process(WebDriver Driver) {
		Driver.manage().window().maximize();
	
		//xpath
		String xpathtit = "//select[@id='user_title']";
		String xpathFname = "//input[@id='user_firstname']";
		String xpathSurname = "//input[@id='user_surname']";
		String xpathPne = "//input[@id='user_phone']";
		// xpath Data of Birth
		String xpathyear = "//select[@id='user_dateofbirth_1i']" ;
		String xpathmont = "//select[@id='user_dateofbirth_2i']";
		String xpathDay = "//select[@id='user_dateofbirth_3i']";
		String xpathF = "//input[@id='licencetype_t']";
		String xpathPro = "//input[@id='licencetype_f']";
		String xpathLiPe = "//select[@id='user_licenceperiod']";
		String xpathopt = "//select[@id='user_occupation_id']";
		// xpath Address
		String xpathStr = "//input[@name='street']";
		String xpathCi = "//input[@name='city']";
		String xpathCo = "//input[@name='county']";
		String xpathPcode = "//input[@name='post_code']";
		String xpathEm = "//input[@name='email']";
		String xpathPass = "//input[@name='password']";
		String xpathCpass = "//input[@name='c_password']";
		String xpathCr = "//input[@name='submit']";
		String xpathlog = "//a[@class='btn btn-default']";
		// xpath Login
		String xpathEmlog = "//input[@name='email']";
		String xpathPLog = "//input[@name='password']";
		String xpathBlogin = "//input[@name='submit']";
		// xpath page
		String xpathPage = "//div[@class='ui-tabs-panel ui-widget-content ui-corner-bottom']";
		String ExpectSubmit = "Broker Insurance WebPage";
		//Url
		String URL = "https://demo.guru99.com/insurance/v1/register.php";
		
		//Action
		Driver.get(URL);
		//Random value
		Random ran = new Random();
		Integer eran = ran.nextInt(25); 
		//Select Title
		WebElement ETitle = Driver.findElement(By.xpath(xpathtit));
		Select seTitle = new Select(ETitle);
		seTitle.selectByVisibleText("Mr");
		//input Firstname
		WebElement EFname = Driver.findElement(By.xpath(xpathFname));
		EFname.sendKeys("Vu");
		//input Surname
		WebElement ESname = Driver.findElement(By.xpath(xpathSurname));
		ESname.sendKeys("Luong Quang Huy");
		//input Phone
		WebElement Ephone = Driver.findElement(By.xpath(xpathPne));
		Ephone.sendKeys("0906543219");
		//select year
		WebElement Eyear = Driver.findElement(By.xpath(xpathyear));
		Select seYear = new Select(Eyear);
		seYear.selectByVisibleText("1993");
		//select month
		WebElement Emonth = Driver.findElement(By.xpath(xpathmont));
		Select semonth = new Select(Emonth);
		semonth.selectByVisibleText("September");
		//select Day
		WebElement Eday = Driver.findElement(By.xpath(xpathDay));
		Select seDay = new Select(Eday);
		seDay.selectByVisibleText("25");
		//Click Full radiobutton
		WebElement Efull = Driver.findElement(By.xpath(xpathF));
		Efull.click();
		//select Licence Period
		WebElement ELiPer = Driver.findElement(By.xpath(xpathLiPe));
		Select seLiPer = new Select(ELiPer);
		seLiPer.selectByIndex(eran);
		//select Occupation
		WebElement EOcc = Driver.findElement(By.xpath(xpathopt));
		Select seOcc = new Select(EOcc);
		seOcc.selectByIndex(eran);
		//input Street
		WebElement Estr = Driver.findElement(By.xpath(xpathStr));
		Estr.sendKeys("HongBang");
		//input City
		WebElement ECity = Driver.findElement(By.xpath(xpathCi));
		ECity.sendKeys("HCM");
		//input country
		WebElement ECon = Driver.findElement(By.xpath(xpathCo));
		ECon.sendKeys("VietNam");
		//input Post code
		WebElement Ecode = Driver.findElement(By.xpath(xpathPcode));
		Ecode.sendKeys("70000");
		//input email
		WebElement Email = Driver.findElement(By.xpath(xpathEm));
		String email = "huyvu" + ran.nextInt(2000) + "@gmail.com";
		Email.sendKeys(email);
		//input Password
		WebElement Epass = Driver.findElement(By.xpath(xpathPass));
		Epass.sendKeys("Toivaot@12345");
		//input CPassword
		WebElement ECpass = Driver.findElement(By.xpath(xpathCpass));
		ECpass.sendKeys("Toivaot@12345");
		//Click create
		WebElement ECre = Driver.findElement(By.xpath(xpathCr));
		ECre.click();
		//login email
		WebElement LogE = Driver.findElement(By.xpath(xpathEmlog));
		LogE.sendKeys(email);
		//login Pass
		WebElement LogP = Driver.findElement(By.xpath(xpathPLog));
		LogP.sendKeys("Toivaot@12345");
		//click login
		WebElement Clogin = Driver.findElement(By.xpath(xpathBlogin));
		Clogin.click();
		//Verify login successfully
		WebElement Subnoti = Driver.findElement(By.xpath(xpathPage));
		String Sub_actual = Subnoti.getText(); 
		if (Sub_actual.equalsIgnoreCase(ExpectSubmit)) {
			System.out.println("Submit login successful");
		} else {
			System.out.println("Submit Login Fail");
		}
		
		Driver.quit();
	}
	

}
