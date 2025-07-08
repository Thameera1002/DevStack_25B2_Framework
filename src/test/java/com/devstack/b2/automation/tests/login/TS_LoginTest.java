package com.devstack.b2.automation.tests.login;

import com.devstack.b2.automation.functions.commons.LIB_Common;
import com.devstack.b2.automation.model.TS_LoginTestModel;
import com.devstack.b2.automation.tests.BaseTest;
import com.devstack.b2.automation.util.ExcelHandler;
import org.testng.annotations.Test;

public class TS_LoginTest extends BaseTest {

//    @Test
//    public void tc_testSuccessfulLogin() {
//        LIB_Common common = new LIB_Common(driver);
//        common.bc_SuccessLogin("admin", "pointofsale");
//    }
//
//    @Test
//    public void tc_testFailedLogin() {
//        LIB_Common common = new LIB_Common(driver);
//        common.bc_FailLogin("admin", "pointofsale");
//    }

    @Test(dataProvider = "commonDataProvider", dataProviderClass = ExcelHandler.class)
    public void tc_testSuccessfulLogin(TS_LoginTestModel model) {
        LIB_Common common = new LIB_Common(driver);
        common.bc_SuccessLogin(model.getUserName(), model.getPassword());
    }
}
