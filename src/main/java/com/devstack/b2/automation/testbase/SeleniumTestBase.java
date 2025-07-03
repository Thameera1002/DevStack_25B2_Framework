package com.devstack.b2.automation.testbase;

import com.devstack.b2.automation.reporter.ExtentReportManager;
import com.devstack.b2.automation.util.ThreadLocalWebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTestBase {
    protected static WebDriver driver;

    public SeleniumTestBase(WebDriver driver) {
        this.driver = ThreadLocalWebDriverManager.getDriver();
    }

    public void click(By locator) {
        try{
            WebElement webElement = waitForVisibilityOfElement(locator, 10);
            webElement.click();
            ExtentReportManager.logPass("Clicked in locator : " + locator);
        } catch (Exception e) {
            ExtentReportManager.logFail("No such element: " + locator,"");
        }

    }
    public void type(By locator, String inputText){
        try {
            WebElement webElement = waitForVisibilityOfElement(locator, 10);
            webElement.click();
            webElement.clear();
            webElement.sendKeys(inputText);
            ExtentReportManager.logPass("Typed [ "+inputText+" ] in locator : " + locator);
        }catch (Exception e){
            ExtentReportManager.logFail("No such element: " + locator,"");
        }

    }

    public static WebElement waitForVisibilityOfElement(By locator,long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
}
