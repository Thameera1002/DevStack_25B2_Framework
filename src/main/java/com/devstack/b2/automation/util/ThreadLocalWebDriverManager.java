package com.devstack.b2.automation.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.NoSuchDriverException;

public class ThreadLocalWebDriverManager {
    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();

    private static PropertyHandler propertyHandler = new PropertyHandler();

    public static WebDriver createDriver() {
        String browser = propertyHandler.getProperty("browser");
        WebDriver driver = switch (browser) {
            case "chrome" -> WebDriverManager.chromedriver().create();
            case "firefox" -> WebDriverManager.firefoxdriver().create();
            case "ie" -> WebDriverManager.iedriver().create();
            default -> throw new NoSuchDriverException("Unsupported browser: " + browser);
        };
        threadLocalWebDriver.set(driver);
        return driver;
    }
    public static WebDriver getDriver() {
        return threadLocalWebDriver.get();
    }
    public static void removeDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            threadLocalWebDriver.remove();
        }
    }

}
