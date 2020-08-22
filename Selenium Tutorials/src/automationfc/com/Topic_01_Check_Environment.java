package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Topic_01_Check_Environment {
	
WebDriver driver;
 
@BeforeClass
public void beforeClass() {
	System.setProperty("webdriver.chrome.driver",
            "F:\\HuongNT121\\Autotest\\Selenium\\Webdriver\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
driver.manage().window().maximize();
//driver.get("http://demo.guru99.com/v4/");
}
 
@Test
public void TC_01_ValidateCurrentUrl() {
//	/* Step1 - Truy cập vào trang: https://www.fahasa.com/customer/account/create
	driver.get("https://www.fahasa.com/customer/account/create");
//	 * Step2 - Navigate qua tab Đăng nhập
	sleepInSecond(2);
	driver.findElement(By.id("popup-login-tab_list")).click();
	sleepInSecond(2);
	WebElement loginButton = driver.findElement(By.cssSelector(".fhs-btn-login"));
//	 * Step3 - Verify "Đăng nhập" button là disabled
	boolean status = loginButton.isEnabled();
	System.out.println("Login status =" + status);
	Assert.assertFalse(status);
//	 * Step4 - Input dữ liệu hợp lệ vào textbox
	driver.findElement(By.cssSelector("#login_username")).sendKeys("huongtest@gmail.com");
	driver.findElement(By.cssSelector("#login_password")).sendKeys("huongtestcom");
	sleepInSecond(2);
//	 * Step5 - Verify "Đăng nhập" button là enabled
	status = loginButton.isEnabled();
	System.out.println("Login status = " + status);
	Assert.assertTrue(status);
//	 * Step8 - Click vào button "Đăng nhập"
	loginButton.click();
//	 * Step9 - Kiểm tra error message xuất hiện tại Email/Mật khẩu 
	String errorMessage = driver.findElement(By.cssSelector(".fhs-login-msg")).getText();
	sleepInSecond(2);
	System.out.println(errorMessage);
}
 
//@Test
//public void TC_02_ValidatePageTitle() {
//// Login Page title
//String loginPageTitle = driver.getTitle();
//Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
//}
// 
//@Test
//public void TC_03_LoginFormDisplayed() {
//// Login form displayed
//Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
//}
// 
//@AfterClass
//public void afterClass() {
//driver.quit();
//}
 public void sleepInSecond (long time){
	 try {
		Thread.sleep(10*100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}