package com.devstack.b2.automation.tests.login;

import com.devstack.b2.automation.functions.commons.LIB_Common;
import com.devstack.b2.automation.tests.BaseTest;
import org.testng.annotations.Test;

public class TS_LoginTest extends BaseTest {

    @Test
    public void tc_testSuccessfulLogin() {
        LIB_Common common = new LIB_Common(driver);
        common.bc_SuccessLogin("admin", "pointofsale");
    }

    @Test
    public void tc_testFailedLogin() {
        LIB_Common common = new LIB_Common(driver);
        common.bc_FailLogin("admin", "pointofsale");
    }
}
