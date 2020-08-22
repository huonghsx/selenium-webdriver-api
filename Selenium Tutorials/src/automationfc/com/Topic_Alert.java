package automationfc.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Topic_Alert {
	
WebDriver driver;
Alert alert;

@BeforeClass
public void beforeClass() {
	System.setProperty("webdriver.chrome.driver",
            "F:\\HuongNT121\\Autotest\\Selenium\\Webdriver\\chromedriver.exe");
//	System.setProperty("webdriver.chrome.driver",
//            ".\\Webdriver\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
driver.manage().window().maximize();
//driver.get("http://demo.guru99.com/v4/");
}
 
//@Test
//public void TC_01_JavaScript_Alert() {
//	driver.get("http://demo.guru99.com/v4/index.php");
//	driver.findElement(By.name("btnLogin")).click();
//	sleepInSecond (2);
//	//Switch vao alert
//	alert = driver.switchTo().alert();
//	//Get text cua Alert
//	System.out.println("Alert text is :" + alert.getText());
//	//Accepted alert
//	alert.accept();
//
//}
@Test
public void TC_02_Custom_Alert() {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	//Switch to alert
	alert = driver.switchTo().alert();
	//Verify alert text
	Assert.assertEquals(alert.getText(), "I am a JS Alert");
	//Accepted Alert
	alert.accept();
	//Verify accepted Alert success
	//You clicked an alert successfully
	Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked an alert successfully");
	
	/*------------Alert Confirm------------*/
	driver.navigate().refresh();
	//I am a JS Confirm
	//You clicked: Cancel
	//Click for JS Confirm
	driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	alert = driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "I am a JS Confirm");
	alert.dismiss();
	Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
	
	/*------------Alert Prompt --------------------*/
	//Click for JS Prompt
	//I am a JS prompt
	//Automation
	//You entered: Automation
	
	driver.navigate().refresh();
	driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	alert = driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "I am a JS prompt");
	alert.sendKeys("Automation");
	sleepInSecond (3);
	alert.accept();
	Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Automation");
}
//@AfterClass
//public void afterClass() {
//driver.quit();
//}
public void clickByJavascript (WebElement element) {
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("arguments[0].click();", element);
	
}
 public void sleepInSecond (long time){
	 try {
		Thread.sleep(10*100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}