package com.devstack.b2.automation.testbase;

import com.devstack.b2.automation.util.PropertyHandler;
import com.devstack.b2.automation.util.ThreadLocalWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SeleniumTestBaseHelper {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        this.driver = ThreadLocalWebDriverManager.createDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(PropertyHandler.getProperty("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        ThreadLocalWebDriverManager.removeDriver();
    }
}
