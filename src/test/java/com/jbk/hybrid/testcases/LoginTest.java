package com.jbk.hybrid.testcases;

import java.util.List;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jbk.hybrid.utility.ExcelUtility;
import com.jbk.hybrid.utility.PropertiesUtility;

public class LoginTest extends TestBase {

	PropertiesUtility proputils=null;
	@BeforeSuite
	public void loadUrl() {
	proputils=new PropertiesUtility();
		log.info("starting before suite");
		log.info("calling initialization method from super class");
		initialization();
	}
	@Test
	public void loginUsingProperties() {
		log.info("enetring username");
		driver.findElement(By.id("email")).sendKeys(proputils.readAnyProperty("uname"));
		log.info("entering password");
		driver.findElement(By.id("password")).sendKeys(proputils.readAnyProperty("password"));
		log.info("clicking a login button");
		driver.findElement(By.xpath("//button")).click();
	}
	@Test
	public void loginUsingExcel() throws Exception {
		log.info("enetring username");
		
		String uname= ExcelUtility.getData("TestData.xls", "Login", 0, 0);
		
		String password=ExcelUtility.getData("TestData.xls", "Login", 0, 1);
		
		driver.findElement(By.id("email")).sendKeys(uname);
		log.info("entering password");
		driver.findElement(By.id("password")).sendKeys(password);
		log.info("clicking a login button");
		driver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	
	
/*
	@Test(priority = 1, dataProvider = "dpLoginData")
	public void checkLoginData(String id, String decr, String uname, String pswd, String msg) {
		wd.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uname);
		wd.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		wd.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pswd);
		wd.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		wd.findElement(By.xpath("//button")).click();
		if (!decr.equals("VALID")) {
			String actMsg = wd.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
			System.out.println(actMsg);
			String expMsg = "Please enter email.";
			Assert.assertEquals(actMsg, expMsg);
		} else {
			String actUrl = wd.getCurrentUrl();
			System.out.println(actUrl);
			String expUrl = "file:///C:/Users/abc/Desktop/java/Offline%20website/pages/examples/dashboard.html";
			Assert.assertEquals(actUrl, expUrl);
		}
	}

	@DataProvider
	public Object[][] dpLoginData() {
		return new Object[][] { new Object[] { "ID01", "BLANK", "", "", "Please enter email and pswd" },
				new Object[] { "ID02", "INVALID", "fggh", "fghj", "Please enter correct email and pswd" },
				new Object[] { "ID03", "VALID", "kiran@gmail.com", "123456",
						"file:///C:/Users/abc/Desktop/java/Offline%20website/pages/examples/dashboard.html" }, };
	}*/

}
