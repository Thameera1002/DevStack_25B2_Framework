package com.devstack.b2.automation.testbase;

import com.devstack.b2.automation.reporter.ExtentReportManager;
import com.devstack.b2.automation.util.ThreadLocalWebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.logPass(result.getMethod().getMethodName()+ "passed.");
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = ThreadLocalWebDriverManager.getDriver();
        String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        ExtentReportManager.logFail(result.getMethod().getMethodName()+" failed.", screenshot);
    }

    public void onTestSkipped(ITestResult result) {
        WebDriver driver = ThreadLocalWebDriverManager.getDriver();
        String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        ExtentReportManager.logSkip(result.getMethod().getMethodName()+" skipped.", screenshot);
    }

    public void onStart(ITestContext context) {
        ExtentReportManager.initReport();
    }

    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }
}
