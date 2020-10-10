package com.jbk.hybrid.testcases;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.jbk.hybrid.utility.PropertiesUtility;


public class TestBase {
	FileInputStream fis = null;
	//Properties prop;
	public static WebDriver driver;
	public static Logger log=Logger.getLogger(TestBase.class);
	PropertiesUtility proputils=null;
	
	

	public void initialization() {
		proputils=new PropertiesUtility();
		log.info("opening a browser");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		log.info("initializing chrome browser");
		driver = new ChromeDriver();
		log.info("browser launched");
		log.info("launching offline website");
		driver.get(proputils.readAnyProperty("url"));
		log.info("maximising a browser");
		driver.manage().window().maximize();
	}

}
