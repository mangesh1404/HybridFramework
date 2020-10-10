package com.jbk.hybrid.utility;

import java.io.FileInputStream;
import java.util.Properties;

import com.jbk.hybrid.testcases.TestBase;

public class PropertiesUtility extends TestBase {
	FileInputStream fis = null;
	static Properties prop = null;
	
	public PropertiesUtility() {
		log.info("initializing config properties file");
		try {
			
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources" + "/config.properties");
			prop = new Properties();
			prop.load(fis);
			log.info("initializied config properties file");
		} catch (Exception e) {
			log.info("property file is not initialized");
		}
	}
	
	
	
	public String readAnyProperty(String propName) {
		String val = null;
		try {
			log.info("reading a property from config.properties file");
			val = prop.getProperty(propName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

}
