package com.webautomation.tests.stg;

import com.webautomation.base.CommonToAllTests;
import com.webautomation.pages.pagefactory.LoginPageFactory;
import com.webautomation.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class VWOLoginUsingPFSTG extends CommonToAllTests {

    @Test()
    public void loginTestVWONegative1() throws InterruptedException {
        LoginPageFactory pf = new LoginPageFactory(getDriver());
        String expectedErrorMessage = PropertyReader.getData("LoginPage_Error_Message");
        String actualErrorMessage = pf.loginUsingInValidCredentials("STG",PropertyReader.getData("InValid_Username"),PropertyReader.getData("InValid_Password"));
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        Thread.sleep(2500);
    }

}
