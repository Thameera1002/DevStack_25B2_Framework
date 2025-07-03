package com.devstack.b2.automation.functions.commons;

import com.devstack.b2.automation.functions.FunctionBase;
import com.devstack.b2.automation.pages.commons.PG_Login;
import com.devstack.b2.automation.reporter.ExtentReportManager;
import org.openqa.selenium.WebDriver;

public class LIB_Common extends FunctionBase {

    public PG_Login pg_login;

    public LIB_Common(WebDriver driver) {
        super(driver);
        pg_login = new PG_Login(driver);
    }

    public void bc_Login(String userName, String password) {
        ExtentReportManager.writeToReport("Start of bc_Login");
        pg_login.fillUserName(userName);
        pg_login.fillPassword(password);
        pg_login.clickLogin();
        ExtentReportManager.writeToReport("End of bc_Login");
    }
}
