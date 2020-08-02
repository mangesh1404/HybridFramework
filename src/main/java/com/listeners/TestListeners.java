package com.listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.jbk.hybrid.testcases.TestBase;
import com.jbk.hybrid.utility.ScreenShotUtils;


public class TestListeners  implements ITestListener{

	public void onFinish(ITestContext arg0) {
		//logger statements
	}

	public void onStart(ITestContext arg0) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		TestBase.log.info("testcase is failed with name: "+result.getName());
		TestBase.log.info("capturing a screenshot for failed test case");
		try {
			ScreenShotUtils.getScreenshot(TestBase.driver, "Project-");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		TestBase.log.info("testcase is skipped with name: "+result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		TestBase.log.info("testcase is started with name: "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		TestBase.log.info("testcase is passed with name: "+result.getName());
		
	}

	

}
