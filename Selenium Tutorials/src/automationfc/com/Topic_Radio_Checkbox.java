package automationfc.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Topic_Radio_Checkbox {
	
WebDriver driver;
////Checkbox
//By firstCheckbox = By.xpath("//input[@value='Anemia']");
//By secondCheckbox = By.xpath("//input[@value='Asthma']");
//By threeCheckbox = By.xpath("//input[@value='Arthritis']");
//
////Radio
//By firstRadio = By.xpath("//input[@value='3-4 days']");
//By secondRadio = By.xpath("//input[@value='I have a strict diet']");
By allCheckboxes = By.xpath("//input[@value='checkbox']");
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
 
@Test
public void TC_01_Default_Radio_CheckBox() {
	driver.get("https://automationfc.github.io/multiple-fields/");
//Verify 3 first checkboxes deselected
//	Assert.assertFalse(driver.findElement(firstCheckbox).isSelected());
//	Assert.assertFalse(driver.findElement(secondCheckbox).isSelected());
//	Assert.assertFalse(driver.findElement(threeCheckbox).isSelected());
//	Assert.assertFalse(driver.findElement(firstRadio).isSelected());
//	Assert.assertFalse(driver.findElement(secondRadio).isSelected());
//	
//	driver.findElement(firstCheckbox).click();
//	driver.findElement(secondCheckbox).click();
//	driver.findElement(threeCheckbox).click();
//	driver.findElement(firstRadio).click();
//	driver.findElement(secondRadio).click();
//	Assert.assertTrue(driver.findElement(firstCheckbox).isSelected());
//	Assert.assertTrue(driver.findElement(secondCheckbox).isSelected());
//	Assert.assertTrue(driver.findElement(threeCheckbox).isSelected());
//	Assert.assertTrue(driver.findElement(firstRadio).isSelected());
//	Assert.assertTrue(driver.findElement(secondRadio).isSelected());
//	
	List<WebElement> checkboxes = (List<WebElement>) driver.findElement(allCheckboxes);
	for (WebElement checkbo : checkboxes) {
		checkbo.click();
		sleepInSecond(2);
	}
	for (WebElement checkbo : checkboxes) {
		Assert.assertTrue(checkbo.isSelected());
	}
	
	
}
@Test
public void TC_02_Custom_Radio_CheckBox() {
	driver.get("https://material.angular.io/components/checkbox/examples");
	By checkedbox = By.xpath("//span[contains(text(),'Checked')]/preceding-sibling::div/input");
	clickByJavascript(driver.findElement(checkedbox));
	sleepInSecond(2);
	Assert.assertTrue(driver.findElement(checkedbox).isSelected());
	
}
@AfterClass
public void afterClass() {
driver.quit();
}
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