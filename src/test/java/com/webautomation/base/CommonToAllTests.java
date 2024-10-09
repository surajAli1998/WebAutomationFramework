package com.webautomation.base;

import com.webautomation.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTests extends CommonToAllPage {

    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }

}
