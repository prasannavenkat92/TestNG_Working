package org.Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCustomer extends Base{
	@BeforeClass
	public void driverInit() {
		getDriver();
		loadUrl("http://demo.guru99.com/telecom/");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		 WebElement cus= driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]"));
		 btnClick(cus);
	}
	
	@Test
	public void test1() {
		driver.findElement(By.xpath("//label[text()=\"Done\"]")).click();
		driver.findElement(By.id("fname")).sendKeys("Prasanna Venkatesan");
		driver.findElement(By.id("lname")).sendKeys("R");
		driver.findElement(By.id("email")).sendKeys("vrihero@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("Vriddhachalam");
		driver.findElement(By.id("telephoneno")).sendKeys("9940815294");
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.findElement(By.name("submit")).click();
	}
	
	@AfterClass
	public void afterClass() {
		Assert.assertTrue((driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed()));
		driver.quit();

	}

}
